package manga;

public class InstructionMemory {
	private String[] memory = new String[65536];
	private boolean writeFlag = false;
	private int index = 0;

	public InstructionMemory() {
		this.populateM();
	}

	public boolean isWriteFlag() {
		return this.writeFlag;
	}

	public void setWriteFlag(boolean writeFlag) {
		this.writeFlag = writeFlag;
	}

	public String[] getMemory() {
		return memory;
	}

	public void writeToMemory(String word) {
		if (this.writeFlag) {
			this.memory[index] = word;
			this.index += 2;
		}
	}

	public String readFromMemory(String bitStream) {
		int index = Integer.parseInt(bitStream, 2);

		if (!this.writeFlag)

			return memory[index];
		return null;

	}

	public int getIndex() {
		return this.index;
	}

	public void write(String a, int b) {
		this.memory[b] = a;
	}

	public void populateM() {

		memory[0] = "0000010000100011";
		memory[2] = "0001010000100011";
		memory[4] = "0010010000110010";
		memory[6] = "0011001100000000";
		memory[8] = "0101010000111000";
		memory[10] = "0110001100111000";
		memory[12] = "0111001100110000";
		memory[14] = "1000001100110000";
		memory[16] = "1001010000110001";
		memory[18] = "1010010000110001";
		memory[20] = "1011001100000000";
		memory[22] = "1100000000000011";
		memory[24] = "1101001100111000";
		memory[26] = "1110010000010011";
		memory[28] = "1111010000010011";
		memory[30] = "0100000000000000";
		//ThumbInstructions
		memory[32] = "0000000000000000";
		memory[34] = "0001000000000000";
		memory[36] = "0010001100000000";
		memory[38] = "0100010000000000";
		memory[40] = "0011000000000000";
	}

}
