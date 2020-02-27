package com.tyss.cg.ControlFlowStatements;

public class ElseIfLadder {
	public static void main(String[] args) {
		int number=43;
		if(number<13)
			System.out.println("not teen number (number below 13)");
			else if (number>=13&&number<=19)
				System.out.println("teen number");
				else
					System.out.println("not a teen mumber(number above 19)");
				
			
	}

}
