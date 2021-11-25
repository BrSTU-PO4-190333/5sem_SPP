package com.example;

public class GPI_AnalogThermometer extends GPI_AbstractThermometer {
	float gpi_height;
	String gpi_measurementBoundary;
	
	GPI_AnalogThermometer(float gpi_degree, float gpi_height, String gpi_measurementBoundary) {
		super(gpi_degree);
		this.gpi_height = gpi_height;
		this.gpi_measurementBoundary = gpi_measurementBoundary;
	}
	
	void gpi_print_json() {
		System.out.printf(" { \n");
		this.gpi_print_part_json();
		System.out.printf(" \t \"%s\": \"%f\", \n", "gpi_height", gpi_height);
		System.out.printf(" \t \"%s\": \"%s\" \n", "gpi_measurementBoundary", gpi_measurementBoundary);
		System.out.printf(" } \n");
	}
}
