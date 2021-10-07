package com.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			Scanner console = new Scanner(System.in);
			
			System.out.println("Enter arguments (2 2 1 2 3 2 4 2 5 6 2 2 2 7 2 2 2 2 8 2 2 2):");
			String string = console.nextLine();
			System.out.println();
			
			String myArgs[] = string.split(" ");
			
			lab_function(myArgs);
		}
		else
		{
			lab_function(args);
		}
	}

	public static void lab_function(String [] args)
	{
		long[] arr = string_array_to_long_array(args);
		
		System.out.print("Which element to remove from the array (2): ");
		Scanner console = new Scanner(System.in);
		long deleted_element = console.nextLong();
		
		arr = removeElement(arr, deleted_element);
		
		System.out.println("Array after deleting an item " + deleted_element + ":");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static long[] string_array_to_long_array(String[] stringArray)
	{
		int length = stringArray.length;
		long[] longArray = new long [length];
		for (int i = 0; i < length; i++)
		{
			longArray[i] = Long.parseLong(stringArray[i]);
		}
		return longArray;
	}
	
	public static long[] removeElement(long[] array, long element)
	{
		int length = array.length;
		for (int i = 0; i < length; i++)
		{
			if (array[i] == element)
			{
				length -= 1;
				for (int j = i; j < length; j++)
				{
					array[j] = array[j + 1];
				}
				i--;
			}
		}
		
		long[] resultArr = new long[length];
		for (int i = 0; i < length; i++)
		{
			resultArr[i] = array[i];
		}

		return resultArr;
	}
}
