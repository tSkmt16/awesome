package model;

public class StandardValue {
	private int user_id;
	private double badValue;
	private double verybadValue;
	
	public StandardValue(int user_id, double badValue, double verybadValue) {
		super();
		this.user_id = user_id;
		this.badValue = badValue;
		this.verybadValue = verybadValue;
	}
	public StandardValue(int user_id) {
		super();
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public double getBadValue() {
		return badValue;
	}
	public double getVerybadValue() {
		return verybadValue;
	}
	
	
}
