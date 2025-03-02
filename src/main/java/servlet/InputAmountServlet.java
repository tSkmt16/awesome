package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConvertConditionLogic;
import model.FavoriteBeverage;
import model.InputAmountLogic;
import model.LoadDrinkNow;
import model.LoadFavoriteBeverage;
import model.LoadInputAmount;
import model.Record;
import model.ToUnits;

@WebServlet("/InputAmountServlet")
public class InputAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		String pageName = "これから飲む";
		session.setAttribute("pageName", pageName);

		// DBからお気に入り飲料を抽出し、ドロップダウンリストへ格納
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

		// day_recordsテーブルを参照し、当日の飲酒データがある場合はページ反映
		LoadDrinkNow ldnBO = new LoadDrinkNow();
		Record result = ldnBO.execute(user_id);
		if (result != null) {
			Date date = result.getDate();
			double alcohol_intake = result.getAlcohol_intake();
			double liquid_intake = result.getLiquid_intake();
			int condition = result.getCondition();

			// セッションスコープに保存
			session.setAttribute("date", date);
			session.setAttribute("alcohol_intake", alcohol_intake);
			session.setAttribute("liquid_intake", liquid_intake);
			session.setAttribute("condition", condition);
		}

		// 杯数(本数)のドロップダウンリスト用にArrayListを作成しセッションスコープ保存
		ArrayList<Integer> cups = new ArrayList<Integer>();
		for (int i = 0; i <= 20; i++) {
			cups.add(i);
		}
		session.setAttribute("cups", cups);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inputAmount.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		if (request.getParameter("selectedDate") != null) { // 日付選択後に更新ボタンをクリックした際の処理
			// if (request.getParameter("reload") != null) { // 日付選択後に更新ボタンをクリックした際の処理
			String strTargetDate = request.getParameter("selectedDate");
			Date targetDate = Date.valueOf(strTargetDate);

			// session.setAttribute("targetDate", targetDate.toString());
			session.setAttribute("targetDate", targetDate);

			Record record = new Record(user_id, targetDate);
			LoadInputAmount bo = new LoadInputAmount();
			Record result = bo.execute(record);

			ConvertConditionLogic ccLogic = new ConvertConditionLogic();
			ToUnits toUnits = new ToUnits();

			if (result != null) {
				request.setAttribute("targetLiquidIntake", toUnits.execute(result.getLiquid_intake()));
				request.setAttribute("targetAlcoholIntake", toUnits.execute(result.getAlcohol_intake()));
				request.setAttribute("targetCondition", ccLogic.execute(result.getCondition()));
			} else {
				request.setAttribute("targetLiquidIntake", "---");
				request.setAttribute("targetAlcoholIntake", "---");
				request.setAttribute("targetCondition", "---");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inputAmount.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("update") != null) { //登録ボタンを押した際の処理
			Date targetDate = (Date) session.getAttribute("targetDate");

			// お気に入り飲料のMapを取得
			@SuppressWarnings("unchecked")
			Map<String, Double> mapFavBev = (Map<String, Double>) session.getAttribute("mapFavBev");

			// 連番の変数名
			String varBeverages;
			String varAmount;
			String varCups;

			// 各リクエストパラメータのtmp
			String tmpBeverages;
			double tmpAmount;
			int tmpCups;

			// 水分量とアルコール量の各合計
			double totalLiquid = 0;
			double totalAlcohol = 0;
			// アルコール度数
			double alcoholDegree = 0;

			for (int i = 1; i <= 3; i++) {
				varBeverages = "beverages" + i;
				varAmount = "amount" + i;
				varCups = "cups" + i;
				if (request.getParameter(varBeverages) != null &&
						request.getParameter(varBeverages) != null &&
						!(request.getParameter(varCups).equals("0"))) {
					tmpBeverages = request.getParameter(varBeverages);
					tmpAmount = Double.parseDouble(request.getParameter(varAmount));
					tmpCups = Integer.parseInt(request.getParameter(varCups));

					// 水分量の合計
					totalLiquid = totalLiquid + tmpAmount * tmpCups;
					// Mapからkey(飲料名)でitem(アルコール度数)取得
					alcoholDegree = mapFavBev.get(tmpBeverages);
					// アルコール量の合計
					totalAlcohol = totalAlcohol + tmpAmount * alcoholDegree * tmpCups;
				}
			}

			int condition = 0;
			String strCondition;
			if (request.getParameter("condition").length() != 0) {
				condition = Integer.parseInt(request.getParameter("condition"));
				ConvertConditionLogic cclBO = new ConvertConditionLogic();
				strCondition = cclBO.execute(condition);
			} else {
				strCondition = "---";
			}
			request.setAttribute("strCondition", strCondition);

			// day_recordテーブルをupdate
			Record record = new Record(user_id, targetDate, totalAlcohol, totalLiquid, condition);
			InputAmountLogic ialBO = new InputAmountLogic();
			boolean result = ialBO.execute(record);

			if (result) {
				// 完了画面に表示する情報をリクエストスコープへ保存
				request.setAttribute("TargetDate", targetDate);
				request.setAttribute("totalLiquid", totalLiquid);
				request.setAttribute("totalAlcohol", totalAlcohol);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/completeInputAmount.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationCheck.jsp");
				dispatcher.forward(request, response);

			}

		}
	}

}
