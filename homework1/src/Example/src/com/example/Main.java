package com.example;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		System.out.println();
		
		Figure[] figures = new Figure[4];
		figures[0] = new Circle(new Point(0, 0), 10);
		figures[1] = new Triangle(new Point(0,0), new Point(10,10), new Point(10, 0));
		figures[2] = new Rectangle(new Point(100, -50), 200, 100);
		figures[3] = new Square(new Point(-20, 70), 50);
		
		for (Figure f: figures) {
			System.out.println(f);
			f.draw();
			System.out.println();
		}
	}
}
