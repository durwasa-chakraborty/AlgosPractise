package com.test.amazon;

import java.util.Scanner;

public class CheckSetBits {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			System.out.println("" + isAllBitsSet(n));
		}
	}

	private static String isAllBitsSet(int n) {

		// One more concept when all bits set then if we add 1 into that then
		// unset bit become set and all set bit becomes unset so & of both
		// produce zero

		if (n == 0) {
			return "NO";
		}

		if ((n & (n + 1)) == 0) {
			return "YES";
		}
		return "NO";
	}

	private static String isAllBitsSetShifting(int n) {
		if (n == 0) {
			return "NO";
		}

		while (n != 0) {
			if ((n & 1) == 0) {
				return "NO";
			}
			n = n >> 1;
		}

		return "YES";
	}

	/**
	 * depends of isPowerOfTwo written concept there in that method also one
	 * more logic for power of two if only one bit set then also power of two
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isPowerOfTwo(int n) {
		return n != 0 && ((n & (n - 1)) == 0);
	}

}
