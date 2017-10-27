package com.test;

import java.util.ArrayList;
import java.util.Comparator;

public class TestClass {
	static Comparator<String> comp = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			String[] split1 = o1.split(" ");
			String[] split2 = o2.split(" ");
			for (int i = 0; i < 4; i++) {
				if (!split1[i].equals(split2[i])) {
					if (Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])) {
						return -1;
					} else {
						return 1;
					}
				}
			}
			return 0;
		}
	};

	public static String findNumber(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				return "YES";
			}
		}
		return "NO";
	}

	static int[] oddNumbers(int l, int r) {
		int count = 0;
		int left = -1, right = -1;
		if (l % 2 != 0) {
			left = l;
			l += 1;
			count++;
		}
		if (r % 2 != 0) {
			right = r;
			r -= 1;
			count++;
		}

		int[] result = new int[count + ((r - l) / 2)];
		int index = 0;
		if (left != -1) {
			result[index++] = left;
		}

		if (right != -1) {
			result[result.length - 1] = right;
		}
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				result[index++] = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = oddNumbers(1, 1);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		// int i = 7;
		// System.out.println(Integer.toBinaryString(i));
		// // System.out.println("Right shift : " + Integer.toBinaryString(i >>
		// // 32));
		// i = i << 31;
		// System.out.println("left shift : " + Integer.toBinaryString(i <<
		// 32));
		// TreeSet<String> hashSet = new TreeSet<>(comp);
		// hashSet.add("1 12 2 5 $");
		// hashSet.add("1 12 2 5 $");
		// hashSet.add("1 6 5 4 $");
		// System.out.println("hash set size : " + hashSet.size());
	}
}
