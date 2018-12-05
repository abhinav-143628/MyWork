package com.abhi.java.core;

public class TestClass2String {
	static String abc = "abc";
	static String abc1 = new String("abc");
	
	static void checkString(){
		System.out.println(abc==abc1);
		System.out.println(abc.equals(abc1));
		
		System.out.println("changed refernce");
		abc = "Abc";
		System.out.println(abc==abc1);
		System.out.println(abc.equals(abc1));
		System.out.println(abc.equalsIgnoreCase(abc1));
	}

	public static void main(String[] args) {
		checkString();
	}

}
