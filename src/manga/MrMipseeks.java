package manga;
//package main;
//import java.util.ArrayList;
//
//import pipelines.Pipeline;
//
//public class MrMipseeks
//{
//	private static Pipeline toInstructionDecodePipeline = new Pipeline(Phase.INSTRUCTION_DECODE, Phase.INSTRUCTION_FETCH);
//	private static Pipeline toExecutePipeline = new Pipeline(Phase.EXECUTE, Phase.INSTRUCTION_DECODE);
//	private static Pipeline toMemoryWritePipeline = new Pipeline(Phase.MEMORY_WRITE, Phase.EXECUTE);
//	private static Pipeline toWriteBackPipeline = new Pipeline(Phase.WRITE_BACK ,Phase.MEMORY_WRITE);
//	private static boolean sendInstructionForExecution = true;
//	private boolean [] generalPipelineStatus = new boolean[4];
//	private ArrayList<String> instructions = new ArrayList<String>();
//	
//	
//	
//	public int updateGeneralPipelineStatus()
//	{
//		generalPipelineStatus[0] = toInstructionDecodePipeline.isAvailable();
//		generalPipelineStatus[1] = toExecutePipeline.isAvailable();
//		generalPipelineStatus[2] = toMemoryWritePipeline.isAvailable();
//		generalPipelineStatus[3] = toWriteBackPipeline.isAvailable();
//		
//		for(int i = 0; i<4; i++)
//		{
//			if(generalPipelineStatus[i])
//			{
//				sendInstructionForExecution = true;
//				return i;
//			}
//		}
//		return -1;
//	}
//	
//	
//	
//	
//	public void execute(String binaryString)
//	{
//		Instruction instruction = new Instruction (binaryString);
//		
//		
//		
//	}
//	
//	public static void main(String[]args)
//	{
//		MrMipseeks mrMipsSeeks = new MrMipseeks();
//		
//		//Calls execute() on the instructions made by the user as long as there are instructions
//		if(sendInstructionForExecution)
//		{
//			while (!mrMipsSeeks.instructions.isEmpty())
//				mrMipsSeeks.execute(mrMipsSeeks.instructions.remove(0));
//		}
//			
//		}
//}
