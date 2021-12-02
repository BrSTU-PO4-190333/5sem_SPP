package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

public class GRI_PythagoreanTree extends Canvas {
	int limitCount = 0;
    int gpi_limit;
    
    GRI_PythagoreanTree (int gpi_limit) {
    	this.gpi_limit = gpi_limit;
    }
    
    public void paint(Graphics g)
    {
    	g.setColor(Color.GRAY);
        drawTree(g, 350, 650, 450, 650, gpi_limit);
    }
    
    private void drawTree(Graphics g, int x1, int y1, int x2, int y2, int limit )
    {
        if (limit == limitCount) {
        	return;
        }

        int u1 = x2-x1;
        int u2 = y2-y1;
        GPI_Point2D A = new GPI_Point2D(x1, y1);
        GPI_Point2D B = new GPI_Point2D(x2, y2);
        GPI_Point2D C = new GPI_Point2D(B.x + u2, B.y - u1);
        GPI_Point2D D = new GPI_Point2D(A.x + u2, A.y - u1);
        GPI_Point2D E = new GPI_Point2D(D.x + ((u1+u2)/2), D.y + ((u2-u1)/2)); //
        g.drawLine(A.x, A.y, B.x, B.y);
        g.drawLine(B.x, B.y, C.x, C.y);
        g.drawLine(C.x, C.y, D.x,D.y);
        g.drawLine(D.x, D.y, A.x, A.y);
        int xPoints[] = {A.x, B.x, C.x, D.x};
        int yPoints[] = {A.y, B.y, C.y, D.y};
        g.fillPolygon(xPoints,yPoints,4);
        drawTree(g, E.x, E.y, C.x, C.y, limit-1);
        drawTree(g, D.x, D.y, E.x, E.y, limit-1);
    }
}
