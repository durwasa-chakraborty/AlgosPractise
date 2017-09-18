package com.test.amazon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/sum-of-lengths-of-non-overlapping-subarrays/0
 */
public class SumOfLengthsOfNonOverlappingSubarrays {
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
			int maxValue = reader.nextInt();
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			System.out.println(getSumOfLengthofNonOverlappingSubArray(arr, n, maxValue) + "");
		}

	}

	private static int getSumOfLengthofNonOverlappingSubArray(int[] arr, int n, int maxValue) {
		int sum = 0;
		int count = 0;
		boolean isMaxElement = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxValue && count > 0) {
				if (isMaxElement) {
					sum += count;
				}
				isMaxElement = false;
				count = 0;
			} else if (arr[i] < maxValue) {
				count += 1;
			} else if (arr[i] == maxValue) {
				isMaxElement = true;
				count += 1;
			}
		}
		if (count > 0 && isMaxElement) {
			sum += count;
		}
		return sum;
	}
}
