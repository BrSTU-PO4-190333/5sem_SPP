package com.example;

import java.util.Scanner;

public class Main {
	public static void main(String [] args)
	{
		if (args.length == 0)
		{
			Scanner console = new Scanner(System.in);
			
			System.out.println("Enter argument (3 6 8 3 1 5 9):");
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
		int [] intArray = new int[args.length];
		for (int i = 0; i < intArray.length; ++i)
		{
			intArray[i] = Integer.parseInt(args[i]);
		}
		
		int max = intArray[0];
		int min = intArray[0];
		
		for (int i = 1; i < intArray.length; ++i)
		{
			if (intArray[i] > max)
			{
				max = intArray[i];
			}
			
			if (intArray[i] < min)
			{
				min = intArray[i];
			}
		}
		
		int result = max - min;
		System.out.printf("max - min = %d\n", result);
	}
}
