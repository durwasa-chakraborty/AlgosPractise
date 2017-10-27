package com.test.amazon;

import java.util.Scanner;

public class MaximumSumRectangle2dArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int left = 0, top = 0, right = 0, bottom = 0, maxSum = Integer.MIN_VALUE;
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int[][] arr = new int[row][col];
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < col; j2++) {
					arr[j][j2] = scanner.nextInt();
				}
			}

			for (int leftCol = 0; leftCol < col; leftCol++) {
				int[] temp = new int[row];
				for (int rightCol = leftCol; rightCol < col; rightCol++) {
					for (int k = 0; k < row; k++) {
						temp[k] += arr[k][rightCol];
					}

					int[] sum = getLargestSumSubArray(temp, row);
					if (sum[0] > maxSum) {
						maxSum = sum[0];
						left = leftCol;
						right = rightCol;
						top = sum[1];
						bottom = sum[2];
					}
				}
			}

			System.out.println(maxSum);
			System.out.println("left : " + left + " top : " + top + " right : " + right + " bottom : " + bottom);

		}
	}

	private static int[] getLargestSumSubArray(int[] arr, int n) {
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

		return new int[] { maxSoFar, start, end };
	}

}
