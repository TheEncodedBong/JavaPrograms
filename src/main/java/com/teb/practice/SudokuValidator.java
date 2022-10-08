package com.teb.practice;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class SudokuValidator {

	static final int LIMIT = 9;
	static Set<Integer> entry = new LinkedHashSet<>();
	Logger logger = Logger.getLogger("SudokuValidator");

	public static void main(String[] args) {

		int[][] input = {
				{ 3, 9, 4, 7, 5, 6, 1, 2, 8 },
				{ 2, 7, 8, 9, 1, 3, 5, 6, 4 },
				{ 6, 5, 1, 8, 4, 2, 7, 3, 9 },
				{ 1, 3, 9, 5, 7, 8, 2, 4, 6 },
				{ 8, 2, 6, 1, 3, 4, 9, 5, 7 },
				{ 7, 4, 5, 2, 6, 9, 3, 8, 1 },
				{ 5, 1, 3, 4, 8, 7, 6, 9, 2 },
				{ 9, 8, 7, 6, 2, 5, 4, 1, 3 },
				{ 4, 6, 2, 3, 9, 1, 8, 7, 5 }
		};

		if (isValidSolution(input))
			System.out.println("Sudoku solution is valid.");
	}

	private static boolean isValidSolution(int[][] input) {

		if (!isValidBoard(input))
			return false;

		/* Check unique rows */
		for (int row = 0; row < LIMIT; row++) {
			for (int column = 0; column < LIMIT; column++) {
				if (!entry.add(input[row][column])) {
					System.out.println("Duplicate value found.");
					return false;
				}
			}
			System.out.println(entry);
			entry.clear();
		}

		/* Check unique columns */
		for (int row = 0; row < LIMIT; row++) {
			for (int column = 0; column < LIMIT; column++) {
				if (!entry.add(input[column][row])) {
					System.out.println("Duplicate value found.");
					return false;
				}
			}
			System.out.println(entry);
			entry.clear();
		}

		/* Check unique blocks of three */
		for (int row = 0; row < LIMIT - 2; row += 3) {
			for (int column = 0; column < LIMIT - 2; column += 3) {
				System.out.print("Block of three: ");
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!entry.add(input[row + i][column + j])) {
							System.out.println("Duplicate value found.");
							return false;
						}
					}
				}
				System.out.println(entry);
				entry.clear();
			}
		}

		return true;
	}

	private static boolean isValidBoard(int[][] input) {

		if (input.length < LIMIT || input.length > LIMIT)
			return false;

		for (int row = 0; row < LIMIT; row++) {
			for (int column = 0; column < LIMIT; column++) {
				if (input[row][column] <= 0 || input[row][column] > 9) {
					System.out.println("Values can only be between 1 and 9.");
					return false;
				}
			}
		}
		return true;
	}
}
