package com.test.amazon;

import java.util.Scanner;

public class ChocolateStation {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			reader.nextLine();
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			int arr[] = new int[n + 1];

			for (int j = 0; j < n; j++) {
				arr[j + 1] = Integer.parseInt(split[j]);
			}

			int costOfChocolate = reader.nextInt();

			System.out.println("" + costToReachLastStation(arr, n + 1, costOfChocolate));

		}
	}

	private static int costToReachLastStation(int[] arr, int i, int costOfChocolate) {
		int costIncurred = 0;
		int chocolateCount = 0;
		for (int j = 0; j < i - 1; j++) {
			int value = arr[j] - arr[j + 1];
			if (value < 0) {
				int absValue = Math.abs(value);
				if (chocolateCount > absValue) {
					chocolateCount -= absValue;
				} else {
					costIncurred += absValue - chocolateCount;
					chocolateCount = 0;
				}
			} else {
				chocolateCount += value;
			}
		}
		return costIncurred * costOfChocolate;
	}
}
