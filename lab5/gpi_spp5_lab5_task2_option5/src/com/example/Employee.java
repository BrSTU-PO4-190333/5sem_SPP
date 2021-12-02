package com.example;

public abstract class Employee {
	public String position = "NoName";
	public float payday = 0;
	
	public void print_json() {
		System.out.println(" {");
		System.out.printf(" \t \"%s\": \"%s\"%s \n", "position", this.position, ",");
		System.out.printf(" \t \"%s\": \"%.2f\"%s \n", "payday", this.payday, "");
		System.out.println(" }");
	}
}
