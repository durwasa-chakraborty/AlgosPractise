package com.test.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class CountTripletsWithSumGivenON2 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			String[] sizePlusSum = reader.nextLine().split(" ");
			int n = Integer.parseInt(sizePlusSum[0]);
			int givenSum = Integer.parseInt(sizePlusSum[1]);
			String nextLine = reader.nextLine();
			String[] split = nextLine.trim().split(" ");
			int arr[] = new int[n];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			System.out.println("" + countTripLetsWithSumSmallerThanGivenValue(arr, n, givenSum));
		}
	}

	private static int countTripLetsWithSumSmallerThanGivenValue(int[] arr, int n, int givenSum) {
		Arrays.sort(arr);
		int res = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (arr[i] + arr[j] + arr[k] < givenSum) {
					res += (k - j);
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}

}
