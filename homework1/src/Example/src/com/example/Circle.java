package com.example;

public class Circle extends Figure {
	public int rad;
	
	public Circle(Point point, int rad) {
		this.point = point;
		this.rad = rad;
	}
	
	public void draw() {
		System.out.println("{");
		System.out.printf("\t\"%s\": ", "point");
		point.draw();
		System.out.printf("\t\"%s\": %d,\n", "rad", this.rad);
		System.out.println("}");
	}
}
