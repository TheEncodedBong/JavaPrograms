package com.teb.practice;

import java.util.Scanner;

public class Tribonacci {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Choose your starting sequence");
		System.out.println("1. 0, 0, 1");
		System.out.println("2. 0, 1, 1");
		System.out.println("3. 1, 1, 1");
		System.out.print("Your choice: ");
		int choice = scan.nextInt();

		System.out.print("Enter the limit: ");
		int limit = scan.nextInt();
		int[] result = null;

		switch (choice) {
		case 1:
			System.out.print("Result series: ");
			result = getTribonacciSeries(new int[] { 0, 0, 1 }, limit);
			for (int values : result) {
				System.out.print(values + " ");
			}
			break;
		case 2:
			System.out.print("Result series: ");
			result = getTribonacciSeries(new int[] { 0, 1, 1 }, limit);
			for (int values : result) {
				System.out.print(values + " ");
			}
			break;
		case 3:
			System.out.print("Result series: ");
			result = getTribonacciSeries(new int[] { 1, 1, 1 }, limit);
			for (int values : result) {
				System.out.print(values + " ");
			}
			break;
		default:
			System.out.println("Invalid option!");
		}

		scan.close();
	}

	private static int[] getTribonacciSeries(int[] start, int limit) {

		int[] result = new int[limit];
		int sum = 0;

		/* Returns empty array when limit is zero */
		if (limit == 0)
			return result;

		/* Returns data entries from start array corresponding to limit */
		if (limit < 3) {
			for (int i = 0; i < limit; i++)
				result[i] = start[i];
			return result;
		}

		/* Initializing result array with start array */
		for (int i = 0; i < start.length; i++) {
			sum += start[i];
			result[i] = start[i];
		}

		/* Adding rest of the relevant data the result array */
		for (int i = start.length; i < limit; i++) {
			result[i] = sum;
			sum += result[i - 1] + result[i - 2];
		}

		return result;
	}
}
