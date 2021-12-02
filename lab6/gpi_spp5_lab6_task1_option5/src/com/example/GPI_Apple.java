package com.example;

public class GPI_Apple extends GPI_FactoryPhone {
	public GPI_Apple(int gpi_kg, String gpi_color){
        super(gpi_kg, gpi_color);
    }
    
	public void print_json() {
    	System.out.printf(" { \n");
    	this.print_part_json();
    	System.out.printf(" } \n");
    }
}
