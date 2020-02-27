package com.tyss.cg.ControlFlowStatements;

public class AnotherSswitchCase {
	public static void main(String[] args) {
		int dayNum=2;
		switch (dayNum) {
		case 1:
			System.out.println("monday");
			break;
		case 2:
			System.out.println("tuesday");

			break;
		case 3:
			System.out.println("wed");
			break;
		case 4:
			System.out.println("thur");
			break;
		case 5:
			System.out.println("fri");
			break;
		case 7:
			System.out.println("sat");
			break;
			case 8:
				System.out.println("sunday");
				break;

		default:
			System.out.println();
			break;
		}


	}

}