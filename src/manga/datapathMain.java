package manga;

import java.util.Hashtable;

public class datapathMain {

	static Register PC = new Register("0000000000000000", "PC");
	static InstructionMemory InstructionMemory = new InstructionMemory();
	static T T = new T();
	static DMX DMX = new DMX();
	static Adder adder = new Adder();
	static Adder adder2 = new Adder();
	static MUX toControlUnit = new MUX();
	static Memory datamemory = new Memory();
	static InstructionRegular InstructionRegular = new InstructionRegular();
	static InstructionThumb InstructionThumb = new InstructionThumb();
	static ControlUnit ControlUnit = new ControlUnit();
	static RegisterFile registerFile = new RegisterFile();
	static IF_ID_Pipeline IF_ID = new IF_ID_Pipeline();
	static ID_EX_Pipeline ID_EX = new ID_EX_Pipeline();
	static EX_MEM_Pipeline EX_MEM = new EX_MEM_Pipeline();
	static MEM_WB_Pipeline MEM_WB = new MEM_WB_Pipeline();
	static Shifter shiftleft2 = new Shifter();
	static ALU addResult = new ALU();
	static ALU ALU = new ALU();
	static MUX MUXtoALU = new MUX();
	static MUX MUXtoPC = new MUX();
	static MUXAlaa MUXtoPCBARA = new MUXAlaa();
	static MUXAlaa MUXWB = new MUXAlaa();
	static And andbranch = new And();
	static Shifter ala2 = new Shifter();
	static MUXAlaa MUXtoRegFile = new MUXAlaa();
	static boolean instructionFetched, instructionDecoded, instructionExecuted, instructionWrittenBack = false;
	static ALUReyad aluReyad = new ALUReyad();

	public static void Fetch() {
		if (InstructionMemory.getMemory()[Integer.parseInt(PC.getValue(), 2)] != null) {
			String currentInstructionString = InstructionMemory.readFromMemory(PC.getValue());
			PC.setValue(adder.adderVar(PC.getValue(), "0000000000000010"));
			IF_ID.getRegister(0).setValue(PC.getValue());
			IF_ID.setInstruction(currentInstructionString);
			System.out.println(IF_ID.getInstruction());
			instructionFetched = true;
			System.out.println("IN FETCH");
		}
	}

	public static void Decode() {
		if (instructionFetched && IF_ID.getInstruction() != null) {
			Hashtable<String, String> decodedInstruction;
			if (T.getBit().equals("0")) {
				System.out.println(registerFile.getRegisterValueByCode("0100"));
				System.out.println(registerFile.getRegisterValueByName("0011"));
				decodedInstruction = InstructionRegular.getType(IF_ID.getInstruction());
				System.out.println("AFTER DECODING   " + decodedInstruction.toString());
			} else {
				decodedInstruction = InstructionThumb.getType(IF_ID.getInstruction());
			}
			String immediateAfterExtend = ALU.bitExtender(decodedInstruction.get("$imm"));
			System.out.println(decodedInstruction.toString());
			Hashtable<String, String> ControlUnitOutput = ControlUnit.decode(decodedInstruction.get("opcode"),
					T.getBit());
			String jumpAdress = "000000000000";
			if (!(ControlUnitOutput.get("Jump").equals("00"))) {
				jumpAdress = decodedInstruction.get("$imm");
				System.out.println("JUMP  " + decodedInstruction.get("$imm"));
				jumpAdress = ala2.shiftAla2(jumpAdress);
				jumpAdress = PC.getValue().substring(0, 2) + jumpAdress;
			}
			String writeRegAlaa = MUXtoRegFile.getOut(decodedInstruction.get("$rd"), "1100", "0001",
					decodedInstruction.get("$rd"), ControlUnitOutput.get("RegDst"));
			System.out.println("REGDUST    " + writeRegAlaa);
			decodedInstruction.put("$rd", writeRegAlaa);
			Hashtable<String, String> file = registerFile.getRegisters(decodedInstruction);
			ID_EX.getWB_RegWrite().setValue(ControlUnitOutput.get("RegWrite"));
			ID_EX.getWB_MemToReg().setValue(ControlUnitOutput.get("MemtoReg"));
			ID_EX.getM_MemBranch().setValue(ControlUnitOutput.get("Branch"));
			ID_EX.getM_MemRead().setValue(ControlUnitOutput.get("MemRead"));
			ID_EX.getM_MemWrite().setValue(ControlUnitOutput.get("MemWrite"));
			ID_EX.getEX_RegDst().setValue(ControlUnitOutput.get("RegDst"));
			ID_EX.getEX_ALUop().setValue(ControlUnitOutput.get("ALUOp"));
			ID_EX.getEX_ALUsrc().setValue(ControlUnitOutput.get("ALUSrc"));
			ID_EX.getM_Jump().setValue(ControlUnitOutput.get("Jump"));
			ID_EX.getEX_TCL().setValue(ControlUnitOutput.get("TCL"));
			ID_EX.getWB_Reyad().setValue(ControlUnitOutput.get("Reyad"));
			ID_EX.getWB_RegDst().setValue(writeRegAlaa);
			ID_EX.getRegister(0).setValue(IF_ID.getRegister(0).getValue());
			ID_EX.getRegister(1).setValue(file.get("$rs"));
			ID_EX.getRegister(2).setValue(file.get("$rt"));
			ID_EX.getRegister(3).setValue(immediateAfterExtend);
			ID_EX.getRegister(4).setValue(jumpAdress);
			instructionFetched = false;
			instructionDecoded = true;
			System.out.println("IN DECODE");
		}
	}

