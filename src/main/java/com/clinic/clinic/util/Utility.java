package com.clinic.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
	static int count = 0;
	public static Scanner scanner = new Scanner(System.in);
	public static Pattern pattern = null;

	public static String inputString(String string) {
		System.out.println(string);
		return (scanner.nextLine());
	}
	
	public static int inputInteger() {
		return (Integer.parseInt(scanner.next()));
	}

	public static int inputInteger(String string) {
		System.out.println(string);
		return (Integer.parseInt(scanner.nextLine()));
	}

	public static long inputLong(String string) {
		System.out.println(string);
		return (Long.parseLong(scanner.nextLine()));
	}

	public static double inputDouble(String string) {
		System.out.println(string);
		return (Double.parseDouble(scanner.nextLine()));
	}

	/******************
	 * static method for taking input as String
	 **************************/
	public static String inputString() {
		return (scanner.nextLine());
		// sc.close();

	}

	public static String getStringValue() {
		return (scanner.next());
	}

	public static String inputStringValue() {
		return (scanner.next());

	}
}
