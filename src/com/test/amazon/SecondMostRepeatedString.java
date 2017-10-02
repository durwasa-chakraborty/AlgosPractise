package com.test.amazon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SecondMostRepeatedString {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			reader.nextLine();
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			System.out.println("" + getSecondMostRepeatedString(split, n));
		}
	}

	private static String getSecondMostRepeatedString(String[] split, int n) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.get(split[i]) == null) {
				map.put(split[i], 1);
			} else {
				map.put(split[i], map.get(split[i]) + 1);
			}
		}

		String maxRepeated = "";
		int countMaxRepeated = 0;

		String secondMaxRepeated = "";
		int countSecondMaxRepeated = 0;

		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			if (countMaxRepeated < map.get(string)) {
				if (countSecondMaxRepeated < countMaxRepeated) {
					secondMaxRepeated = maxRepeated;
					countSecondMaxRepeated = countMaxRepeated;
				}
				maxRepeated = string;
				countMaxRepeated = map.get(string);
			} else if (countSecondMaxRepeated < map.get(string)) {
				secondMaxRepeated = string;
				countSecondMaxRepeated = map.get(string);
			}
		}
		return secondMaxRepeated;
	}
}
