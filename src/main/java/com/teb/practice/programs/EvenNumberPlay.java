package com.teb.practice.programs;

import java.util.Scanner;

public class EvenNumberPlay {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the starting point: ");
		int start = scan.nextInt();
		System.out.println("Enter the limit: ");
		int limit = scan.nextInt();

		/* If the starting point is odd, move to next even number */
		if (start % 2 != 0)
			++start;
		/* If the limit is odd, move to previous even number */
		if (limit % 2 != 0)
			--limit;

		System.out.println("Choose your operation");
		System.out.println("1. Add");
		System.out.println("2. Multiply");
		System.out.println("Your choice: ");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			System.out.println(evenAdd(start, limit));
			break;
		case 2:
			System.out.println(evenMultiply(start, limit));
			break;
		default:
			System.out.println("Invalid option!");
		}

		scan.close();
	}

	private static int evenAdd(int start, int limit) {
		int result = start;

		while (start < limit) {
			start += 2;
			result += start;
		}

		return result;
	}

	private static int evenMultiply(int start, int limit) {
		int result = start;

		while (start < limit) {
			start += 2;
			result *= start;
		}

		return result;
	}
}
