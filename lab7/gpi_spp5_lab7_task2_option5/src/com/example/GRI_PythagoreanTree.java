package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class GRI_PythagoreanTree extends Canvas {
    protected static final long serialVersionUID= 1L;   // Переменная сгенерировалась автоматически
    protected final int         gpi_limit       = 0;
    protected int               gpi_step        = 1;    // Шаг фрактала
    protected int               gpi_time;               // Время через которое менять
    protected int               gpi_wingth;             // Ширина приложения
    protected int               gpi_height;             // Высота приложения
    protected int               gpi_fractal_size;
    
    GRI_PythagoreanTree (int gpi_wingth, int gpi_height, int gpi_fractal_size, int gpi_time) {
        this.gpi_wingth = gpi_wingth;
        this.gpi_height = gpi_height;
        this.gpi_fractal_size = gpi_fractal_size;
        this.gpi_time = gpi_time;
    }
    
    public void paint (Graphics g)
    {
        g.setColor (Color.WHITE);
        g.fillRect (0, 0, gpi_wingth, gpi_height);
        
        g.setColor (Color.RED);
        gpi_drawTree (
            g,
            gpi_wingth/2 - gpi_wingth/16,
            gpi_height - 64,
            gpi_wingth/2 + gpi_wingth/16,
            gpi_height - 64,
            gpi_fractal_size
        );
    }
    
    protected void gpi_drawTree (Graphics g, int x1, int y1, int x2, int y2, int limit)
    {
        if (limit == gpi_limit) {
            return;
        }

        int u1 = x2 - x1;
        int u2 = y2 - y1;
        
        GPI_Point2D A = new GPI_Point2D (x1, y1);
        GPI_Point2D B = new GPI_Point2D (x2, y2);
        GPI_Point2D C = new GPI_Point2D (B.x + u2, B.y - u1);
        GPI_Point2D D = new GPI_Point2D (A.x + u2, A.y - u1);
        GPI_Point2D E = new GPI_Point2D (D.x + ((u1+u2)/2), D.y + ((u2-u1)/2));
        
        g.drawLine (A.x, A.y, B.x, B.y);
        g.drawLine (B.x, B.y, C.x, C.y);
        g.drawLine (C.x, C.y, D.x, D.y);
        g.drawLine (D.x, D.y, A.x, A.y);
        
        int xPoints[] = { A.x, B.x, C.x, D.x };
        int yPoints[] = { A.y, B.y, C.y, D.y };
        
        g.fillPolygon (xPoints, yPoints, 4);
        
        gpi_drawTree (g, E.x, E.y, C.x, C.y, limit-1);
        gpi_drawTree (g, D.x, D.y, E.x, E.y, limit-1);
    }
    
    public void gpi_run () {
        gpi_fractal_size = 0;
        while(true) {
            if (gpi_fractal_size > 9) {
                gpi_step = -1;
            }
            
            if (gpi_fractal_size <= 0) {
                gpi_step = 1;
            }
            
            repaint ();
            gpi_sleep (gpi_time);
            
            gpi_fractal_size += gpi_step;
        }
    }
    
    protected void gpi_sleep (int time) {
        try {
            Thread.sleep (time);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
