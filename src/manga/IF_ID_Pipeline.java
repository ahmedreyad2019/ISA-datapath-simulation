package manga;

public class IF_ID_Pipeline {

	private Register[] registers;
	private String instruction;

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public IF_ID_Pipeline() {
		this.registers = new Register[4];
		for (int i = 0; i < registers.length; i++)
			this.registers[i] = new Register("0000000000000000", "P" + i);
	}

	public Register[] getRegisters() {
		return this.registers;
	}

	public Register getRegister(int index) {
		return this.registers[index];
	}

}
