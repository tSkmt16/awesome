package model;

import dao.RecordDAO;

public class LoadMyStats {
	public Record execute(Record record) {
		RecordDAO dao =new RecordDAO();				
		record = dao.findAvg(record);
		return record;
	}
}
