package manga;

public class MEM_WB_Pipeline {
	private Register[] registers;
	private ControlRegister WB_MemToReg = new ControlRegister("0");
	private ControlRegister WB_RegWrite = new ControlRegister("0");
	private ControlRegister WB_RegDst = new ControlRegister("0000");
	private ControlRegister WB_Reyad = new ControlRegister("0");

	public ControlRegister getWB_Reyad() {
		return WB_Reyad;
	}

	public void setWB_Reyad(ControlRegister wB_Reyad) {
		WB_Reyad = wB_Reyad;
	}

	public ControlRegister getWB_RegDst() {
		return WB_RegDst;
	}

	public void setWB_RegDst(ControlRegister wB_RegDst) {
		WB_RegDst = wB_RegDst;
	}

	public Register[] getRegisters() {
		return this.registers;
	}

	public Register getRegister(int index) {
		return this.registers[index];
	}

	public ControlRegister getWB_MemToReg() {
		return WB_MemToReg;
	}

	public ControlRegister getWB_RegWrite() {
		return WB_RegWrite;
	}

	public MEM_WB_Pipeline() {
		this.registers = new Register[6];
		for (int i = 0; i < registers.length; i++)
			this.registers[i] = new Register("0000000000000000", "P" + i);
	}
}
