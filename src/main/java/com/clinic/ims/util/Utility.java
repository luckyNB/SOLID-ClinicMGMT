package com.ims.util;

import java.util.Scanner;

public class Utility {

	public static Scanner scanner = new Scanner(System.in);

	public static String inputString(String string) {
		System.out.println(string);
		return (scanner.next());
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
