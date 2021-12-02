package com.example;

public class GPI_FactoryPhone {
	int			gpi_kg;
	String		gpi_color;

	GPI_FactoryPhone(int gpi_kg, String gpi_color) {
		this.gpi_kg = gpi_kg;
		this.gpi_color = gpi_color;
	}
	
	void print_part_json() {
		System.out.printf(" \t \"%s\": \"%d\", \n", "gpi_kg", gpi_kg);
		System.out.printf(" \t \"%s\": \"%s\", \n", "gpi_color", gpi_color);
	}
	
	void print_json () {}
}
