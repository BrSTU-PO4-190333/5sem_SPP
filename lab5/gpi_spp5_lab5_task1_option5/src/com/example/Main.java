package com.example;

public class Main {
	public static void main(String[] args) {
		Theatre obj = new Theatre(
			"Брестский академический театр драмы имени Ленинского комсомола Беларуси",
			"Ленина, 21",
			"Брест"
		);
		
		obj.print_json();
	}
}
