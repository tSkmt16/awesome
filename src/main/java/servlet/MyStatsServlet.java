package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;

import model.CreateChartLogic;
import model.LoadMyStats;
import model.Record;
import model.StandardValue;
import model.StandardValueCalc;
import model.ToUnits;
import model.UpdateStandardValue;

@WebServlet("/MyStatsServlet")
public class MyStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		String pageName = "マイ統計データ";
		session.setAttribute("pageName", pageName);

		Record record = new Record(user_id);
		LoadMyStats lmsBO = new LoadMyStats();
		record = lmsBO.execute(record);

		// 総量・アルコール量の平均をセッションスコープから取得し、単位変換した上でリクエストスコープに保存
		ToUnits toUnits = new ToUnits();
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("avgAlcohol", toUnits.execute(record.getAlcohol_intake()));
		request.setAttribute("avgLiquid", toUnits.execute(record.getLiquid_intake()));

		// day_recordsテーブルから体調「わるい」「とてもわるい」になる基準値を取得
		StandardValueCalc svcBO = new StandardValueCalc();
		StandardValue standardValue = null;
		standardValue = svcBO.execute(user_id);
		double badValue = standardValue.getBadValue();
		double verybadValue = standardValue.getVerybadValue();
		// 画面出力用に単位・型変換してリクエストスコープへ保存
		request.setAttribute("badValue", toUnits.execute(badValue));
		request.setAttribute("verybadValue", toUnits.execute(verybadValue));

		// standard_valueテーブルをUPDATE
		UpdateStandardValue usBO = new UpdateStandardValue();
		boolean result = usBO.execute(standardValue);

		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myStats.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/operationCheck.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/png");

		// 選択された日付を取得
		request.setCharacterEncoding("UTF-8");
		String strStartDate = request.getParameter("startDate");
		String strEndDate = request.getParameter("endDate");

		// 開始日・終了日の両方が選択されたら実行
		if (strStartDate != null && strEndDate != null) {
			Date startDate = Date.valueOf(strStartDate);
			Date endDate = Date.valueOf(strEndDate);
			HttpSession session = request.getSession();
			int user_id = (int) session.getAttribute("user_id");

			CreateChartLogic bo = new CreateChartLogic();
			List<Record> recordList = bo.execute(user_id, startDate, endDate);

			ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
			DefaultCategoryDataset dcd = new DefaultCategoryDataset();

			for (Record record : recordList) {
				dcd.addValue(record.getAlcohol_intake(), "純アルコール量", record.getDate());
			}

			//			ex)
			//			dcd.addValue(1000, "北海道支社", "2018");
			//			dcd.addValue(400, "北海道支社", "2019");
			//			dcd.addValue(600, "北海道支社", "2020");

			JFreeChart chart = ChartFactory.createBarChart("アルコール摂取量", "日付", "mL", dcd);

<<<<<<< HEAD
			String filePath = "../workspace/moderateDrinking/src/main/webapp/chart/";
=======
			String filePath = "../workspace/awesome/src/main/webapp/chart/";
>>>>>>> 92c1e82b9d78ad9e1ec5361b760aa75fba5be75e
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
			String now = ldt.format(form);
			String fileName = user_id + "_" + now + ".png";
			File file = new File(filePath + fileName);
			try {
				ChartUtilities.saveChartAsPNG(file, chart, 480, 480);
				String chartPath = "chart/" + fileName;
				request.setAttribute("chartPath", chartPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myStats.jsp");
			dispatcher.forward(request, response);

			//			ChartFrame ch = new ChartFrame("アルコール摂取量", chart);
			//			ch.setVisible(true);
			//			ch.setSize(480, 480);

		}

	}

}
