package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.PostSignUpProcess;
import model.SignUpLogic;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String strDob = request.getParameter("year") + "-" +
				request.getParameter("month") + "-" +
				request.getParameter("day");
		Date dob = Date.valueOf(strDob);
		int gender = Integer.parseInt(request.getParameter("gender"));
		int admin = Integer.parseInt(request.getParameter("admin"));

		Account account = new Account(user_name, password, dob, gender, admin);
		SignUpLogic sulBO = new SignUpLogic();
		Account result = sulBO.execute(account);

		if (result != null) {
			int user_id = result.getUser_id();
			// favorite_beveragesテーブル、standard_valueテーブルへデータ挿入
			PostSignUpProcess psupBO = new PostSignUpProcess();
			boolean postResult = psupBO.execute(user_id);
			if (postResult) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUpOK.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationCheck.jsp");
				dispatcher.forward(request, response);
			}				
		} else {
<<<<<<< HEAD
			response.sendRedirect("/moderateDrinking/SignUpServlet");
=======
			response.sendRedirect("/awesome/SignUpServlet");
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
		}
	}
}
