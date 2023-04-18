package com.teb.practice;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		
		System.out.printf("Hello world! This is %s.", name);
		
		scan.close();
	}

}
