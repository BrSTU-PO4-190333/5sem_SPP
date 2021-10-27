package com.example;

public class DoubleBubbleSort {
	static Double[] startSort(Double[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length; ++j) {
				if (arr[i] < arr[j]) {
					Double temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	static void print(Double[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
