package com.test.amazon;

import java.util.Scanner;

public class UncommonCharactersForTwoStrings {

	private static final int AVAILABLE_IN_BOTH = 2;
	private static final int AVAILABLE_IN_FIRST = 1;
	private static final int AVAILABLE_IN_SECOND = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < testCases; i++) {
			char[] first = scanner.nextLine().toCharArray();
			char[] second = scanner.nextLine().toCharArray();

			int[] alphabet = new int[26];
			for (int j = 0; j < first.length; j++) {
				int index = first[j] - 'a';
				if (alphabet[index] != AVAILABLE_IN_FIRST) {
					alphabet[index] = AVAILABLE_IN_FIRST;
				}
			}

			for (int j = 0; j < second.length; j++) {
				int index = second[j] - 'a';
				if (alphabet[index] == AVAILABLE_IN_FIRST) {
					alphabet[index] = AVAILABLE_IN_BOTH;
				} else if (alphabet[index] != AVAILABLE_IN_BOTH) {
					alphabet[index] = AVAILABLE_IN_SECOND;
				}
			}

			for (int j = 0; j < alphabet.length; j++) {
				if (alphabet[j] == AVAILABLE_IN_FIRST || alphabet[j] == AVAILABLE_IN_SECOND) {
					System.out.print(Character.valueOf((char) ('a' + j)));
				}
			}
			System.out.println();

		}
	}

}
