package com.example;

import javax.swing.JFrame;

public class GPI_SimpleGUI extends JFrame {
    protected static final long serialVersionUID= 1L;   // Переменная сгенерировалась автоматически
    protected int               gpi_wingth      = 680;  // Ширина приложения
    protected int               gpi_height      = 420;  // Высота приложения
    protected String            gpi_title;              // Заголовок окна
// = = = = = = = = = = = = = = = = = = = = = = = =
    
    public GPI_SimpleGUI (int gpi_fractal_size, int gpi_time) {
        gpi_title = "gpi_spp5_lab7_task2_option5 | the Pythagorean tree of degree "
            + Integer.toString (gpi_fractal_size);
        
        setTitle (gpi_title);                           // Задаём заголовок
        setSize (gpi_wingth, gpi_height);               // Задаём размер окна
        setVisible (true);                              // Окно будет видимо
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        GRI_PythagoreanTree obj = new GRI_PythagoreanTree (gpi_wingth, gpi_height, gpi_fractal_size, gpi_time);
        add ("Center", obj);
        obj.gpi_run ();
    }
}
