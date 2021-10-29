package com.example;

import java.util.ArrayList;
import com.example.gpi_Department.gpi_Person.gpi_Position;

public class gpi_Department {
	public ArrayList<gpi_Person> gpi_lst = new ArrayList<gpi_Person>();

	class gpi_Person {
		protected String gpi_n; 		/* Name */
		protected gpi_Position gpi_p;	/* Position */
		
		public enum gpi_Position {
			director,
			brigadier,
			mechanic,
			fitter,
			cleaner,
			master,
			repairer,
			packer,
			controller
		}; 
		
		public gpi_Person(String gpi_n, gpi_Position gpi_p) {
			this.gpi_n = gpi_n;
			this.gpi_p = gpi_p;
		}
		
		public void gpi_printElement() {
			System.out.println("\t {");
			System.out.printf("\t\t \"%s\": \"%s\", \n", "gpi_n", this.gpi_n);
			System.out.printf("\t\t \"%s\": \"%s\", \n", "gpi_p", this.gpi_p);
			System.out.printf("\t }");
		}
	}
	
	public void gpi_main() {
		this.gpi_print();
		this.gpi_add("Natalia", gpi_Position.repairer);
		this.gpi_add("Vera", gpi_Position.packer);
		this.gpi_add("Olga", gpi_Position.controller);
		this.gpi_add("Igor", gpi_Position.brigadier);
		this.gpi_print();
	}
	
	public void gpi_add(String gpi_n, gpi_Position gpi_p) {
		this.gpi_lst.add(new gpi_Person(gpi_n, gpi_p));
	}
	
	public void gpi_print() {
		System.out.println("");
		System.out.println(" [");
		int gpi_length = this.gpi_lst.size();
		int gpi_i = 0;
		while (gpi_i < gpi_length - 1) {
			this.gpi_lst.get(gpi_i).gpi_printElement();
			System.out.println(",");
			++gpi_i;
		}
		if (gpi_length > 0) {
			
			this.gpi_lst.get(gpi_i).gpi_printElement();
		}
		System.out.println("\n ]");
		System.out.println("");
	}
}
