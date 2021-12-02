package com.example;

public class GPI_Main {
    protected static int    gpi_fractal_size    = 16;	// Размер фрактала
    protected static int    gpi_time            = 200;	// Время через которое менять
// = = = = = = = = = = = = = = = =
    
    public static void main (String[] args) {    	
        GPI_SimpleGUI obj = new GPI_SimpleGUI (gpi_fractal_size, gpi_time);
    }
}
