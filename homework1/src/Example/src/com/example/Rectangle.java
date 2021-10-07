package com.example;

public class Rectangle extends Figure {
	public int width;
	public int height;
	
	public Rectangle(Point point, int width, int height) {
		this.point = point;
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		System.out.println("{");
		System.out.printf("\t\"%s\": ", "point");
		point.draw();
		System.out.printf("\t\"%s\": %d,\n", "width", this.width);
		System.out.printf("\t\"%s\": %d,\n", "height", this.height);
		System.out.println("}");
	}
}
