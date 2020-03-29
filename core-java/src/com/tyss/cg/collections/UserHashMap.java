package com.tyss.cg.collections;

import java.util.HashMap;

import com.tyss.cg.encapsulation.User;

public class UserHashMap {
	public static void main(String[] args) {
		HashMap<String, User> userHashMap = new HashMap<String, User>();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();

		user1.setUserid(20200001);
		user1.setUsername("a");
		user1.setPassword("qwerty");
		
		user2.setUserid(20200002);
		user2.setUsername("scooby");
		user2.setPassword("asd");
		
		user3.setUserid(20200003);
		user3.setUsername("noddy");
		user3.setPassword("zxc");
		
		user4.setUserid(20200004);
		user4.setUsername("henry");
		user4.setPassword("poi");
		
		userHashMap.put("1st-user",user1);
		userHashMap.put("2st-user",user2);
		userHashMap.put("3st-user",user3);
		userHashMap.put("4st-user",user4);
		
		// retrieval of user
		System.out.println("userhashmap after data insertion");
		System.out.println(userHashMap);
		System.out.println("++");
		
		//update of data
		user4.setPassword("qwerty@12345");
		userHashMap.put("4th-user",user4);
		System.out.println("+++++");
		
		//retrieval of data  after update
		System.out.println("userHashMap after data upgradation");
		System.out.println(userHashMap);
		System.out.println("+++++");
		
		//deletion of the user
		userHashMap.remove("3rd-user");
		System.out.println();
		//retrieval of data after deletion
		System.out.println("userHashMap after data deletion..");
		System.out.println(userHashMap);
		System.out.println("++++");
	}
	
	
}
