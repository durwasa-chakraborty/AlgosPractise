package com.test.amazon;

import java.util.Scanner;

public class HighestNumberInFirstIncreasingAndDecreasingArray {

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

			System.out.println("" + getHighestNumber(arr, 0, n - 1));

		}
	}

	private static int getHighestNumber(int[] arr, int low, int high) {
		if (low == high) {
			return arr[low];
		}

		if (low > high) {
			return arr[low] > arr[high] ? arr[low] : arr[high];
		}

		int middle = (low + high) / 2;
		if (middle < high && middle > low && arr[middle - 1] < arr[middle] && arr[middle + 1] < arr[middle]) {
			return arr[middle];
		}

		if (middle < high && arr[middle + 1] > arr[middle]) {
			return getHighestNumber(arr, middle + 1, high);
		}

		return getHighestNumber(arr, low, middle - 1);
	}

}
