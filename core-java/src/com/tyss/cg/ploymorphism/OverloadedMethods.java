package com.tyss.cg.ploymorphism;

public class OverloadedMethods {
	public int add(int i, int j) {
		return i + j;
	}

	public int add(int i, int j, int k) {
		return i + j + k;
	}

	public double add(int i, double d) {
		return  (i + d);
	}

	double add(double d, int j) {
		return d + j;
	}
}
