package com.example;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		sort_test();
		time_test();
	}
	
	public static void sort_test() {
		System.out.println(" TBubbleSort ");
		Double[] arr1 = new Double[] {1.0, -5.0, 2.0, -1.0, 7.0, 4.0, 0.0};
		TBubbleSort.print(arr1);
		TBubbleSort.startSort(arr1);
		TBubbleSort.print(arr1);
		System.out.println();
		
		System.out.println(" DoubleBubbleSort ");
		Double[] arr2 = new Double[] {1.0, -5.0, 2.0, -1.0, 7.0, 4.0, 0.0};
		DoubleBubbleSort.print(arr2);
		DoubleBubbleSort.startSort(arr2);
		DoubleBubbleSort.print(arr2);
		System.out.println();
	}
	
	public static void time_test() {
		long start_time = 0;
		long end_time = 0;
		double time = 0;
		
		System.out.printf("| %16s | %24s | %24s |\n",
			"array size",
			"time TBubbleSort",
			"time DoubleBubbleSort"
			);
		System.out.printf("| %16s | %24s | %24s |\n",
				"----------------",
				"------------------------",
				"------------------------"
				);
		for (int len = 1; len < 1e5; len *= 2) {
			System.out.printf("| %16d ", len);
			writeOnFile(len); writeOnFile(",");
			
			//Array 1
			Double[] arr1 = new Double[len];
			rand(arr1);
			
			start_time = System.currentTimeMillis();
			TBubbleSort.startSort(arr1);
			end_time = System.currentTimeMillis();
			time = (double) (end_time - start_time) / 1000;
			System.out.printf("| %24.12f ", time);
			writeOnFile(time); writeOnFile(",");
			
			//Array 2
			Double[] arr2 = new Double[len];
			rand(arr2);
			
			start_time = System.currentTimeMillis();
			DoubleBubbleSort.startSort(arr2);
			end_time = System.currentTimeMillis();
			time = (double) (end_time - start_time) / 1000;
			System.out.printf("| %24.12f ", time);
			writeOnFile(time); writeOnFile("\n");
			
			System.out.println("|");
		}
	}
	
	public static Double[] rand(Double[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; ++i) {
			arr[i] = Math.random();
		}
		return arr;
	}
	
	public static <T> void writeOnFile(T item) {
		try(FileWriter writer = new FileWriter("data.csv", true))
        {
            writer.write("" + item);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
	}
}
