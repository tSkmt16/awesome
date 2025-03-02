package model;

import dao.StandardValueDAO;

public class UpdateStandardValue {
	public boolean execute(StandardValue standardValue) {
		StandardValueDAO dao =new StandardValueDAO();
		boolean result = dao.updateStandard(standardValue);
		return result;
	}
}
