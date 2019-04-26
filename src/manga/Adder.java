package manga;

public class Adder {

	int rs;
	int rt;
	int addres;
	
	public Adder() {
		
	}
	
	public String adderVar(String op1, String op2) {
		String res;
		rs = (int) Integer.parseInt(op1, 2);
		rt = (int) Integer.parseInt(op2, 2);
		addres = rs + rt;
		res = Integer.toBinaryString(addres);
		return bitExtender(res);
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
	
}
