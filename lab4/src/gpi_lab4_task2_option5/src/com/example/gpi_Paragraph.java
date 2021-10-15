package com.example;

import java.util.ArrayList;

public class gpi_Paragraph {
	ArrayList<gpi_Word> gpi_p = new ArrayList<gpi_Word>();	/* Paragraph */
	public class gpi_Word {
		protected String gpi_w;	/* Word */
		
		public gpi_Word(String gpi_w) {
			this.gpi_w = gpi_w;
		}
		
		public void gpi_printElement() {
			System.out.println("\t {");
			System.out.printf("\t\t \"%s\": \"%s\" \n", "gpi_w", this.gpi_w);
			System.out.printf("\t }");
		}
		
		public String gpi_getWord() {
			return this.gpi_w;
		}
	}
	
	public void gpi_main() {
		this.gpi_add("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, voluptatibus!");
		this.gpi_printJSON();
		this.gpi_print();
	}
	
	public void gpi_print() {
		int gpi_length = this.gpi_p.size();
		int gpi_i = 0;
		while(gpi_i < gpi_length) {
			System.out.printf("%s ", this.gpi_p.get(gpi_i).gpi_getWord());
			++gpi_i;
		}
		System.out.println("");
	}
	
	public void gpi_printJSON() {
		int gpi_length = this.gpi_p.size();
		int gpi_i = 0;
		System.out.println(" [");
		while(gpi_i < gpi_length - 1) {
			this.gpi_p.get(gpi_i).gpi_printElement();
			System.out.println(",");
			++gpi_i;
		}
		if (gpi_length > 0) {
			this.gpi_p.get(gpi_i).gpi_printElement();
		}
		System.out.println("\n ]");
	}
	
	public void gpi_add(String gpi_str) {
		String[] gpi_arr = gpi_str.split(" ");
		int gpi_length = gpi_arr.length;
		int gpi_i = 0;
		while(gpi_i < gpi_length) {
			this.gpi_p.add(new gpi_Word(gpi_arr[gpi_i]));
			++gpi_i;
		}
	}
}