	public static void Execute() {
		if (instructionDecoded) {
			String aluin1 = shiftleft2.shiftOne(ID_EX.getRegister(3).getValue());
			String aluin2 = MUXtoALU.getOut(ID_EX.getRegister(2).getValue(), ID_EX.getRegister(3).getValue(),
					ID_EX.getEX_ALUsrc().getValue());
			String ALUOut = ALU.ALUOperations(ID_EX.getRegister(1).getValue(), aluin2, ID_EX.getEX_ALUop().getValue(),
					T.getBit())[1];
			System.out.println("alu1  " + ALUOut + "   " + ID_EX.getEX_ALUsrc().getValue() + "            "
					+ ID_EX.getRegister(1).getValue());
			String ALUOutZero = ALU.ALUOperations(ID_EX.getRegister(1).getValue(), aluin2,
					ID_EX.getEX_ALUop().getValue(), T.getBit())[0];
			String ALUOutBits = ALU.ALUOperations(ID_EX.getRegister(1).getValue(), aluin2,
					ID_EX.getEX_ALUop().getValue(), T.getBit())[2];
			String fromRsToMUXBara = ID_EX.getRegister(1).getValue();
			T.setBit(ID_EX.getEX_TCL().getValue());
			EX_MEM.getWB_RegDst().setValue(ID_EX.getWB_RegDst().getValue());
			EX_MEM.getWB_MemToReg().setValue(ID_EX.getWB_MemToReg().getValue());
			EX_MEM.getWB_RegWrite().setValue(ID_EX.getWB_RegWrite().getValue());
			EX_MEM.getM_MemBranch().setValue(ID_EX.getM_MemBranch().getValue());
			EX_MEM.getM_MemRead().setValue(ID_EX.getM_MemRead().getValue());
			EX_MEM.getM_MemWrite().setValue(ID_EX.getM_MemWrite().getValue());
			EX_MEM.getM_Jump().setValue(ID_EX.getM_Jump().getValue());
			EX_MEM.getWB_Reyad().setValue(ID_EX.getWB_Reyad().getValue());
			EX_MEM.getRegister(0).setValue(adder2.adderVar(ID_EX.getRegister(0).getValue(), aluin1));
			EX_MEM.getRegister(1).setValue(ALUOut);
			EX_MEM.getRegister(2).setValue(ID_EX.getRegister(2).getValue());
			EX_MEM.getRegister(3).setValue(fromRsToMUXBara);
			EX_MEM.getRegister(4).setValue(ID_EX.getRegister(4).getValue());
			EX_MEM.getRegister(5).setValue(ID_EX.getRegister(0).getValue());
			EX_MEM.getRegister(6).setValue(ID_EX.getRegister(5).getValue());
			EX_MEM.getRegister(7).setValue(ALUOutZero);
			EX_MEM.getRegister(8).setValue(ID_EX.getRegister(1).getValue());
			System.out.println(ALUOutBits + "               " + ID_EX.getRegister(1).getValue());
			EX_MEM.getRegister(9).setValue(ALUOutBits);
			instructionDecoded = false;
			instructionExecuted = true;
			System.out.println("IN EXECUTE");
		}
	}

