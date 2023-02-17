package model;

import dao.RecordDAO;

public class LoadDrinkNow {
	public Record execute(int user_id) {
		RecordDAO dao =new RecordDAO();				
		Record record = dao.findByRecord(user_id);
		return record;
	}
}