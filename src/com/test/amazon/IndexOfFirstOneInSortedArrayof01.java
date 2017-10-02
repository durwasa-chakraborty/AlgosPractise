package com.test.amazon;

import java.util.Scanner;

public class IndexOfFirstOneInSortedArrayof01 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			reader.nextLine();
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			int arr[] = new int[n];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			System.out.println("" + indexOfFirstOne(arr, 0, n - 1));

		}
	}

	private static int indexOfFirstOne(int[] arr, int low, int high) {
		if (low == high) {
			return arr[low] == 1 ? low : -1;
		}

		if (low > high) {
			return -1;
		}

		int middle = (low + high) / 2;
		if (middle > low && arr[middle - 1] < arr[middle]) {
			return middle;
		}

		if (middle < high && arr[middle + 1] > arr[middle]) {
			return middle + 1;
		}

		if (arr[middle] == 0) {
			return indexOfFirstOne(arr, middle + 1, high);
		}
		return indexOfFirstOne(arr, low, middle - 1);
	}
}
