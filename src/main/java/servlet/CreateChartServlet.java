package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateChartServlet")
public class CreateChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// 選択された日付を取得
//		request.setCharacterEncoding("UTF-8");
//		String strStartDate = request.getParameter("startDate");
//		String strEndDate = request.getParameter("endDate");
//
//		// 開始日・終了日の両方が選択されたら実行
//		if (strStartDate != null && strEndDate != null) {
//			Date startDate = Date.valueOf(strStartDate);
//			Date endDate = Date.valueOf(strEndDate);
//			HttpSession session = request.getSession();
//			int user_id = (int) session.getAttribute("user_id");
//
//			CreateChartLogic bo = new CreateChartLogic();
//			List<Record> recordList = bo.execute(user_id, startDate, endDate);
//
//			ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
//			DefaultCategoryDataset dcd = new DefaultCategoryDataset();
//
//			for (Record record : recordList) {
//				dcd.addValue(record.getAlcohol_intake(), "アルコール摂取量", record.getDate());
//			}
//			
//			//JFreeChartオブジェクトの生成
//			JFreeChart chart = ChartFactory.createBarChart3D("アルコール摂取量", "日付", "mL", dcd);
//
//			//responseに出力
//			try {
//				OutputStream os = new BufferedOutputStream(response.getOutputStream());
//				ChartUtilities.writeChartAsJPEG(os, chart, 300, 300);
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myStats.jsp");
//			dispatcher.forward(request, response);
//		}

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
