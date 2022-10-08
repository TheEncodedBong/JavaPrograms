package com.teb.practice;

import java.util.Scanner;

public class DigitalRoot {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number: ");
		int input = scan.nextInt();
		
		System.out.println("Result: " + getDigitalRoot(input));
		
		scan.close();
	}

	private static int getDigitalRoot(int input) {
		
		if (input != 0 && input % 9 == 0)
			return 9;
		else
			return input % 9;
	}

}
