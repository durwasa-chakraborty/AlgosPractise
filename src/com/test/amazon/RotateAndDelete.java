package com.test.amazon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/rotate-and-delete/0
 */
public class RotateAndDelete {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}

			rotateAndDelete(arr, n);
		}
	}

	private static int[] rotateAndDelete(int[] arr, int n) {
		int length = n;
		int rotation = 0;
		while (length != 1) {
			rotateOneTimeClockwise(arr, length);
			rotation++;
			arr = deleteRElementFromLast(arr, rotation);
			length = arr.length;
		}
		return arr;
	}

	private static int[] deleteRElementFromLast(int[] arr, int rotation) {
		if (rotation > arr.length) {
			return Arrays.copyOf(arr, 1);
		}
		return null;
	}

	private static void rotateOneTimeClockwise(int[] arr, int n) {

	}

}
