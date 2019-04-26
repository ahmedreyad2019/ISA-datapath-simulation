package manga;

public class ID_EX_Pipeline {
	private Register[] registers;
	private ControlRegister EX_RegDst = new ControlRegister("0");
	private ControlRegister EX_ALUop = new ControlRegister("0");
	private ControlRegister EX_ALUsrc = new ControlRegister("0");
	private ControlRegister M_MemRead = new ControlRegister("0");
	private ControlRegister M_MemWrite = new ControlRegister("0");
	private ControlRegister M_MemBranch = new ControlRegister("0");
	private ControlRegister WB_MemToReg = new ControlRegister("0");
	private ControlRegister WB_RegWrite = new ControlRegister("0");
	private ControlRegister M_Jump = new ControlRegister("00");
	private ControlRegister WB_RegDst = new ControlRegister("0000");
	private ControlRegister EX_TCL = new ControlRegister("0");
	private ControlRegister WB_Reyad = new ControlRegister("0");

	public ControlRegister getWB_Reyad() {
		return WB_Reyad;
	}

	public void setWB_Reyad(ControlRegister wB_Reyad) {
		WB_Reyad = wB_Reyad;
	}

	public ControlRegister getEX_TCL() {
		return EX_TCL;
	}

	public void setEX_TCL(ControlRegister eX_TCL) {
		EX_TCL = eX_TCL;
	}

	public ControlRegister getWB_RegDst() {
		return WB_RegDst;
	}

	public void setWB_RegDst(ControlRegister wB_RegDst) {
		WB_RegDst = wB_RegDst;
	}

	public ControlRegister getM_Jump() {
		return M_Jump;
	}

	public void setM_Jump(ControlRegister m_Jump) {
		M_Jump = m_Jump;
	}

	public Register[] getRegisters() {
		return this.registers;
	}

	public Register getRegister(int index) {
		return this.registers[index];
	}

	public ControlRegister getEX_RegDst() {
		return EX_RegDst;
	}

	public ControlRegister getEX_ALUop() {
		return EX_ALUop;
	}

	public ControlRegister getEX_ALUsrc() {
		return EX_ALUsrc;
	}

	public ControlRegister getM_MemRead() {
		return M_MemRead;
	}

	public ControlRegister getM_MemWrite() {
		return M_MemWrite;
	}

	public ControlRegister getM_MemBranch() {
		return M_MemBranch;
	}

	public ControlRegister getWB_MemToReg() {
		return WB_MemToReg;
	}

	public ControlRegister getWB_RegWrite() {
		return WB_RegWrite;
	}

	public ID_EX_Pipeline() {
		this.registers = new Register[6];
		for (int i = 0; i < registers.length; i++)
			this.registers[i] = new Register("0000000000000000", "P" + i);
	}
}
