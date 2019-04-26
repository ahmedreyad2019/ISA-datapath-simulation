package manga;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class InstructionRegular {

	String value;

	public InstructionRegular() {

	}

	public Hashtable<String, String> getType(String value) {
		boolean fullLength = false;
		StringTokenizer valueSep = new StringTokenizer(value, ", ");
		String opcode = valueSep.nextToken();
		if (opcode.charAt(0) == '0' || opcode.charAt(0) == '1') {
			fullLength = true;
			opcode = opcode.substring(0, 4);
		}
		Hashtable<String, String> result = new Hashtable<String, String>();
		switch (opcode) {
		// R-Type
		// ADD
		case "0000":
		case "ADD":
			result.put("opcode", "0000");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// MUL
		case "0001":
		case "MUL":
			result.put("opcode", "0001");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// AND
		case "0010":
		case "AND":
			result.put("opcode", "0010");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// JR
		case "0011":
		case "JR":
			result.put("opcode", "0011");
			result.put("$rd", "0000");
			result.put("$rt", "0000");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// TCL
		case "0100":
		case "TCL":
			result.put("opcode", "0100");
			result.put("$rd", "0000");
			result.put("$rt", "0000");
			result.put("$imm", "0000");
			result.put("$rs", "0000");
			return result;
		// ADDI
		case "0101":
		case "ADDI":
			result.put("opcode", "0101");
			result.put("$rt", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$imm", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// PUSH
		case "0110":
		case "BNE":
			result.put("opcode", "0110");
			result.put("$rd", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "0111":
		case "LW":
			result.put("opcode", "0111");
			result.put("$rt", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rd", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "1000":
		case "SW":
			result.put("opcode", "1000");
			result.put("$rd", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "1001":
		case "SLL":
			result.put("opcode", "1001");
			result.put("$rt", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rd", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "1010":
		case "SLR":
			result.put("opcode", "1010");
			result.put("$rt", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rd", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "1011":
		case "JAL":
			result.put("opcode", "1011");
			result.put("$rd", "0000");
			result.put("$rt", "0000");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		case "1100":
		case "J":
			result.put("opcode", "1100");
			result.put("$rd", "0000");
			result.put("$rt", "0000");
			result.put("$rs", "0000");
			if (fullLength) {
				result.put("$imm", value.substring(4));
			} else {
				//System.out.println(" I WAS HERE AT SOME POINT       " + bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
				result.put("$imm", bitExtenderJ(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;

		// SHOULD BE R-TYPE!!!!!!!!!!!!!
		case "1101":
		case "BEQ":
			result.put("opcode", "1101");
			result.put("$rd", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$rt", value.substring(8, 12));
				result.put("$imm", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$rt", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
			}
			return result;
		case "1110":
		case "LWRE":
			result.put("$rt", "0000");
			result.put("opcode", "1110");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$imm", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		case "1111":
		case "LWRS":
			result.put("$rt", "0000");
			result.put("opcode", "1111");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
				result.put("$imm", value.substring(8, 12));
				result.put("$rd", value.substring(12));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
				result.put("$imm", bitExtender(Integer.toBinaryString((Integer.parseInt(valueSep.nextToken())))));
				result.put("$rd", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;

		default:
			return result;
		}
	}

	public String fromNameToBinaryOpCode(String name) {
		switch (name) {
		case "0000":
		case "ADD":
			return "0000";
		// MUL
		case "0001":
		case "MUL":
			return "0001";
		// AND
		case "0010":
		case "AND":
			return "0010";
		// JR
		case "0011":
		case "JR":
			return "0011";
		// TCL
		case "0100":
		case "TCL":
			return "0100";
		// ADDI
		case "0101":
		case "ADDI":
			return "0101";
		// PUSH
		case "0110":
		case "PUSH":
			return "0110";
		case "0111":
		case "LW":
			return "0111";
		case "1000":
		case "SW":
			return "1000";
		case "1001":
		case "SLL":
			return "1001";
		case "1010":
		case "SLR":
			return "1010";
		case "1011":
		case "JAL":
			return "1011";
		case "1100":
		case "J":
			return "1100";
		// SHOULD BE R-TYPE!!!!!!!!!!!!!
		case "1101":
		case "BEQ":
			return "1101";
		case "1110":
		case "LWRE":
			return "1110";
		case "1111":
		case "LWRS":
			return "1111";
		default:
			return "Wrong Input";
		}
	}

	public String fromNameToBinaryRegister(String name) {
		switch (name) {
		case "$0":
		case "$zero":
		case "0000":
			return "0000";
		case "$sp":
		case "0001":
			return "0001";
		case "$s0":
		case "0010":
			return "0010";
		case "$s1":
		case "0011":
			return "0011";
		case "$s2":
		case "0100":
			return "0100";
		case "$fp":
		case "0101":
			return "0101";
		case "$t0":
		case "0110":
			return "0110";
		case "$t1":
		case "0111":
			return "0111";
		case "$t2":
		case "1000":
			return "1000";
		case "$t3":
		case "1001":
			return "1001";
		case "$v0":
		case "1010":
			return "1010";
		case "$v1":
		case "1011":
			return "1011";
		case "$ra":
		case "1100":
			return "1100";
		case "$a0":
		case "1101":
			return "1101";
		case "$a1":
		case "1110":
			return "1110";
		case "$a2":
		case "1111":
			return "1111";
		default:
			return "Wrong Input";
		}
	}

	public String bitExtender(String rs) {
		String res = "";
		if (rs.length() > 4) {
			res = rs.substring(rs.length() - 4, rs.length());
		} else {
			if (rs.length() <= 4) {
				for (int i = rs.length(); i < 4; i++) {
					res += "0";
				}
				res += rs;
			}
		}
		return res;
	}

	public String bitExtenderJ(String rs) {
		String res = "";
		if (rs.length() > 12) {
			res = rs.substring(rs.length() - 12, rs.length());
		} else {
			if (rs.length() <= 12) {
				for (int i = rs.length(); i < 12; i++) {
					res += "0";
				}
				res += rs;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String test = "00001";
		InstructionRegular n = new InstructionRegular();
		String test2 = "ADD, $t0, $t1, $a2";
		StringTokenizer test3 = new StringTokenizer(test2, ", ");
		System.out.println(n.bitExtender(test));
	}

}
