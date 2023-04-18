package com.teb.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPlay {

	/* Reverse each element of the array */
	private static void reverseStream(String[] array) {

		System.out.println("Reversing...");
		Stream.of(array).forEach(index -> System.out.println(new StringBuilder(index).reverse().toString()));
	}

	/* Sort the elements in an array */
	private static void sortStream(String[] array) {

		System.out.println("Sorting...");
		Stream.of(array).sorted().forEach(System.out::println);
	}

	/* Filtering elements based on condition */
	private static void filterStream(String[] array) {

		System.out.println("Filtering...");
		Arrays.stream(array).filter(index -> index.startsWith("h")).sorted().forEach(System.out::println);
	}

	/* Formatting elements in an array */
	private static void formatStream(String[] array) {

		System.out.println("Formatting...");
		Stream.of(array).map(String::toUpperCase).sorted().forEach(System.out::println);
	}

	/* Stream used with List class */
	private static void listStream(String[] array) {

		System.out.println("Using List class...");
		List<String> stringList = Arrays.asList(array);
		stringList.stream().forEach(index -> System.out.println(index));
	}

	/* Stream of specific type */
	private static void intStream(int[] array) {

		System.out.println("Using IntStream class...");
		System.out.println(IntStream.of(array).sum());
	}

	public static void main(String[] args) {

		String[] stringArrayOne = { "dw", "az", "by", "cx" };
		String[] stringArrayTwo = { "hit", "kit", "his", "lit" };
		int[] integerArray = { 2, 1, 16, 4, 8 };

		reverseStream(stringArrayOne);
		sortStream(stringArrayTwo);
		filterStream(stringArrayTwo);
		formatStream(stringArrayOne);
		listStream(stringArrayTwo);
		intStream(integerArray);
	}

}
