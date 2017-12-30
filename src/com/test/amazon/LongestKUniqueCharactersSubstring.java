package com.test.amazon;

import java.util.Scanner;

public class LongestKUniqueCharactersSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			scanner.nextLine();
			String str = scanner.nextLine();
			int k = scanner.nextInt();
			System.out.println(getLongestKUniqueCharactersSubstring(str, k));
		}
	}

	private static int getLongestKUniqueCharactersSubstring(String str, int k) {
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		int start = 0, end = 0, max = -1, counter = 0;
		int[] map = new int[26];

		while (end < length) {
			if (map[charArray[end++] - 'a']++ == 0) {
				counter++;
			}

			while (counter > k) {
				if (start < end && map[charArray[start++] - 'a']-- == 1) {
					counter--;
				}

			}
			if (counter == k) {
				max = max(max, end - start);
			}

		}

		return max == 0 ? -1 : max;
	}

	private static int max(int d, int i) {
		return d > i ? d : i;
	}

}
