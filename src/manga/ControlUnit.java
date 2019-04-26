package manga;

import java.util.Hashtable;

public class ControlUnit {

	public ControlUnit() {

	}

	public Hashtable<String, String> decode(String input, String T) {
		Hashtable<String, String> Control = new Hashtable<String, String>();
		if (T.equals("0")) {
			switch (input) {
			case "0000":
				Control.put("RegDst", "11");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0001":
				Control.put("RegDst", "11");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0010":
				Control.put("RegDst", "11");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0011":
				Control.put("RegDst", "11");
				Control.put("Branch", "0");
				Control.put("MemRead", "1");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "0");
				Control.put("Jump", "10");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0100":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "0");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "1");
				break;
			case "0101":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0110":
				Control.put("RegDst", "00");
				Control.put("Branch", "1");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "0");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "0111":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "1");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1000":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "1");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "0");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1001":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1010":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "00");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1011":
				Control.put("RegDst", "01");
				Control.put("Branch", "0");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "01");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "10");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1100":
				Control.put("RegDst", "00");
				Control.put("Branch", "1");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "0");
				Control.put("Jump", "11");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1101":
				Control.put("RegDst", "00");
				Control.put("Branch", "1");
				Control.put("MemRead", "0");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "0");
				Control.put("RegWrite", "0");
				Control.put("Jump", "00");
				Control.put("Reyad", "0");
				Control.put("TCL", "0");
				break;
			case "1110":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "1");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "01");
				Control.put("TCL", "0");
				break;
			case "1111":
				Control.put("RegDst", "00");
				Control.put("Branch", "0");
				Control.put("MemRead", "1");
				Control.put("MemtoReg", "11");
				Control.put("ALUOp", input);
				Control.put("MemWrite", "0");
				Control.put("ALUSrc", "1");
				Control.put("RegWrite", "1");
				Control.put("Jump", "00");
				Control.put("Reyad", "10");
				Control.put("TCL", "0");
				break;
			default:
			}
		} else {
			if (T.equals("1")) {
				switch (input) {
				case "0000":
					Control.put("RegDst", "00");
					Control.put("Branch", "0");
					Control.put("MemRead", "0");
					Control.put("MemtoReg", "00");
					Control.put("ALUOp", input);
					Control.put("MemWrite", "0");
					Control.put("ALUSrc", "0");
					Control.put("RegWrite", "0");
					Control.put("Jump", "00");
					Control.put("Reyad", "0");
					Control.put("TCL", "1");
					System.exit(1);
					break;
				case "0001":
					Control.put("RegDst", "00");
					Control.put("Branch", "0");
					Control.put("MemRead", "0");
					Control.put("MemtoReg", "00");
					Control.put("ALUOp", input);
					Control.put("MemWrite", "0");
					Control.put("ALUSrc", "0");
					Control.put("RegWrite", "0");
					Control.put("Jump", "00");
					Control.put("Reyad", "0");
					Control.put("TCL", "1");
					break;
				case "0010":// RSP
					Control.put("RegDst", "10");
					Control.put("Branch", "0");
					Control.put("MemRead", "0");
					Control.put("MemtoReg", "00");
					Control.put("ALUOp", input);
					Control.put("MemWrite", "0");
					Control.put("ALUSrc", "0");
					Control.put("RegWrite", "1");
					Control.put("Jump", "00");
					Control.put("Reyad", "0");
					Control.put("TCL", "1");
					break;
				case "0011":
					Control.put("RegDst", "00");
					Control.put("Branch", "0");
					Control.put("MemRead", "0");
					Control.put("MemtoReg", "00");
					Control.put("ALUOp", input);
					Control.put("MemWrite", "0");
					Control.put("ALUSrc", "0");
					Control.put("RegWrite", "0");
					Control.put("Jump", "00");
					Control.put("Reyad", "0");
					Control.put("TCL", "0");
					break;
				case "0100":
					Control.put("RegDst", "00");
					Control.put("Branch", "0");
					Control.put("MemRead", "0");
					Control.put("MemtoReg", "10");
					Control.put("ALUOp", input);
					Control.put("MemWrite", "0");
					Control.put("ALUSrc", "0");
					Control.put("RegWrite", "1");
					Control.put("Jump", "00");
					Control.put("Reyad", "0");
					Control.put("TCL", "1");
					break;
				}
			}
		}
		return Control;
	}

	public static void main(String[] args) {

	}

}
