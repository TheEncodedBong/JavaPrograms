package com.teb.practice.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadableTime {

	private static String getReadableFormat(int seconds) {

		return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
	}

	private static void getCurrentLongDate(String date) {

		try {
			System.out.println("Current date and time (long format): "
					+ new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static String getCurrentDateAndTime() {

		return LocalDate.now().atTime(LocalTime.now()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Current date and time (dd-MM-yyyy HH:mm:ss): " + getCurrentDateAndTime());
		getCurrentLongDate(getCurrentDateAndTime());

		System.out.print("Enter the seconds to convert: ");
		int seconds = scan.nextInt();

		System.out.println("Readable time (hh:mm:ss): " + getReadableFormat(seconds));

		scan.close();
	}

}
