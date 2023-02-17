package model;

import dao.AccountDAO;

public class SignUpLogic {
	public Account execute(Account account) {
		AccountDAO dao = new AccountDAO();
		Account result = dao.signUp(account);
		return result;
	}
}
