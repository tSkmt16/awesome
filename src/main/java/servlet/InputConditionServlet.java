package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InputConditionLogic;
import model.Record;

@WebServlet("/InputConditionServlet")
public class InputConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inputCondition.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//選択した体調を取得
		request.setCharacterEncoding("UTF-8");
		int condition = Integer.parseInt(request.getParameter("condition"));

		//セッションスコープからuser_id取得
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		//前日の日付を取得
		LocalDateTime ldt = LocalDateTime.now();
		ldt = ldt.minusDays(1);
		Date eve = java.sql.Date.valueOf(ldt.toLocalDate());

		//Recordインスタンス生成
		Record record = new Record(user_id, eve, condition);
		//処理実行
		InputConditionLogic bo = new InputConditionLogic();
		boolean result = bo.execute(record);
		
		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/completeInputCondition.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationCheck.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
