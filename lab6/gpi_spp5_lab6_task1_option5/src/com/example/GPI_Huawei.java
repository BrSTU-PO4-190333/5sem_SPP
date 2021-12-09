package com.example;

public class GPI_Huawei extends GPI_FactoryPhone {
    public GPI_Huawei(int gpi_kg, String gpi_color) {
    	super(gpi_kg, gpi_color);
    }
    
    public void print_json() {
    	System.out.printf(" { \n");
    	this.print_part_json();
    	System.out.printf(" } \n");
    }
}
