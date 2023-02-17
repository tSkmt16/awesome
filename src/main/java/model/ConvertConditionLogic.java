package model;

public class ConvertConditionLogic {

	public String execute(int condition) {
		switch (condition) {
		case 1:
			return "とてもわるい";
		case 2:
			return "わるい";
		case 3:
			return "ふつう";
		case 4:
			return "いい";
		case 5:
			return "とてもいい";
		}
		return null;
	}
}
