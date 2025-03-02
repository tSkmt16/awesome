package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FavoriteBeverage;
import model.LoadFavoriteBeverage;
import model.StandardValue;
import model.StandardValueCalc;
import model.ToUnits;

@WebServlet("/RegChangeServlet")
public class RegChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		String pageName = "登録情報変更";
		session.setAttribute("pageName", pageName);

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

		//DBからお気に入り飲料を抽出し、jspへ渡す準備
		FavoriteBeverage favBev = new FavoriteBeverage(user_id);
		LoadFavoriteBeverage lfbBO = new LoadFavoriteBeverage();
		favBev = lfbBO.execute(user_id);
		session.setAttribute("favBev", favBev);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regChange.jsp");
		dispatcher.forward(request, response);		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
