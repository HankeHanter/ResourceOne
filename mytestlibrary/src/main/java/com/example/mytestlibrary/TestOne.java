package com.example.mytestlibrary;

public class TestOne {
	
	private static String sex = "boy";
	
	private String name = "Jim";
	public TestOne() {
		// TODO Auto-generated constructor stub
		System.out.println(name);
		System.out.println("hello");
	}
	
	public void show() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		TestOne testOne = new TestOne();
		System.out.println(sex);
	}
}
