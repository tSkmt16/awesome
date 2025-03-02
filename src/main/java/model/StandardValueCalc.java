package model;

import dao.RecordDAO;

public class StandardValueCalc {
	public StandardValue execute(int user_id) {
		// day_recordテーブルで平均算出し、生成したstandardValueインスタンスを返す
		RecordDAO dao = new RecordDAO();
		StandardValue standardValue = dao.standardValueCalc(user_id);
		return standardValue;
	}
}
