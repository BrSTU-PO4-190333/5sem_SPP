package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.FileReader;

public class Main {
	public static String path = "";
	public static void main(String[] args) {
		if (args.length == 0) {
			Scanner console = new Scanner(System.in);
			System.out.println("Enter the path:");
			path = console.nextLine();
		}
		else {
			path = args[0];
		}
		
		try {
			FileReader file = new FileReader(path);
			ArrayList<String> WordsArrayList = new ArrayList<String>();
			int WordIndex = 0;
			WordsArrayList.add("");
			
			int c;
			while((c=file.read())!=-1) {
				String symbol = "" + (char) c;
				int key = WordIndex;
				if (symbol.matches("\\w*")) {
					String value = WordsArrayList.get(WordIndex) + symbol;
					WordsArrayList.set(key, value);
				}
				else {
					if (WordsArrayList.get(key) != "") {
						WordIndex++;
						WordsArrayList.add("");
					}
				}
			}
			WordsArrayList.remove(WordIndex); 
			file.close();
			
			Map<Integer, ArrayList<String>> map = new HashMap<>();
			
			for (int i = 0; i < WordsArrayList.size(); i++) {
				String word = WordsArrayList.get(i);
				int key = word.length();
				if (map.get(key) == null) {
					ArrayList<String> value = new ArrayList<String>();
					value.add(word);
					map.put(key, value);
				}
				else {
					ArrayList<String> value = map.get(key);
					value.add(word);
				}
			}
			
			System.out.printf("| %24s | %12s |", "Letters in the word", "Word count");
			//System.out.print(" Array of the words");
			System.out.println();
			for(Map.Entry<Integer, ArrayList<String>> entry: map.entrySet()) {
				int key = entry.getKey();
				ArrayList<String> value = entry.getValue();
				System.out.printf("| %24s | %12s |", key, value.size());
				//System.out.print("[");
				//for (int i = 0; i < value.size(); i++) {
				//	System.out.printf("%s, ", value.get(i));
				//}
				//System.out.print("]");
				System.out.println();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
