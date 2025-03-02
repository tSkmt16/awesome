package model;

public class FavoriteBeverage {
	private int user_id;
	private String no1_bev_name;
	private double no1_abv;
	private String no2_bev_name;
	private double no2_abv;
	private String no3_bev_name;
	private double no3_abv;
	private String no4_bev_name;
	private double no4_abv;
	private String no5_bev_name;
	private double no5_abv;

	public FavoriteBeverage(int user_id, String no1_bev_name, double no1_abv, String no2_bev_name, double no2_abv,
			String no3_bev_name, double no3_abv, String no4_bev_name, double no4_abv, String no5_bev_name,
			double no5_abv) {
		super();
		this.user_id = user_id;
		this.no1_bev_name = no1_bev_name;
		this.no1_abv = no1_abv;
		this.no2_bev_name = no2_bev_name;
		this.no2_abv = no2_abv;
		this.no3_bev_name = no3_bev_name;
		this.no3_abv = no3_abv;
		this.no4_bev_name = no4_bev_name;
		this.no4_abv = no4_abv;
		this.no5_bev_name = no5_bev_name;
		this.no5_abv = no5_abv;
	}

	public FavoriteBeverage(int user_id) {
		super();
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getNo1_bev_name() {
		return no1_bev_name;
	}

	public void setNo1_bev_name(String no1_bev_name) {
		this.no1_bev_name = no1_bev_name;
	}

	public double getNo1_abv() {
		return no1_abv;
	}

	public void setNo1_abv(double no1_abv) {
		this.no1_abv = no1_abv;
	}

	public String getNo2_bev_name() {
		return no2_bev_name;
	}

	public void setNo2_bev_name(String no2_bev_name) {
		this.no2_bev_name = no2_bev_name;
	}

	public double getNo2_abv() {
		return no2_abv;
	}

	public void setNo2_abv(double no2_abv) {
		this.no2_abv = no2_abv;
	}

	public String getNo3_bev_name() {
		return no3_bev_name;
	}

	public void setNo3_bev_name(String no3_bev_name) {
		this.no3_bev_name = no3_bev_name;
	}

	public double getNo3_abv() {
		return no3_abv;
	}

	public void setNo3_abv(double no3_abv) {
		this.no3_abv = no3_abv;
	}

	public String getNo4_bev_name() {
		return no4_bev_name;
	}

	public void setNo4_bev_name(String no4_bev_name) {
		this.no4_bev_name = no4_bev_name;
	}

	public double getNo4_abv() {
		return no4_abv;
	}

	public void setNo4_abv(double no4_abv) {
		this.no4_abv = no4_abv;
	}

	public String getNo5_bev_name() {
		return no5_bev_name;
	}

	public void setNo5_bev_name(String no5_bev_name) {
		this.no5_bev_name = no5_bev_name;
	}

	public double getNo5_abv() {
		return no5_abv;
	}

	public void setNo5_abv(double no5_abv) {
		this.no5_abv = no5_abv;
	}

}
