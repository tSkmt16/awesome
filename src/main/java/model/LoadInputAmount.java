package model;

import dao.RecordDAO;

public class LoadInputAmount {
	public Record execute(Record record) {
		RecordDAO dao =new RecordDAO();
		record = dao.extractRecord(record);
		return record;
	}
}
