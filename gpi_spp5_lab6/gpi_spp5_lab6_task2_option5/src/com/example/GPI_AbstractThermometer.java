package com.example;

public abstract class GPI_AbstractThermometer {
	float gpi_degree;
	
	GPI_AbstractThermometer(float gpi_degree) {
		this.gpi_degree = gpi_degree;
	}
	
	void gpi_print_part_json() {
		System.out.printf(" \t \"%s\": \"%f\", \n", "gpi_degree", gpi_degree);
	}
	
	void gpi_print_json() {}
}
