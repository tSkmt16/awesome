package model;

import dao.RecordDAO;

public class InputAmountLogic {
	public boolean execute(Record record) {
		RecordDAO dao = new RecordDAO();
		boolean result = dao.insertOrUpdateRecord(record);
		return result;
	}
}