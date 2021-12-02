package com.example;

public class GPI_Main {
	private static int					gpi_count = 9; 								// Количество окон
	private static GPI_SimpleGUI 		gpi_arr[] = new GPI_SimpleGUI [gpi_count];	// Массив окон
	private static int 					gpi_fractal_size;							// Размер фрактала
// = = = = = = = = = = = = = = = =
	
    public static void main(String[] args) {    	
    	gpi_fractal_size = 0;
    	while (gpi_fractal_size < gpi_count) {
    		gpi_arr[gpi_fractal_size] = new GPI_SimpleGUI(gpi_fractal_size);
    		++gpi_fractal_size;
    	}
    }
}
