package com.example;

public class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		System.out.println("{");
		System.out.printf("\t\t\"%s\": %d,\n", "x", this.x);
		System.out.printf("\t\t\"%s\": %d,\n", "y", this.y);
		System.out.println("\t},");
	}
}
