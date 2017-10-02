package com.test.amazon;

import java.util.Scanner;

public class SticklerThiefNoConsecutiveHouses {

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

			System.out.println("" + getMaxSumLooted(arr, n));
		}
	}

	private static int getMaxSumLooted(int[] arr, int n) {

		int incl = arr[0];
		int excl = 0;
		int excl_new;

		for (int i = 1; i < n; i++) {
			excl_new = (incl > excl) ? incl : excl;
			incl = excl + arr[i];
			excl = excl_new;
		}
		return incl > excl ? incl : excl;
	}

	private static int getMaxAmountLooted(int[] arr, int n) {
		int amountLooted0 = getAmountLooted(arr, 0, n);
		int amountLooted1 = getAmountLooted(arr, 1, n);

		return amountLooted0 > amountLooted1 ? amountLooted0 : amountLooted1;
	}

	private static int getAmountLooted(int[] arr, int i, int n) {
		if (i >= n) {
			return 0;
		}
		int lootedNextIncluded = arr[i] + getAmountLooted(arr, i + 2, n);
		int lootedNextNextIncluded = arr[i] + getAmountLooted(arr, i + 3, n);

		return lootedNextIncluded > lootedNextNextIncluded ? lootedNextIncluded : lootedNextNextIncluded;
	}

}
