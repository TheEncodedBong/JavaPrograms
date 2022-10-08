package com.teb.practice;

import java.util.Scanner;

public class ReadableTime {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the seconds: ");
		int seconds = scan.nextInt();
		
		System.out.println(getReadableFormat(seconds));
		
		scan.close();
	}

	private static String getReadableFormat(int seconds) {

		return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
	}
}
