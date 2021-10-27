package com.example;

public class TBubbleSort {
	static <T extends Comparable<T>>T[] startSort(T[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length; ++j) {
				if (arr[i].compareTo(arr[j]) < 0) {
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	static <T> void print(T[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
