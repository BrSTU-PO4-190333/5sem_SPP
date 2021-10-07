package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {
	public static String arg = "";
	public static String path1 = "";
	public static String path2 = "";
	//Main function
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Write command:");
			Scanner console = new Scanner(System.in);
			String LineArgs = console.nextLine();
			args = LineArgs.split(" ");
		}
		
		String line = "";
		int length = args.length;
		for (int i = 0; i < length; i++) {
			line += args[i];
			line += " ";
		}
		
		if (Regex(line, "cp [\\w\\./]+ [\\w\\./]+ -\\w+")) {
			System.out.println("[!] Begin case cp path1 path2 -args");
			path1 = args[1];
			path2 = args[2];
			arg = args[3];
			System.out.println("[!] End case cp");
		}
		else if (Regex(line, "cp -\\w+ [\\w\\./]+ [\\w\\./]+")) {
			System.out.println("[!] Begin case cp -args path1 path2");
			arg = args[1];
			path1 = args[2];
			path2 = args[3];
			System.out.println("[!] End case cp");
		}
		else if (Regex(line, "cp [\\w\\./]+ [\\w\\./]+")) {
			System.out.println("[!] Begin case cp path1 path2");
			path1 = args[1];
			path2 = args[2];
			System.out.println("[!] End case cp");
		}
		else {
			System.out.println("Error command format");
		}
		
		//the string contains the character n
		if (Regex(arg, "n")) {
			System.out.println("[!] Begin case n");
			System.out.println("[!] End case n");
		} //the string contains the character i
		else if (Regex(arg, "i")) {
			System.out.println("[!] Begin case i");
			SetPath2();
			System.out.println("[!] End case i");
		}
		//the string contains the character f
		if (Regex(arg, "f")) {
			System.out.println("[!] Begin case f");
			DeleteFile(path2);
			System.out.println("[!] End case f");
		}
		CopyFile(path1, path2);
	}
	//Function deletes file
	public static void DeleteFile(String path) {
		File file = new File(path);

		if (file.delete()) {  
			System.out.println(file.getName() + " deleted");   
		} else {
			System.out.println(file.getName() + " not deleted");   
		} 
	}
	//The function reads the first file and writes the file to the second file
	public static void CopyFile(String path1, String path2) {
		try {
			FileReader file1 = new FileReader(path1);
			FileWriter file2 = new FileWriter(path2);
			
			int c;
            while((c=file1.read())!=-1){
                //System.out.print((char)c);
                file2.write((char) c);
            }
            file1.close();
            file2.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("[!!!] File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End CopyFile");
	}
	//The function checks whether the file names are equal
	public static boolean File1equalFile2(String path1, String path2)
	{
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		String name1 = file1.getName();
		String name2 = file2.getName();
				
		if (name1.equals(name2)) return true;
		else return false;
	}
	//Enter y to change path 2
	public static void SetPath2() {
		if (File1equalFile2(path1, path2)) {
			System.out.print("Overwrite the file [Y/n]: ");
			Scanner console = new Scanner(System.in);
			String command = console.nextLine();
			if (Regex(command, "[Yy]")) {
				System.out.print("path2 = ");
				path2 = console.nextLine();
				SetPath2();
			}
		}
		else return;
	}
	//Function checks string and regular expression
	public static boolean Regex(String Str, String RegexStr) {
		Pattern p = Pattern.compile(RegexStr);
		Matcher m = p.matcher(Str);
		return m.find();
	}
}
