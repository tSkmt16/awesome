package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DrinkNowLogic;
import model.FavoriteBeverage;
import model.LoadDrinkNow;
import model.LoadFavoriteBeverage;
import model.Record;
import model.StandardValue;
import model.StandardValueCalc;
import model.ToUnits;

@WebServlet("/DrinkNowServlet")
public class DrinkNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		String pageName = "これから飲む";
		session.setAttribute("pageName", pageName);

		LocalDate ldToday = LocalDate.now();
		LocalDate ldNextDay = 	ldToday.plus(Period.ofDays(1));
		session.setAttribute("ldToday", ldToday.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		session.setAttribute("ldNextDay", ldNextDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

		// day_recordsテーブルから体調「わるい」「とてもわるい」になる基準値を取得
		StandardValueCalc svcBO = new StandardValueCalc();
		StandardValue standardValue = null;
		standardValue = svcBO.execute(user_id);
		double badValue = standardValue.getBadValue();
		double verybadValue = standardValue.getVerybadValue();
		// 単位変換して スコープへ保存
		ToUnits toUnits = new ToUnits();
		session.setAttribute("badValue", toUnits.execute(badValue));
		session.setAttribute("verybadValue", toUnits.execute(verybadValue));
		// 比較・計算のためにdouble型でも保存
		session.setAttribute("doubleBadValue", badValue);
		session.setAttribute("doubleVerybadValue", verybadValue);

		//DBからお気に入り飲料を抽出し、ドロップダウンリストへ格納する準備
		FavoriteBeverage favBev = new FavoriteBeverage(user_id);
		LoadFavoriteBeverage lfbBO = new LoadFavoriteBeverage();
		favBev = lfbBO.execute(user_id);

		Map<String, Double> mapFavBev = new LinkedHashMap<String, Double>();
		mapFavBev.put(favBev.getNo1_bev_name(), favBev.getNo1_abv());
		mapFavBev.put(favBev.getNo2_bev_name(), favBev.getNo2_abv());
		mapFavBev.put(favBev.getNo3_bev_name(), favBev.getNo3_abv());
		mapFavBev.put(favBev.getNo4_bev_name(), favBev.getNo4_abv());
		mapFavBev.put(favBev.getNo5_bev_name(), favBev.getNo5_abv());
		session.setAttribute("mapFavBev", mapFavBev);

		//day_recordsテーブルを参照し、当日の飲酒データがある場合はページ反映
		LoadDrinkNow ldnBO = new LoadDrinkNow();
		Record result = ldnBO.execute(user_id);
		if (result != null) {
			Date date = result.getDate();
			double alcohol_intake = result.getAlcohol_intake();
			double liquid_intake = result.getLiquid_intake();
			int condition = result.getCondition();

			// (計算用)double型のままリクエストスコープ保存
			request.setAttribute("doubleAlcohol_intake", alcohol_intake);
			request.setAttribute("doubleLiquid_intake", liquid_intake);
			// (画面出力用)単位をつけてString型変換してリクエストスコープへ保存
			request.setAttribute("alcohol_intake", toUnits.execute(alcohol_intake));
			request.setAttribute("liquid_intake", toUnits.execute(liquid_intake));
			// セッションスコープに保存　　消してOK？確認中・・・
			session.setAttribute("date", date);
			session.setAttribute("alcohol_intake", alcohol_intake);
			session.setAttribute("liquid_intake", liquid_intake);
			session.setAttribute("condition", condition);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/drinkNow.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープからuser_id, date, alcohol_intake, liquid_intake, mapFavBev取得
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		Date date = (Date) session.getAttribute("date");
		double alcohol_intake = (double) session.getAttribute("alcohol_intake");
		double liquid_intake = (double) session.getAttribute("liquid_intake");

		//お気に入り飲料のMapを取得
		@SuppressWarnings("unchecked")
		Map<String, Double> mapFavBev = (Map<String, Double>) session.getAttribute("mapFavBev");

		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("beverages").length() != 0 && request.getParameter("amount").length() != 0) {

			String beverage = request.getParameter("beverages");
			//Mapからkey(飲料名)でitem(アルコール度数)取得
			double alcoholDegree = mapFavBev.get(beverage);

			//総量・アルコール量の増減差分
			double diffLiquid = Double.parseDouble(request.getParameter("amount"));
			double diffAlcohol = diffLiquid * alcoholDegree;

			//飲み物と容量の選択を保持するためにセッションスコープ保存
			session.setAttribute("selectBeverage", beverage);
			session.setAttribute("selectAmount", diffLiquid);

			request.setCharacterEncoding("UTF-8");
			String selectedButton = request.getParameter("countButton");

			if (selectedButton.equals("up")) { //「+1」ボタン
				alcohol_intake = alcohol_intake + diffAlcohol;
				liquid_intake = liquid_intake + diffLiquid;
			} else if (selectedButton.equals("down")) { //「-1」ボタン
				alcohol_intake = alcohol_intake - diffAlcohol;
				liquid_intake = liquid_intake - diffLiquid;
				if (alcohol_intake < 0) {
					alcohol_intake = 0;
				}
				if (liquid_intake < 0) {
					liquid_intake = 0;
					alcohol_intake = 0;
				}
			}

			//セッションスコープの値を更新
			//			session.removeAttribute("alcohol_intake");
			//			session.removeAttribute("liquid_intake");
			session = request.getSession();
			session.setAttribute("alcohol_intake", alcohol_intake);
			session.setAttribute("liquid_intake", liquid_intake);

			// (計算用)double型のままリクエストスコープ保存
			request.setAttribute("doubleAlcohol_intake", alcohol_intake);
			request.setAttribute("doubleLiquid_intake", liquid_intake);
			// (画面出力用)単位をつけてString型変換してリクエストスコープへ保存
			ToUnits toUnits = new ToUnits();
			request.setAttribute("alcohol_intake", toUnits.execute(alcohol_intake));
			request.setAttribute("liquid_intake", toUnits.execute(liquid_intake));

			Record record = new Record(user_id, date, alcohol_intake, liquid_intake);
			DrinkNowLogic bo = new DrinkNowLogic();
			boolean result = bo.execute(record);

			if (result) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/drinkNow.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationCheck.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/drinkNow.jsp");
			dispatcher.forward(request, response);
		}

	}

}
