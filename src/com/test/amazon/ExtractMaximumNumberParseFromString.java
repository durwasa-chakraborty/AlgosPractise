package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/extract-maximum/0
 */
public class ExtractMaximumNumberParseFromString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < testCases; i++) {
			int max = 0;
			String inputString = scanner.nextLine();
			max = extractMaximumMine(inputString);
			System.out.println(max + "");
		}
	}

	private static int extractMaximumMine(String inputString) {
		int max = 0;
		char input[] = inputString.toCharArray();
		int length = input.length;
		int number = 0;
		int start = -1;
		for (int j = 0; j < length; j++) {
			if (input[j] < 'a') {
				if (start == -1) {
					start = j;
				}
			} else if (start != -1) {
				number = Integer.parseInt(inputString.substring(start, j));
				if (number > max) {
					max = number;
				}
				start = -1;
			}

		}

		if (start != -1) {
			number = Integer.parseInt(inputString.substring(start, length));
		}

		return Math.max(max, number);
	}

	static int extractMaximum(String str) {
		int num = 0, res = 0;

		// Start traversing the given string
		for (int i = 0; i < str.length(); i++) {
			// If a numeric value comes, start converting
			// it into an integer till there are consecutive
			// numeric digits
			if (Character.isDigit(str.charAt(i)))
				num = num * 10 + (str.charAt(i) - '0');

			// Update maximum value
			else {
				res = Math.max(res, num);

				// Reset the number
				num = 0;
			}
		}

		// Return maximum value
		return Math.max(res, num);
	}
}
