//package Project;
//
//import java.util.ArrayList;
//import java.util.Hashtable;
//
//public class ALU {
//
//	public ALU() {
//		
//	}
//
//	public String ALUOperations(Hashtable<String, String> usedRegister, String ALUOp) {
//		String res = "T Value is Wrong";
//		int rs;
//		int rt;
//		int rd;
//		int addres;
//		int imm;
//		String addrest = "";
//		String rst = "";
//		ArrayList<String> registers;
//		if (usedRegister.get("T").equals("0")) {
//			switch (ALUOp) {
//			case "0000":
//				registers = unboxType(usedRegister);
//				rs = (int) Integer.parseInt(registers.get(0), 2);
//				rt = (int) Integer.parseInt(registers.get(1), 2);
//				addres = rs + rt;
//				System.out.println(addres);
//				res = Integer.toBinaryString(addres);
//				break;
//			case "0001":
//				registers = unboxType(usedRegister);
//				rs = (int) Integer.parseInt(registers.get(0), 2);
//				rt = (int) Integer.parseInt(registers.get(1), 2);
//				addres = rs * rt;
//				res = Integer.toBinaryString(addres);
//				break;
//			case "0010":
//				res = andingStrings(usedRegister.get("rs"), usedRegister.get("rt"));
//				break;
//			case "0011":
//				
//			case "0100":
//				
//			case "0101":
//				registers = unboxType(usedRegister);
//				rs = (int) Integer.parseInt(registers.get(0), 2);
//				imm = (int) Integer.parseInt(registers.get(2), 2);
//				addres = rs + imm;
//				res = Integer.toBinaryString(addres);
//				break;
//				
//			case "1001":
//				registers = unboxType(usedRegister);
//				rst = registers.get(0);
//				imm = (int) Integer.parseInt(registers.get(2), 2);
//				while (imm > 0) {
//					for (int i = 1; i < 16; i++) {
//						addrest += rst.charAt(i);
//					}
//					addrest += "0";
//					imm--;
//					rst = addrest;
//				}
//				break;
//			case "1010":
//				registers = unboxType(usedRegister);
//				rst = registers.get(0);
//				imm = (int) Integer.parseInt(registers.get(2), 2);
//				
//				while (imm > 0) {
//					for (int i = 14; i > 0; i++) {
//						addrest += rst.charAt(i);
//					}
//					addrest += "0";
//					imm--;
//					rst = addrest;
//				}
//				break;
//			case "1101":
//				registers = unboxType(usedRegister);
//				rs = (int) Integer.parseInt(registers.get(0), 2);
//				rt = (int) Integer.parseInt(registers.get(1), 2);
//				if(rs==rt) {
//					res = "1";
//				}else {
//					res = "0";
//				}
//				break;
//				
//				
//			default:
//				return "Wrong OpCode in Regular";
//
//			}
//		}
//		if (usedRegister.get("T").equals("1")) {
//			switch (ALUOp) {
//			case "0100":
//
//				break;
//			default:
//				return "Wrong OpCode in Thumb";
//			}
//		}
//		return bitExtender(res);
//	}
//
//	public ArrayList<String> unboxType(Hashtable<String, String> usedRegister) {
//		ArrayList<String> res = new ArrayList<String>();
//		res.add(usedRegister.get("rs"));
//		res.add(usedRegister.get("rt"));
//		res.add(usedRegister.get("rd"));
//		return res;
//	}
//
//	public String andingStrings(String rs, String rt) {
//		String res = "";
//		for (int i = 0; i < 16; i++) {
//			char s1 = rs.charAt(i);
//			char s2 = rt.charAt(i);
//			if (s1 == '1' && s2 == '1') {
//				res += "1";
//			} else {
//				res += "0";
//			}
//		}
//		return res;
//	}
//
//	public String bitExtender(String rs) {
//		String res = "";
//		if (rs.length() > 16) {
//			res = rs.substring(rs.length()-16, rs.length());
//		} else {
//			if (rs.length() <= 16) {
//				for (int i = rs.length(); i < 16; i++) {
//					res += "0";
//				}
//				res += rs;
//			}
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		ALU alu = new ALU();
//		Hashtable<String, String> test = new Hashtable<String, String>();
//		test.put("rs", "0000000000000101");
//		test.put("rt", "0000000000000011");
//		test.put("rd", "0101010101010101");
//		test.put("T", "0");
//		System.out.println(alu.ALUOperations(test, "0000"));
//	}
//}
package manga;

