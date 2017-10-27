package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/fill-array-by-1s/0
 */
public class FillArrayWith1s {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int length = scanner.nextInt();
			int arr[] = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j] = scanner.nextInt();
			}
			System.out.println(getIterationToFillArrayWith1s(arr, length));
		}
	}

	private static int getIterationToFillArrayWith1s(int[] arr, int length) {
		int maxIterations = -1;
		int start = -1, end = -1;
		for (int i = 0; i < length; i++) {

			// check for zero and mark start and end
			if (arr[i] == 0) {
				if (start == -1) {
					start = i;
					end = i;
				} else {
					end = i;
				}
			}
			// if 1 is found then do some calculations
			else if (arr[i] == 1 && start != -1 && end != -1) {
				int iteration = 0;

				// for start with 0
				if (start == 0) {
					iteration = end - start + 1;
				}
				// start in middle
				else {
					iteration = ((end - start) / 2) + 1;
				}
				// reset max iterations
				if (iteration > maxIterations) {
					maxIterations = iteration;
				}
				start = -1;
				end = -1;
			}

		}
		// case if zeros are upto end
		if (start != -1) {
			int iteration;
			// case for all zeros
			if (start == 0) {
				return -1;
			} else {
				iteration = end - start + 1;
			}
			if (iteration > maxIterations) {
				maxIterations = iteration;
			}
		}
		return maxIterations;
	}
}
