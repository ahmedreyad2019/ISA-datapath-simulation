package manga;

public class Shifter {

	public Shifter() {

	}

	public String shiftAla2(String alaa) {
		int toInt = Integer.parseInt(alaa, 2);
		String res = "";
		String rs = Integer.toBinaryString((toInt << 1));
		if (rs.length() <= 14) {
			for (int i = rs.length(); i < 14; i++) {
				res += "0";
			}
		}
		res += rs;
		return res;
	}

	public String shiftOne(String bitStream) {
//		String res = "";
//		String addrest = "";
//		for (int i = 1; i < 16; i++) {
//				addrest += bitStream.charAt(i);
//			}
//			addrest += "0";
//			res = addrest;
//		return res;
		int toInt = Integer.parseInt(bitStream, 2);
		return bitExtender(Integer.toBinaryString((toInt << 1)));
	}

	public String bitExtender(String rs) {
		String res = "";
		if (rs.length() > 16) {
			res = rs.substring(0, 16);
		} else {
			if (rs.length() <= 16) {
				for (int i = rs.length(); i < 16; i++) {
					res += "0";
				}
				res += rs;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Shifter shifter = new Shifter();
		System.out.println(shifter.shiftOne("0001"));
	}

}