import java.util.ArrayList;
import java.util.Hashtable;

public class ALU {

	public ALU() {

	}

	public String[] ALUOperations(String rs, String rt, String ALUOp, String T) {
		String[] res = new String[3];
		res[0] = "0";
		res[2] = "000";
		int rsInt;
		int rtInt;
		int rd;
		int addres;
		int imm;
		int toInt;
		String addrest = "";
		String rst = "";
		if (T.equals("0")) {
			switch (ALUOp) {
			case "0000":
				System.out.println("IM HERE");
				rsInt = (int) Integer.parseInt(rs, 2);
				rtInt = (int) Integer.parseInt(rt, 2);
				addres = rsInt + rtInt;
				res[1] = Integer.toBinaryString(addres);
				System.out.println(rs + "  " + rt + "  " + res[1]);
				break;
			case "0001":
				rsInt = (int) Integer.parseInt(rs, 2);
				rtInt = (int) Integer.parseInt(rt, 2);
				addres = rsInt * rtInt;
				res[1] = Integer.toBinaryString(addres);
				break;
			case "0010":
				res[1] = andingStrings(rs, rt);
				break;
			case "0011":
				res[1] = "0000000000000000";
				break;
			case "0100":
				res[1] = "0000000000000000";
				break;
			case "0101":
				rsInt = (int) Integer.parseInt(rs, 2);
				imm = (int) Integer.parseInt(rt, 2);
				addres = rsInt + imm;
				res[1] = Integer.toBinaryString(addres);
				break;
			case "0110":
				res[1] = "0000000000000000";
				rsInt = (int) Integer.parseInt(rs, 2);
				rtInt = (int) Integer.parseInt(rt, 2);
				if (rsInt != rtInt) {
					res[0] = "1";
				}
				break;
			case "0111":
			case "1000":
				rsInt = (int) Integer.parseInt(rs, 2);
				imm = (int) Integer.parseInt(rt, 2);
				addres = rsInt + imm;
				res[1] = Integer.toBinaryString(addres);
				break;
			case "1001":
				rst = rs;
				imm = (int) Integer.parseInt(rt, 2);
				toInt = Integer.parseInt(rst, 2);
				res[1] = bitExtender(Integer.toBinaryString((toInt << imm)));
				break;
			case "1010":
				rst = rs;
				imm = (int) Integer.parseInt(rt, 2);
				toInt = Integer.parseInt(rst, 2);
				res[1] = bitExtender(Integer.toBinaryString((toInt >> imm)));
				break;
			case "1011":
				res[1] = "0000000000000000";
				break;
			case "1100":
				res[1] = "0000000000000000";
				break;
			case "1101":
				res[1] = "0000000000000000";
				rsInt = (int) Integer.parseInt(rs, 2);
				rtInt = (int) Integer.parseInt(rt, 2);
				if (rsInt == rtInt) {
					res[0] = "1";
				}
				break;
			case "1110":
			case "1111":
				rsInt = (int) Integer.parseInt(rs, 2);
				res[1] = Integer.toBinaryString(rsInt);
				res[2] = rt.substring(13, 16);
				break;
			default:
				res[1] = "Wrong Input";
				return res;
			}
		}
		if (T.equals("1")) {
			switch (ALUOp) {
			case "0010":
				res[1] = rs;
				break;
			case "0100":
				res[1] = "0000000000000000";
				break;
			default:
				res[1] = "0000000000000000";
				return res;

			}
		}
		res[1] = bitExtender(res[1]);
		return res;
	}

	public ArrayList<String> unboxType(Hashtable<String, String> usedRegister) {
		ArrayList<String> res = new ArrayList<String>();
		res.add(usedRegister.get("$rs"));
		res.add(usedRegister.get("$rt"));
		res.add(usedRegister.get("$rd"));
		return res;
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

	public String bitExtender(String rs) {
		String res = "";
		if (rs.length() > 16) {
			res = rs.substring(rs.length() - 16, rs.length());
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
		ALU alu = new ALU();
		Hashtable<String, String> test = new Hashtable<String, String>();
		String rs = "0000000000011101";
		String rt = "0000000000000011";
		String T = "0";
		System.out.println(alu.ALUOperations(rs, rt, "1010", T)[0]);
	}
}
