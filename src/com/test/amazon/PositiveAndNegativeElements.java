package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/positive-and-negative-elements/0
 * 
 * @author Reema
 *
 */
public class PositiveAndNegativeElements {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			reader.nextLine();// to remove extra line character
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			// positiveAndNegativeValues(split, n);
			postiveAndNegativeElementsUsingQuickSortO1Space(split, n);
		}
	}

	private static void positiveAndNegativeValues(String[] split, int n) {
		int[] arr = new int[n];
		int pos = 0, neg = 1;
		int value;
		for (int j = 0; j < n; j++) {
			value = Integer.parseInt(split[j]);
			if (value < 0) {
				arr[neg] = value;
				neg += 2;
			} else {
				arr[pos] = value;
				pos += 2;

			}
		}
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
	 * Order is not maintained in this method
	 * 
	 * @param arr
	 * @param n
	 */
	private static void postiveAndNegativeElementsUsingQuickSortO1Space(String[] arr, int n) {
		int pivot = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(arr[i]) < pivot) {
				swap(arr, index, i);
				index++;
			}
		}

		int pos = index, neg = 0;
		while (pos < n && neg < n && Integer.parseInt(arr[neg]) < 0) {
			swap(arr, pos, neg);
			pos += 1;
			neg += 2;
		}

		// for (int i = 0; i < n; i += 2) {
		// int j;
		// String element = arr[index];
		// for (j = index - 1; j >= i; j--) {
		// arr[j + 1] = arr[j];
		// }
		// arr[j + 1] = element;
		// index++;
		// }

		printArray(arr);

	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
