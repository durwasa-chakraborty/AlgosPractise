package com.test.amazon;

import java.util.Scanner;

public class KadaneAlgorithmLargestSumContiguousSubarray1d {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			// getting first element
			int element = scanner.nextInt();
			int currMax = element;
			int maxSoFar = element;
			for (int j = 1; j < n; j++) {
				element = scanner.nextInt();
				currMax += element;
				if (currMax < element) {
					currMax = element;
				}

				if (maxSoFar < currMax) {
					maxSoFar = currMax;
				}
			}
			System.out.println("" + maxSoFar);
		}
	}

}
