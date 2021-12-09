package com.example;

public class GPI_Main {
	public static void main(String[] args) {
		GPI_AbstractThermometer[] gpi_array = new GPI_AbstractThermometer [2];
		gpi_array[0] = new GPI_ElectronicThermometer(36.6f, "пальчиковые");
		gpi_array[1] = new GPI_AnalogThermometer(36.6f, 100, "верхняя");
		
		for (int gpi_i = 0; gpi_i < 2; ++gpi_i) {
			gpi_array[gpi_i].gpi_print_json();
		}
	}
}
