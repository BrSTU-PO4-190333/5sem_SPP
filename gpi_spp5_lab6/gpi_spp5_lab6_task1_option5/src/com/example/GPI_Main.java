package com.example;

public class GPI_Main {
	public static void main(String[] args) {
		GPI_FactoryPhone[] gpi_arr = new GPI_FactoryPhone [2];
		gpi_arr[0] = new GPI_Apple(137, "black");
		gpi_arr[1] = new GPI_Huawei(150, "blue");
		
		for (int gpi_i = 0; gpi_i < 2; ++gpi_i) {
			gpi_arr[gpi_i].print_json();
		}
	}
}
