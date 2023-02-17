package model;

import dao.RecordDAO;

public class DrinkNowLogic {
	public boolean execute(Record record) {
		RecordDAO dao = new RecordDAO();
		boolean result = dao.updateRecord(record);
		return result;
	}
}