package com.test.amazon;

import java.util.HashMap;
import java.util.Scanner;

public class CommonSubsequence {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			String split[] = reader.nextLine().split(" ");
			System.out.println("" + isCommonSubSequence(split[0], split[1]));
		}
	}

	private static int isCommonSubSequence(String a, String b) {
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < charArrayA.length; i++) {
			map.put((int) charArrayA[i], true);
		}

		for (int i = 0; i < charArrayB.length; i++) {
			if (map.containsKey((int) charArrayB[i])) {
				return 1;
			}
		}
		return 0;
	}
}
