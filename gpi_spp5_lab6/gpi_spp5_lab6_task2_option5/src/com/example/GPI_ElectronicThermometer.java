package com.example;

public class GPI_ElectronicThermometer extends GPI_AbstractThermometer {
	String gpi_batteryType;
	
	GPI_ElectronicThermometer(float gpi_degree, String gpi_batteryType) {
		super(gpi_degree);
		this.gpi_batteryType = gpi_batteryType;
	}
	
	void gpi_print_json() {
		System.out.printf(" { \n");
		this.gpi_print_part_json();
		System.out.printf(" \t \"%s\": \"%s\" \n", "gpi_batteryType", gpi_batteryType);
		System.out.printf(" } \n");
	}
}
