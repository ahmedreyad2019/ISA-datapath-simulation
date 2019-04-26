package manga;

public class ALUReyad {

	int oldReg;
	int memOut;
	int Rbits;
	int BitS;

	public ALUReyad() {

	}

	public String Out(String oldReg, String memOut, String Rbits, String bitS) {
		int bit = Integer.parseInt(bitS, 2);
		switch (Rbits) {
		case "00":
		case "11":
			return memOut;
		case "01":
			return oldReg.substring(0, bit) + memOut.substring(bit);

		case "10":
			return memOut.substring(0, bit) + oldReg.substring(bit);
		default:
			return memOut;
		}
	}

	public static void main(String[] args) {
		ALUReyad a = new ALUReyad();
		System.out.println(a.Out("0000000000000000", "1111111111111111", "01", "111"));
	}

}
