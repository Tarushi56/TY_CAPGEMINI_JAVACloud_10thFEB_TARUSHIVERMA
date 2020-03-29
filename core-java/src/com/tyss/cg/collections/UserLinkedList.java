package com.tyss.cg.collections;

import java.util.LinkedList;

import com.tyss.cg.encapsulation.User;

public class UserLinkedList {
public static void main(String[] args) {
	LinkedList<User> userlinkedList = new LinkedList<User>();
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
//user Insertion
	userlinkedList.add(user1);
	userlinkedList.add(user2);
	
	userlinkedList.addFirst(user4);
	userlinkedList.addLast(user3);
	
	
	//  retrieval user
	for (User user:userlinkedList) {
		System.out.println(user);
	}
	//retrieval of User using peak
	System.out.println(userlinkedList.peek());
	//retrieval and removal of user
	System.out.println(userlinkedList.poll());
	//retrieval of users after poll
	for (User user : userlinkedList) {
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
}
