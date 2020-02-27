package com.tyss.cg.encapsulation;

public class UsertesterClass {
	
	private static User setUser(String username, String password, Integer userid) {
		 return new User(username,password,userid);
	}
	
	public static void main(String[] args) {
		
		User u =new User("cadbury", "temptation", 4646);
		User u1 = setUser("Tarushi", "Donut", 20569);
		User u2 =new User();
		
		u2.setUsername("Noddy");
		u2.setUserid(2020);
		u2.setPassword("cartoon");
		System.out.println(u2);
		
		
		System.out.println(u1);
		System.out.println("username "+u1.getUsername());
		System.out.println("userid" + u1.getUserid());
		
	}

}
