package manga;

public class MUXAlaa {
	String in1;
	String in2;
	String in3;
	String in4;
	String select;
	String out;

	public MUXAlaa() {

	}

	public String getOut(String in1, String in2, String in3, String in4, String select) {
		switch (select) {
		case "00":
			return in1;
		case "01":
			return in2;
		case "10":
			return in3;
		case "11":
			return in4;
		default:
			return "a";
		}
	}
}
