package com.tyss.cg.ControlFlowStatements;

public class Switch {
	public static void main(String[] args) {
		String day="Saturday";
		switch (day) {
		case "Monday":
			System.out.println("its a weekday");
			
			break;
		case "Tuesday":
			System.out.println("its a weekday");
			break;
		case "Wednesday":
			System.out.println("its a weekday");
			break;
		case "Thursday":
			System.out.println("its a weekday");
			break;
		case "Friday":
			System.out.println("its a weekday");
			break;
		case "Saturday":
			System.out.println("its a weekend");
			break;
		case "Sunday":
			System.out.println("its a weekend");
			break;

		default:
			System.out.println("invalid option");
			break;
		}
	}

}
