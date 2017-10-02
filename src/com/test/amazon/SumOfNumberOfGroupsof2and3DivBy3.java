package com.test.amazon;

import java.util.Scanner;

public class SumOfNumberOfGroupsof2and3DivBy3 {

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

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			System.out.println(getCountOfNumberOf2or3GropupsDivBy3(arr, n) + "");
		}

	}

	private static int getCountOfNumberOf2or3GropupsDivBy3(int[] arr, int n) {

		int[] remArray = new int[3];
		for (int i = 0; i < arr.length; i++) {
			remArray[arr[i] % 3]++;
		}
		return getCount(remArray[0], remArray[1], remArray[2]);
	}

	private static int getCount(int r0, int r1, int r2) {
		return (r1 * r2) + (((r0 - 1) * r0) / 2) + // for group of 2
				(r0 * r1 * r2) + // having 0,1,2 remainder for group of 3
				(((r0 - 1) * r0 * (r0 - 2)) / 6) + // having same remainder 0
				(((r1 - 1) * r1 * (r1 - 2)) / 6) + // having same remainder 1
				(((r2 - 1) * r2 * (r2 - 2)) / 6);// having same remainder 2
	}
}
