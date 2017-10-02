package com.test.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class CountElementsLessThenInOtherArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int a[] = new int[n];
			int b[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}

			for (int j = 0; j < n; j++) {
				b[j] = scanner.nextInt();
			}

			// Arrays.sort(b);
			// for (int j = 0; j < n; j++) {
			// System.out.print((indexOfElementsLessThan(a[j], b, 0, n - 1) + 1)
			// + (j == n - 1 ? "" : ","));
			// }

			usingOn(a, b, n);
			System.out.println();

		}
	}

	private static int indexOfElementsLessThan(int element, int[] b, int low, int high) {
		if (low > high) {
			return high;
		}

		if (low == high) {
			return b[low] > element ? -1 : low;
		}

		int middle = (low + high) / 2;

		if (middle > low && b[middle - 1] <= element && b[middle] > element) {
			return middle - 1;
		}

		if (middle < high && b[middle] <= element && b[middle + 1] > element) {
			return middle;
		}

		if (b[middle] <= element) {
			return indexOfElementsLessThan(element, b, middle + 1, high);
		}

		return indexOfElementsLessThan(element, b, low, middle - 1);
	}

	private static void usingOn(int[] a, int[] b, int n) {

		// 100 IS LIMIT OF VALUES FOR TEST CASE
		int[] sum = new int[100];

		// put count for b array
		for (int i = 0; i < n; i++) {
			sum[b[i]] += 1;
		}

		// find max for A
		int maxA = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (maxA < a[i]) {
				maxA = a[i];
			}
		}

		int sumLessThen[] = new int[100];

		// adding counter from sum and in loop also previous elements are also
		// less so adding counter sumLessThen[i-1]
		sumLessThen[0] = sum[0];
		for (int i = 1; i <= maxA; i++) {
			sumLessThen[i] += (sum[i] + sumLessThen[i - 1]);
		}

		System.out.print(sumLessThen[a[0]]);

		for (int i = 1; i < n; i++) {
			System.out.print("," + sumLessThen[a[i]]);
		}

	}
}
