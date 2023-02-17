package model;

public class ToUnits {
	public String execute(double ml) {
		if (ml >= 1000) {
			return String.format("%.2f", ml / 1000) + " L";
		} else {
			return String.format("%.2f", ml) + " mL";
		}
	}
}
