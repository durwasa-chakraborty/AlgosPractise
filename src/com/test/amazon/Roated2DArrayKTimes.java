package com.test.amazon;

import java.util.Scanner;

/**
 * Hi, Why don't you,
 * 
 * 1. Reverse the array. 2. Reverse first n-d items 3. Reverse last d items.
 *
 */
public class Roated2DArrayKTimes {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			String matrixPoints[] = reader.nextLine().split(" ");
			int m = Integer.parseInt(matrixPoints[0]);
			int n = Integer.parseInt(matrixPoints[1]);
			int rotationCount = Integer.parseInt(matrixPoints[2]);
			if (rotationCount >= n) {
				rotationCount = rotationCount % n;
			}
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");

			if (rotationCount != 0) {
				rotateArrayInGroupsOfNforKTimes(split, n, m, rotationCount);
			}
			printArray(split);

		}
	}

	private static void printLike2DArray(String[] split, int m, int n) {

		for (int i = 0; i < split.length; i++) {
			if (i % n == 0) {
				System.out.println();
			}
			System.out.print(split[i] + ((i + 1) < split.length && (Integer.parseInt(split[i + 1]) < 10) ? "  " : " "));
		}
	}

	private static void rotateArrayInGroupsOfNforKTimes(String[] split, int n, int m, int k) {
		for (int offset = 0; offset < m; offset++) {
			int start = offset * n;
			for (int i = 0; i < k; i++) {
				String firstElement = split[start];
				int index;
				for (index = 0; index < n - 1; index++) {
					split[start + index] = split[start + index + 1];
				}
				split[start + index] = firstElement;
			}
		}
	}

	private static void printArray(String[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ((i == arr.length - 1) ? "" : " "));
		}
	}
}
