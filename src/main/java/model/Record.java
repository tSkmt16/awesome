package model;

import java.sql.Date;

public class Record {
	private int user_id;
	private Date date;
	private double alcohol_intake;
	private double liquid_intake;
	private int condition;

	public Record(int user_id, Date date, double alcohol_intake, double liquid_intake, int condition) {
		super();
		this.user_id = user_id;
		this.date = date;
		this.alcohol_intake = alcohol_intake;
		this.liquid_intake = liquid_intake;
		this.condition = condition;
	}

	public Record(int user_id, Date date) {
		super();
		this.user_id = user_id;
		this.date = date;
	}

	public Record(int user_id, Date date, double alcohol_intake, double liquid_intake) {
		super();
		this.user_id = user_id;
		this.date = date;
		this.alcohol_intake = alcohol_intake;
		this.liquid_intake = liquid_intake;
	}

	public Record(int user_id, Date date, int condition) {
		super();
		this.user_id = user_id;
		this.date = date;
		this.condition = condition;
	}

	public Record(int user_id, double alcohol_intake, double liquid_intake) {
		super();
		this.user_id = user_id;
		this.alcohol_intake = alcohol_intake;
		this.liquid_intake = liquid_intake;
	}

	public Record(int user_id) {
		super();
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public Date getDate() {
		return date;
	}

	public double getAlcohol_intake() {
		return alcohol_intake;
	}

	public double getLiquid_intake() {
		return liquid_intake;
	}

	public int getCondition() {
		return condition;
	}

}
