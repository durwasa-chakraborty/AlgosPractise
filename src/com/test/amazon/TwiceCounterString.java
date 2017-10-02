package com.test.amazon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TwiceCounterString {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			reader.nextLine();
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			System.out.println("" + getCountRepeatedTwice(split, n));
		}
	}

	private static int getCountRepeatedTwice(String[] split, int n) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.get(split[i]) == null) {
				map.put(split[i], 1);
			} else {
				map.put(split[i], map.get(split[i]) + 1);
			}
		}

		int count = 0;
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			if (map.get(string) == 2) {
				count += 1;
			}
		}
		return count;
	}

}
