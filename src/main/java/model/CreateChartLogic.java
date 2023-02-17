package model;

import java.sql.Date;
import java.util.List;

import dao.RecordDAO;

public class CreateChartLogic {
	public List<Record> execute(int user_id,Date startDate,Date endDate) {
		RecordDAO dao =new RecordDAO();
		List<Record> recordList=dao.forChart(user_id,startDate,endDate);
		return recordList;
	}	
}
