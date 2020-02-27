package com.tyss.cg.collections;

// we are trying to create our own custom lists
public class CustomList {
	String[] list;
	private int pointer = 0;

	public CustomList() {
		list = new String[10];
	}

	public CustomList(int size) {
		list = new String[size];
	}

	public void add(String element) {
		if (element != null) {

			if (pointer >= list.length - 2) {
				list[pointer] = element;
				pointer++;
			} else {
				String[] newList = new String[list.length + 6];
				System.arraycopy(list, 0, newList, 0, list.length);
				list = newList;
				list[pointer] = element;
				pointer++;
			}
		} else {
			throw new NullPointerException();
		}
	}

	public String get(int index) {
		return list[index];
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				return size;
			} else {
				size++;
			}
		}
		return size;
	}

	public boolean contains(String element) {
		boolean flag = false;
		for (int i = 0; i < pointer; i++) {
			if (list[i] != null && list[i].equalsIgnoreCase(element)) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public int getIndex(String element) {
		for (int i = 0; i < pointer; i++) {
			if (list[i].equalsIgnoreCase(element)) {
				return i;
			}
		}
		return -1;

	}
}
