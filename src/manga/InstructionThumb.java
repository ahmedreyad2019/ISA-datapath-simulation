package manga;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class InstructionThumb {

	public InstructionThumb() {

	}

	public Hashtable<String, String> getType(String value) {
		boolean fullLength = false;
		StringTokenizer valueSep = new StringTokenizer(value, ", ");
		String opcode = valueSep.nextToken();
		if (opcode.length() == 16) {
			fullLength = true;
			opcode = opcode.substring(0, 4);
		}
		Hashtable<String, String> result = new Hashtable<String, String>();
		switch (opcode) {
		// R-Type
		// ADD
		case "0000":
		case "HALT":
			result.put("opcode", "0000");
			result.put("$imm", "0000");
			result.put("$rs", "0000");
			result.put("$rt", "0000");
			result.put("$rd", "0000");
			return result;
		// MUL
		case "0001":
		case "NOP":
			result.put("opcode", "0001");
			result.put("$imm", "0000");
			result.put("$rs", "0000");
			result.put("$rt", "0000");
			result.put("$rd", "0000");
			return result;
		// AND
		case "0010":
		case "RSP":
			result.put("opcode", "0010");
			result.put("$imm", "0000");
			result.put("$rt", "0000");
			result.put("$rd", "0000");
			if (fullLength) {
				result.put("$rs", value.substring(4, 8));
			} else {
				result.put("$rs", fromNameToBinaryRegister(valueSep.nextToken()));
			}
			return result;
		// JR
		case "0011":
		case "NTL":
			result.put("opcode", "0011");
			result.put("$imm", "0000");
			result.put("$rs", "0000");
			result.put("$rt", "0000");
			result.put("$rd", "0000");
			return result;
		// TCL
		case "0100":
		case "CLR":
			result.put("opcode", "0100");
			result.put("$rs", "0000");
			result.put("$rt", "0000");
			result.put("$imm", "0000");
			if (fullLength) {
				result.put("$rd", value.substring(4, 8));
			} else {
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
		case "HALT":
			return "0000";
		// MUL
		case "0001":
		case "NOP":
			return "0001";
		// AND
		case "0010":
		case "RSP":
			return "0010";
		// JR
		case "0011":
		case "NTL":
			return "0011";
		// TCL
		case "0100":
		case "CLR":
			return "0100";
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

}
