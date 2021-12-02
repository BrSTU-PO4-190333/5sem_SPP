package com.example;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class GPI_SimpleGUI extends JFrame {
	private static final long serialVersionUID = 1L; // Переменная сгенерировалась автоматически
	private int 	gpi_wingth 	= 680;			// Ширина приложения
	private int 	gpi_height 	= 460;			// Высота приложения
	private int 	gpi_x 		= 0;			// x
	private int 	gpi_y 		= 0;			// y
	private int 	gpi_r 		= 200;			// Радиус
	private int 	gpi_t 		= 100;			// Время через которое менять
	private int 	gpi_s 		= 8;			// Шаг
	private Color 	gpi_c 		= Color.BLACK;	// Цвет линии
// = = = = = = = = = = = = = = = = = = = = = = = =

	// Конструктор
	public GPI_SimpleGUI() {
		setTitle("gpi_spp5_lab7_task1_option5");// Задаём заголовок
		setSize(gpi_wingth, gpi_height);		// Задаём размер окна
		setVisible(true);						// Окно будет видимо
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		// Рисуем фон
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gpi_wingth, gpi_height);
		
		// Рисуем оси
		g.setColor(Color.GRAY);
		g.drawLine(0, gpi_height/2, gpi_wingth, gpi_height/2);
		g.drawLine(gpi_wingth/2, 0, gpi_wingth/2, gpi_height);
		
		// Рисуем линию
		g.setColor(gpi_c);
		g.drawLine(
			gpi_wingth/2,
			gpi_height/2,
			gpi_wingth/2 + gpi_x,
			gpi_height/2 - gpi_y
		);
	}
	
	public void gpi_run() {
		while(true) {
			gpi_calculate_y();
			repaint();
			gpi_sleep(gpi_t);
		}
	}
	
	private void gpi_sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void gpi_calculate_y() {
		System.out.printf(" { x: %4d, y: %4d, ", gpi_x, gpi_y);
		
		// Если точка в нуле
		if (gpi_x == 0 && gpi_y == 0) {
			gpi_c = Color.GRAY;
			gpi_y += gpi_s;
			gpi_x = gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "START");
			return;
		}
		
		// Если точка в первой четверти
		if (gpi_x > 0 && gpi_y > 0) {
			gpi_c = Color.RED;
			gpi_y -= gpi_s;
			gpi_x = gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "I");
			return;
		}
		
		// Если точка между первой и второй четвертью
		if (gpi_x > 0 && gpi_y == 0) {
			gpi_c = Color.PINK;
			gpi_y -= gpi_s;
			gpi_x = gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "I-II");
			return;
		}
		
		// Если точка во второй четверти
		if (gpi_x > 0 && gpi_y < 0) {
			gpi_c = Color.ORANGE;
			gpi_y -= gpi_s;
			gpi_x = gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "II");
			return;
		}
		
		// Если точка между второй и третьей четверью
		if (gpi_x == 0 && gpi_y < 0) {
			gpi_c = Color.PINK;
			gpi_y += gpi_s;
			gpi_x = - gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "II-III");
			return;
		}
		
		// Если точка в третьей четверти
		if (gpi_x < 0 && gpi_y < 0) {
			gpi_c = Color.GREEN;
			gpi_y += gpi_s;
			gpi_x = - gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "III");
			return;
		}
		
		// Если точка между третьей и четвёртой четвертью
		if (gpi_x < 0 && gpi_y == 0) {
			gpi_c = Color.PINK;
			gpi_y += gpi_s;
			gpi_x = - gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "III-IV");
			return;
		}
		
		// Если точка в четвёртой четверти
		if (gpi_x < 0 && gpi_y > 0) {
			gpi_c = Color.BLUE;
			gpi_y += gpi_s;
			gpi_x = - gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "IV");
			return;
		}
		
		// Если точка между четвёртой и первой четвертью
		if (gpi_x == 0 && gpi_y > 0) {
			gpi_c = Color.PINK;
			gpi_y -= gpi_s;
			gpi_x = gpi_calculate_x();
			System.out.printf("position: \"%-8s\" } \n", "IV-I");
			return;
		}
	}
	
	protected int gpi_calculate_x() {
		// x^2 + y^2 = r^2  ==>  x = sqrt(r^2 - y^2)
		return (int) Math.sqrt(Math.pow(gpi_r, 2) - Math.pow(gpi_y, 2));
	}
}
