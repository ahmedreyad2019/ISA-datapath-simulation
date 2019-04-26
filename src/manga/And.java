package manga;

public class And {

	public And() {

	}

	public String andd(String a, String b) {
		String a1 = "0";
		String b1 = "0";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '1') {
				a1 = "1";
				break;
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '1') {
				b1 = "1";
				break;
			}

		}
		if (a1.equals("0") || b1.equals("0"))
			return "0";
		else
			return "1";
	}

	public String andingStrings(String rs, String rt) {

		String res = "";
		for (int i = 0; i < 16; i++) {
			char s1 = rs.charAt(i);
			char s2 = rt.charAt(i);
			if (s1 == '1' && s2 == '1') {
				res += "1";
			} else {
				res += "0";
			}
		}
		return res;
	}

}
