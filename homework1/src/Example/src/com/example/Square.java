package com.example;

public class Square extends Rectangle {
	
	public float a;
	
	public Square(Point point, int width) {
		super(point, width, width);
	}
	
	public void draw() {
		System.out.println("{");
		System.out.printf("\t%s: ", "point");
		point.draw();
		System.out.printf("\t%s: %d,\n", "width", this.width);
		System.out.println("}");
	}
}
