package manga;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class RegisterFile {

	private Register[] registerFile = new Register[16];
	String RegWrite;
	T T;

	public RegisterFile() {
		this.populate();
	}

	public Hashtable<String, String> getRegisters(Hashtable<String, String> input) {
		Hashtable<String, String> registerVals = new Hashtable<String, String>();
		String rsCode = (String) input.get("$rs");
		String rtCode = (String) input.get("$rt");
		registerVals.put("$rs", this.getRegisterValueByCode(rsCode));
		registerVals.put("$rt", this.getRegisterValueByCode(rtCode));
		System.out.println(input.get("$rs"));
		System.out.println(input.get("$rt"));
		return registerVals;
	}

	public String getRegisterValueByCode(String bitStream) {
		System.out.println("mkmklklk    " + Integer.parseInt(bitStream, 2));
		return registerFile[Integer.parseInt(bitStream, 2)].getValue();
	}

	public void setRegisterByCode(String bitStreamPos, String value) {

		registerFile[Integer.parseInt(bitStreamPos, 2)].setValue(value);
	}

	public Register getRegisterValueByName(String RegName) {
		for (int i = 0; i < registerFile.length; i++) {
			if (registerFile[i].getName().equals(RegName))
				return registerFile[i];
		}
		return null;
	}

	public void setRegisterByName(String RegName, String value) {
		for (int i = 0; i < registerFile.length; i++) {
			if (registerFile[i].getName().equals(RegName))
				registerFile[i].setValue(value);
		}
	}

	public Register[] getRegisterFile() {
		return registerFile;
	}

	public void setRegisterFile(Register[] registerFile) {
		this.registerFile = registerFile;
	}

	public void populate() {
		registerFile[0] = new Register("0000000000000000", "$0");
		registerFile[1] = new Register("0000000000000000", "$sp");
		registerFile[2] = new Register("0000000000000010", "$s0");
		registerFile[3] = new Register("0000000000000011", "$s1");
		registerFile[4] = new Register("1111111111111111", "$s2");
		registerFile[5] = new Register("0000000000000000", "$fp");
		registerFile[6] = new Register("0000000000000000", "$t0");
		registerFile[7] = new Register("0000000000000000", "$t1");
		registerFile[8] = new Register("0000000000000000", "$t2");
		registerFile[9] = new Register("0000000000000000", "$t3");
		registerFile[10] = new Register("0000000000000000", "$v0");
		registerFile[11] = new Register("0000000000000000", "$v1");
		registerFile[12] = new Register("0000000000000000", "$ra");
		registerFile[13] = new Register("0000000000000000", "$a0");
		registerFile[14] = new Register("0000000000000000", "$a1");
		registerFile[15] = new Register("0000000000000000", "$a2");
	}
}
