package manga;



public class T {
	private static String bit = "0";

	public String getBit() {
		return bit;
	}

	public void setBit(String bit) {
		if(bit.equals("1") || bit.equals("0"))
			T.bit = bit;
		else
			System.out.println("Error");
	}
	
	
}
