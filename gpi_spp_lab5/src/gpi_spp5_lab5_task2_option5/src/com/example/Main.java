package com.example;

public class Main {
	public static void main(String[] args) {
		Employee[] arr = new Employee [6];
		arr[0] = new Manager();
		arr[1] = new Analyst();
		arr[2] = new Programmer();
		arr[3] = new Tester();
		arr[4] = new Designer();
		arr[5] = new Accountant();
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i].print_json();
		}
	}
}
