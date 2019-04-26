package manga;



public class Register {
	private String value;
	private String name;

	public Register(String value, String name) {
		this.value = value;
		this.name = name;
		if(!checkBits()) {
			this.value = "Wrong Input";
		}
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		if (this.checkBits() && this.checkLength())
			this.value = value;
		else
			System.out.println("Error");

	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean checkLength() {
		return this.value.length() <= 16 ? true : false;
	}

	public boolean checkBits() {
		for (int i = 0; i < this.value.length(); i++)
			if (this.value.charAt(i) != '0' && this.value.charAt(i) != '1')
				return false;
		return true;
	}

	public String toString() {
		return this.value;
	}

}
