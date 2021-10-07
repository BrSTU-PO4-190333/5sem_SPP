package com.example;

public class Triangle extends Figure {
	public Point point2;
	public Point point3;
	
	public Triangle(Point point, Point point2, Point point3) {
		this.point = point;
		this.point2 = point2;
		this.point3 = point3;
	}
	
	public void draw() {
		System.out.println("{");
		System.out.printf("\t\"%s\": ", "point");
		point.draw();
		System.out.printf("\t\"%s\": {\n", "point2");
		System.out.printf("\t\t\"%s\": %d,\n", "x", this.point2.x);
		System.out.printf("\t\t\"%s\": %d,\n", "y", this.point2.y);
		System.out.println("\t},");
		System.out.printf("\t\"%s\": {\n", "point3");
		System.out.printf("\t\t\"%s\": %d,\n", "x", this.point3.x);
		System.out.printf("\t\t\"%s\": %d,\n", "y", this.point3.y);
		System.out.println("\t},");
		System.out.println("}");
	}
}
