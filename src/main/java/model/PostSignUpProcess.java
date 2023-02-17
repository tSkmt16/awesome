package model;

import dao.FavoriteDAO;
import dao.StandardValueDAO;

public class PostSignUpProcess {
	public boolean execute(int user_id) {
		FavoriteDAO fDAO = new FavoriteDAO();
		boolean fResult = fDAO.signUp(user_id);
		StandardValueDAO svDAO = new StandardValueDAO();
		boolean svResult = svDAO.signUp(user_id);
		boolean result;
		if (fResult && svResult) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
