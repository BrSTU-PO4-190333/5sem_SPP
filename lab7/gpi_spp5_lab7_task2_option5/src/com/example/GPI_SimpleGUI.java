package com.example;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GPI_SimpleGUI extends Frame {    
    GPI_SimpleGUI(int gpi_fractal_size) {
    	setTitle("gpi_spp5_lab7_task2_option5 | the Pythagorean tree of degree " + Integer.toString(gpi_fractal_size));
    	addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
    	);
        setSize(800,800);
        add("Center", new GRI_PythagoreanTree(gpi_fractal_size));
        show();
    }
}
