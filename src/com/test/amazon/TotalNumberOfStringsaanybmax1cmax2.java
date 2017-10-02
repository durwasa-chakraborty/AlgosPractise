package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/total-number-of-strings/0
 */
public class TotalNumberOfStringsaanybmax1cmax2 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		for (int i = 1; i <= numberOfTestCases; i++) {
			int n = reader.nextInt();
			System.out.println(getArrangements(n) + "");
		}
	}

	/**
	 * a can be any b max 1 c max2
	 * 
	 * @param n
	 * @return
	 */

	private static int getArrangements(int n) {
		//here apply formula for permutations for objects of different kinds 
		// permutation= (n!/a!*b!*c!) 
		// where a b c counts of different kinds and n is total number 
		
		return (n * (n - 1) * (n - 2) / 2) // a=n-b-c, b=1 c=2
				+ (n * (n - 1) / 2) //  a=n-b-c, b=0 c=2
				+ (n * (n - 1)) // a=n-b-c, b=1 c=1
				+  n //a=n-b-c, b=0 c=1
				+  n //a=n-b-c, b=1 c=0
				+ 1; //a=n-b-c, b=0 c=0
	}

	private static int factorial(int n, int a) {
		if (n <= 1) {
			return a;
		}

		return factorial(n - 1, n * a);
	}
}
