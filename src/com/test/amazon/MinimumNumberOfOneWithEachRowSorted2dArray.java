package com.test.amazon;

import java.util.Scanner;

public class MinimumNumberOfOneWithEachRowSorted2dArray {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			String matrixPoints[] = reader.nextLine().split(" ");
			int m = Integer.parseInt(matrixPoints[0]);
			int n = Integer.parseInt(matrixPoints[1]);

			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");

			System.out.println("" + getMinimumIndex(split, m, n));
		}

	}

	private static int getMinimumIndex(String[] split, int m, int n) {
		int count = 0;
		int minCount = Integer.MAX_VALUE;

		int indexMin = -1;
		int[] arr = new int[n];
		for (int i = 0; i < m; i++) {
			int start = i * n;
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(split[start + j]);
			}
			int index = binarySearchZeroOne(arr, 0, arr.length - 1);
			if (index != -1) {
				count = arr.length - index;
				if (count < minCount) {
					minCount = count;
					indexMin = i;
				}
			}

		}

		return indexMin;
	}

	private static int binarySearchZeroOne(int[] arr, int low, int high) {

		if (low > high) {
			return -1;
		}

		if (low == high) {
			return arr[low] == 1 ? low : -1;
		}

		int middle = (low + high) / 2;
		if (middle > low && arr[middle - 1] < arr[middle]) {
			return middle;
		}

		if (middle < high && arr[middle] < arr[middle + 1]) {
			return middle + 1;
		}

		if (arr[middle] == 1) {
			return binarySearchZeroOne(arr, low, middle - 1);
		}
		return binarySearchZeroOne(arr, middle + 1, high);
	}

}
