package manga;

public class Memory {

	private String[] memory = new String[65536];
	private boolean memRead = false;
	private boolean memWrite = false;
	private String address = "0000000000000000";

	public Memory() {
		for (int i = 0; i < memory.length; i++) {
			memory[i] = "0000000000000000";
		}
		memory[2] = "0101010101010101";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("MEMORY ADDRESS     " + address);
		this.address = address;
	}

	public boolean isMemRead() {
		return memRead;
	}

	public void setMemRead(boolean memRead) {
		this.memRead = memRead;
		if (!memRead)
			this.memWrite = !memRead;
	}

	public boolean isMemWrite() {
		return memWrite;
	}

	public void setMemWrite(boolean memWrite) {
		this.memWrite = memWrite;
		if (!memWrite)
			this.memRead = !memWrite;
	}

	public String[] getMemory() {
		return this.memory;
	}

	public void setMemory(String[] memory) {
		this.memory = memory;
	}

	public void writeToMemory(String word) {
		if (!this.memRead && this.memWrite) {
			this.memory[Integer.parseInt(address, 2)] = word;
		}
	}

	public String readFromMemory() {
		if (this.memRead)
			return this.memory[Integer.parseInt(address, 2)];
		return "0000000000000000";

	}

}
