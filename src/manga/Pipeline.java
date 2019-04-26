package manga;

public class Pipeline {
	private Register[] registers;

	public Pipeline(int n) {
		this.registers = new Register[n];
		for (int i = 0; i < n; i++)
			this.registers[i] = new Register("0000000000000000", "P" + i);
	}
	
	public Register[] getAllRegisters() {
		return this.registers;
	}
	
	public Register getRegister(int index) {
		return this.registers[index];
	}

}
