package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");

		// ログイン処理の実行
		Login login = new Login(user_name, password);
		LoginLogic bo = new LoginLogic();
//		boolean result = bo.execute(login);
		Account result= bo.execute(login);
		
		
		//セッションスコープにページ名を保存
		String pageName = "Menu";
		HttpSession session = request.getSession();
		session.setAttribute("pageName", pageName);

		// ログイン処理の成否によって処理を分岐
		if (result != null) { // ログイン成功時
			int user_id=result.getUser_id();
			// セッションスコープにuser_id、user_nameを保存
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_name", user_name);
						
			// Menu画面へリダイレクト
<<<<<<< HEAD
			response.sendRedirect("/moderateDrinking/MenuServlet");
=======
			response.sendRedirect("/awesome/MenuServlet");
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
			
		} else { // ログイン失敗時
			request.setAttribute("loginErrorMsg", "ユーザー名またはパスワードに誤りがあります");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}