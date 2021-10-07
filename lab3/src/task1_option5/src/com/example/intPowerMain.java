package com.example;

public class intPowerMain {
	public intPowerMain() {}
	public static void Main(String[] args) {

		intPower obj1 = new intPower(5);
		intPower obj2 = new intPower(5);

		
		System.out.println("Adding items (1,1,3) to a set #1");
		obj1.add(1);
		obj1.add(1);
		obj1.add(3);
		System.out.println(obj1);
		System.out.println();
		
		
		System.out.println("Adding items (3,2,3) to a set #2");
		obj2.add(3);
		obj2.add(2);
		obj2.add(3);
		System.out.println(obj2);
		System.out.println();
		
		
		System.out.println("Union of sets (set #1, set #2)");
		obj1.union(obj2);
		System.out.println(obj1);
		System.out.println();
		
		
		System.out.println("Is there a number in the set (5, 1)");
		System.out.println(obj1.in(5));
		System.out.println(obj1.in(1));
		System.out.println(obj1);
		System.out.println();
		
		
		System.out.println("Removing an element (4, 2, 1) from a set (set #1)");
		obj1.remove(4);
		obj1.remove(2);
		obj1.remove(1);
		System.out.println(obj1);
		System.out.println();
		
		
		System.out.println("Adding an item (-5) to a set (set #1) and removing an element (3) into a set (set #1)");
		obj1.add(-5);
		obj1.remove(3);
		System.out.println(obj1);
		System.out.println();
		
		
		System.out.println("Creating a set (set #3) with a size (10) and array (-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11)");
		int[] arr3 = {-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11};
		intPower obj3 = new intPower(10, arr3);
		System.out.println(obj3);
		System.out.println();
		
		
		int a1[] = {1,2,3};
		int a2[] = {3,2,1};
		int a3[] = {6,7,8};
		int a4[] = {1,2,3};
		intPower o1 = new intPower(10, a1);
		intPower o2 = new intPower(10, a2);
		intPower o3 = new intPower(10, a3);
		intPower o4 = new intPower(9, a4);
		
		System.out.println("Comparison of sets");
		System.out.println("inPower(10, {1,2,3}).equals( inPower(10, {1,2,3}) ) : " + o1.equals(o1));
		System.out.println("inPower(10, {1,2,3}).equals( inPower(10, {3,2,1}) ) : " + o1.equals(o2));
		System.out.println("inPower(10, {1,2,3}).equals( inPower(10, {6,7,8}) ) : " + o1.equals(o3));
		System.out.println("inPower(10, {1,2,3}).equals( inPower(9,  {1,2,3}) ) : " + o1.equals(o4));
		System.out.println();
	}
}
