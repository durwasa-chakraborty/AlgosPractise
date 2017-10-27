package com.test;

public class LargestSumContiguousSubarray1dArray {
	public static void main(String[] args) {
		// int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// int arr[] = { 11, -4, 16, 33, 8, -27, 28, 1 };
		// int arr[] = { 28, 28, 42, -30, 8, -53, 12, -5, -17, -35 };
		int arr[] = { 28, 27, 40, -30, 8, -53, 12, -5, -17, -35 };
		printLargestSumSubArray(arr, arr.length);

	}

	private static void printLargestSumSubArray(int[] arr, int n) {
		int start = 0, end = 0, maxSoFar = arr[0];
		int s = 0, currentMax = arr[0];

		for (int i = 1; i < n; i++) {
			currentMax += arr[i];
			// if we found arr[i] greater then we are sure that previous
			// additions not create some impact on totatl contiguous sum so we
			// directly put sum there
			if (currentMax < arr[i]) {
				currentMax = arr[i];
				s = i;
			}

			if (maxSoFar < currentMax) {
				start = s;
				end = i;
				maxSoFar = currentMax;
			}
		}

		System.out.println(" start : " + start + " end : " + end + " maxSum : " + maxSoFar);
	}

	private static void printLargestSumSubArray2(int[] arr, int n) {
		int currMax = arr[0], maxSoFar = arr[0];
		System.out.println("maxSoFar : " + maxSoFar + " currMax : " + currMax);
		for (int i = 1; i < n; i++) {
			System.out.println("arr[i] " + arr[i] + " arr[i] + currMax " + (arr[i] + currMax));
			currMax = max(arr[i], arr[i] + currMax);
			maxSoFar = max(currMax, maxSoFar);
			System.out.println("maxSoFar : " + maxSoFar + " currMax : " + currMax);
		}

		System.out.println(" max " + maxSoFar);

	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
