package com.example;

public class intPower {
	protected int power;
	protected int length;
	protected int[] arr;
	
	public intPower(int power) {
		this.power = power;
		this.length = 0;
		this.arr = new int [power];
	}
	
	public intPower(int power, int[] arr) {
		this.power = power;
		this.length = 0;
		this.arr = new int [power];
		
		for (int i = 0; i < arr.length; i += 1) {
			this.add(arr[i]);
		}
	}
	
	public void union(intPower object) {
		int power = object.getPower();
		int length = object.getLength();
		int[] arr = object.getArr();
		
		this.power += power;
		for (int i = 0; i < length; i += 1) {
			this.add(arr[i]);
		}
		
	}
	
	public String toString() {
		String s = "";
		s += "{";
		for (int i = 0; i < this.length - 1; i += 1) {
			s += this.arr[i] + "; ";
		}
		if (this.length > 0) {
			s += this.arr[this.length - 1];
		}
		s += "}";
		return s;
	}
	
	public boolean in(int number) {
		for (int i = 0; i < this.length; i += 1) {
			if (number == this.arr[i]) {
				return true;
			}
		}
		return false;
	}
	
	public void add(int number) {
		if (this.in(number)) {
			return;
		}
		
		if (this.power > this.length) {
			this.length += 1;
			this.arr[this.length - 1] = number;
		}
		this.sort();
	}
	
	public void sort() {
		for (int i = 0; i < this.length; i += 1) {
			for (int j = 0; j < this.length; j += 1) {
				if (this.arr[i] < this.arr[j]) {
					int temp = this.arr[i];
					this.arr[i] = this.arr[j];
					this.arr[j] = temp;
				}
			}
		}
	}
	
	public void remove(int number) {
		if (this.in(number)) {
			for (int i = 0 ; i < this.length; i += 1) {
				if (this.arr[i] == number) {
					this.length -= 1;
					for (int j = i; j < this.length; j += 1) {
						this.arr[j] = this.arr[j + 1];
					}
				}
			}
		}
	}
	
	public boolean equals(intPower object) {
		int power = object.getPower();
		if (power != this.power) {
			return false;
		}
		
		int length = object.getLength();
		if (length != this.length) {
			return false;
		}
		
		int[] arr = object.getArr();
		for (int i = 0; i < length; i += 1) {
			if (arr[i] != this.arr[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int[] getArr() {
		return this.arr;
	}
}
