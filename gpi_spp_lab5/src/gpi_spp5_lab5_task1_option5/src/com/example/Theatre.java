package com.example;

public class Theatre extends PublicBuilding {
	@Override
	public void print_json() {
		System.out.println(" {");
		System.out.printf(" \t \"%s\": \"%s\"%s \n", "name", this.name, ",");
		System.out.printf(" \t \"%s\": \"%s\"%s \n", "street", this.street, ",");
		System.out.printf(" \t \"%s\": \"%s\"%s \n", "city", this.city, "");
		System.out.println(" }");
	}
	
	public Theatre(String name, String street, String city) {
		this.name = name;
		this.street = street;
		this.city = city;
	}
}
