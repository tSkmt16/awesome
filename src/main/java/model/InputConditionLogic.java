package model;

import dao.RecordDAO;

public class InputConditionLogic {
	public boolean execute(Record record) {
		RecordDAO dao = new RecordDAO();
		boolean result = dao.updateCondition(record);
		return result;
	}
}