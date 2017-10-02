package com.test.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class GroupAnagramsTogether {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			String words[] = scanner.nextLine().split(" ");

			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				char[] charArray = words[j].toCharArray();
				Arrays.sort(charArray);
				String word = String.valueOf(charArray);
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}

			}
			Iterator<String> iterator = map.keySet().iterator();

			if (map.size() == n) {
				for (int j = 0; j < n; j++) {
					System.out.print(1 + " ");
				}
			} else {

				TreeSet<Integer> set = new TreeSet<>();
				while (iterator.hasNext()) {
					set.add(map.get(iterator.next()));
				}

				Iterator<Integer> iterator2 = set.iterator();
				while (iterator2.hasNext()) {
					System.out.print(iterator2.next() + " ");
				}
			}
			System.out.println();
		}
	}

	private static boolean isAnagrams(String string1, String string2) {

		if (string1.length() != string2.length()) {
			return false;
		}

		if (string1.length() < 2 || string2.length() < 2) {
			return false;
		}
		char[] charArray = string1.toCharArray();
		char[] charArray2 = string2.toCharArray();
		int length = charArray.length;

		int hashArray[] = new int[256];
		for (int i = 0; i < length; i++) {
			hashArray[charArray[i]]++;
			hashArray[charArray2[i]]--;
		}

		for (int i = 0; i < hashArray.length; i++) {
			if (hashArray[i] != 0) {
				return false;
			}
		}

		return true;
	}

}
