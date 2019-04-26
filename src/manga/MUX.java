package manga;

public class MUX {
	String in1;
	String in2;
	String select;
	String out;

	public MUX() {

	}

	public String getOut(String in1, String in2, String select) {
		if (select.equals("1"))
			return in2;
		else
			return in1;
	}

}
