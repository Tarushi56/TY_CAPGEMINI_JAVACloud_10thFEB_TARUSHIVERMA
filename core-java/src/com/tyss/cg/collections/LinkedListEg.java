package com.tyss.cg.collections;

import java.util.LinkedList;

public class LinkedListEg {
public static void main(String[] args) {
	LinkedList<String> linkedList = new LinkedList<String>();
	System.out.println(linkedList.size());
	System.out.println("++++");
	System.out.println("size of linkedlist after add(): "+  linkedList.size());
	System.out.println("+++");
	
	
	System.out.println(linkedList);
	System.out.println();
	linkedList.addFirst("0th");
	
	linkedList.addLast("5th");
	System.out.println("size of linkedlist afer addLast() and addFirst(): " + linkedList.size());
	
	System.out.println("linkedlist after  addlast() and addFirst() ");
	System.out.println(linkedList);
	
	
	System.out.println("linkedlist.peak()" +linkedList.peek());
	System.out.println("linkedlist.peakFirst()" +linkedList.peekFirst());
	System.out.println("linkedlist.peaklast()" +linkedList.peekLast());
	System.out.println("linkedlist.poll()" +linkedList.poll());
	System.out.println("linkedlist.pollFirst()" +linkedList.pollFirst());
	System.out.println("linkedlist.pollLast()" +linkedList.pollLast());
	
	System.out.println("linkedlist after poll methods" +linkedList.peek());
}
}