	public static void WriteBack() {
		if (instructionExecuted) {
			String branched = andbranch.andd(EX_MEM.getM_MemBranch().getValue(), EX_MEM.getRegister(7).getValue());
			datamemory.setMemRead(EX_MEM.getM_MemRead().getValue().equals("1") ? true : false);
			datamemory.setMemWrite(EX_MEM.getM_MemWrite().getValue().equals("1") ? true : false);
			String outmuxellygwa = (MUXtoPC.getOut(PC.getValue(), EX_MEM.getRegister(0).getValue(), branched));
			System.out.println("PC VALUE BEFORE    " + EX_MEM.getRegister(4).getValue());
			PC.setValue(MUXtoPCBARA.getOut(outmuxellygwa, "0", EX_MEM.getRegister(3).getValue(),
					EX_MEM.getRegister(4).getValue(), EX_MEM.getM_Jump().getValue()));
			System.out.println("PC VALUE AFTER   " + PC.getValue());
			datamemory.setAddress(EX_MEM.getRegister(1).getValue());
			datamemory.writeToMemory(EX_MEM.getRegister(2).getValue());
			MEM_WB.getWB_RegDst().setValue(EX_MEM.getWB_RegDst().getValue());
			MEM_WB.getWB_MemToReg().setValue(EX_MEM.getWB_MemToReg().getValue());
			MEM_WB.getWB_RegWrite().setValue(EX_MEM.getWB_RegWrite().getValue());
			MEM_WB.getWB_Reyad().setValue(EX_MEM.getWB_Reyad().getValue());
			MEM_WB.getRegister(0).setValue(datamemory.readFromMemory());
			MEM_WB.getRegister(1).setValue(EX_MEM.getRegister(1).getValue());
			MEM_WB.getRegister(2).setValue(EX_MEM.getRegister(5).getValue());
			MEM_WB.getRegister(3).setValue(EX_MEM.getRegister(6).getValue());
			MEM_WB.getRegister(4).setValue(EX_MEM.getRegister(8).getValue());
			MEM_WB.getRegister(5).setValue(EX_MEM.getRegister(9).getValue());
			String PCValueAlaa = MEM_WB.getRegister(2).getValue();
			String wb = MUXWB.getOut(MEM_WB.getRegister(1).getValue(), PCValueAlaa, "0000000000000000",
					MEM_WB.getRegister(0).getValue(), MEM_WB.getWB_MemToReg().getValue());
			System.out.println("WB HERE AGAIN      " + wb);
			if (MEM_WB.getWB_RegWrite().getValue().equals("1")) {
				wb = aluReyad.Out(MEM_WB.getRegister(4).getValue(), wb, MEM_WB.getWB_Reyad().getValue(),
						MEM_WB.getRegister(5).getValue());
				registerFile.setRegisterByCode(MEM_WB.getWB_RegDst().getValue(), wb);
			}
			System.out.println("WROTWE DIDSTS   " + datamemory.isMemRead() + "        " + datamemory.isMemWrite());
			System.out.println("WB:" + wb);
			System.out.println("PC:" + PC.getValue());
			System.out.println("$S0    " + registerFile.getRegisterValueByName("$s0"));
			System.out.println("$S1    " + registerFile.getRegisterValueByName("$s1"));
			System.out.println("$S2    " + registerFile.getRegisterValueByName("$s2"));
			System.out.println("$RA    " + registerFile.getRegisterValueByName("$ra"));
			System.out.println("$SP    " + registerFile.getRegisterValueByName("$sp"));
			instructionExecuted = false;
			System.out.println("IN WRITEBACK");
			System.out.println("T Value  " + T.getBit());
			System.out.println("MEMORY LOCATION   " + datamemory.getMemory()[2]);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int cycles = 5;
		for (int i = 2; InstructionMemory.getMemory()[i] != null; i = i + 2) {
			cycles += i / 2;
		}
		// System.out.println(InstructionMemory.getMemory()[2]);

		for (int i = 0; i < 20; i++) {
			WriteBack();
			Execute();
			Decode();
			Fetch();
		}
	}
}
