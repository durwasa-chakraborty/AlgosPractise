package com.test.amazon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumEqualsToSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}

			System.out.println("" + getIsSameSumPairExists(arr, n));
		}

	}

	private static int getIsSameSumPairExists(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		for (int j = 0; j < n; j++) {
			for (int j2 = j + 1; j2 < n; j2++) {
				if (!set.add(arr[j] + arr[j2])) {
					return 1;
				}
			}
		}
		return 0;
	}

}
