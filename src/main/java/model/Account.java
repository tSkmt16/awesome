package model;

import java.sql.Date;

public class Account {
	private int user_id;
	private String user_name;
	private String password;
	private Date dob;
	private int gender;
	private int admin;
	
	public Account(int user_id, String user_name, String password, Date dob, int gender, int admin) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.admin = admin;
	}

	public Account(String user_name, String password, Date dob, int gender, int admin) {
		this.user_name = user_name;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.admin = admin;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public Date getDob() {
		return dob;
	}

	public int getGender() {
		return gender;
	}

	public int getAdmin() {
		return admin;
	}
}
