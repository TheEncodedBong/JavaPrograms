package com.teb.practice.numbers;

import java.util.Scanner;

public class NthOccurrence {

	private static int getOccurrence(String target, String search, int occur) {

		String tempString = target;
		int tempIndex = -1;
		int finalIndex = 0;
		int counter = 0;

		for (int index = 0; index < occur; index++) {
			tempIndex = tempString.indexOf(search);
			if (tempIndex == -1) {
				break;
			}
			tempString = tempString.substring(++tempIndex);
			finalIndex += tempIndex;
			counter++;
		}

		if (counter < occur)
			return 0;
		else
			return --finalIndex;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter string to search in: ");
		String target = scan.nextLine();
		System.out.print("Enter string to search: ");
		String search = scan.next();
		System.out.print("Enter required occurrence: ");
		int occur = scan.nextInt();
		int result = getOccurrence(target, search, occur);

		if (result == 0)
			System.out.println("The desired occurrence of the string was not found.");
		else
			System.out.printf("The start index of %s in %s is %d", search, target, result);

		scan.close();
	}

}
