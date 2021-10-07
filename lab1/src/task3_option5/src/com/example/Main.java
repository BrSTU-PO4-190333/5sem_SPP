package com.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Main {
	
	static int length = 0;
	static boolean asciiOnly = true;
	
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			Scanner console = new Scanner(System.in);		
			System.out.println("Enter the size of the row (64), or enter a string size and argument asciiOnly (64 true):");
			String line = console.nextLine();
			String myArgs[] = line.split(" ");
			
			get_length_and_asciiOnly(myArgs);
			System.out.println( randomString(length, asciiOnly) );
			return;
		}
	
		get_length_and_asciiOnly(args);
		System.out.println( randomString(length, asciiOnly) );
	}
	
	public static void get_length_and_asciiOnly(String[] args)
	{
		if (args.length == 1)
		{
			length = Integer.parseInt(args[0]);
		}
		else if (args.length == 2)
		{
			length = Integer.parseInt(args[0]);
			asciiOnly = args[1].equals("false") ? false : true;
		}
	}
	
	public static String randomString(int lenght, boolean asciiOnly)
	{
		String string = "";
	
		if (asciiOnly)
		{
			for (int i = 0; i < lenght; ++i)
			{
				char symbol = (char) random(32, 126);
				string += symbol;
			}
		}
		else
		{
			for (int i = 0; i < lenght; ++i)
			{
				char symbol = (char) random(32, 65001);
				string += symbol;
			}
		}
		
		return string;
	}
	
	public static int random(int min, int max)
	{
		if (min > max)
		{
			int temp = max;
			max = min;
			min = temp;
		}
		
		if (max < min)
		{
			int temp = max;
			max = min;
			min = temp;
		}
		
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
}
