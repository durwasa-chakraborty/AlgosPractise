package com.test.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SmallestPositiveNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int length = scanner.nextInt();
			int[] arr = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j] = scanner.nextInt();
			}
			usingOnWithConstantExtraSpace(arr, length);
		}
	}

	private static void usingOnWithConstantExtraSpace(int[] arr, int length) {
		int indexP = segregateNegativeAndPositive(arr, length);
		int[] arrP = Arrays.copyOfRange(arr, indexP, length);
		int lengthP = arrP.length;
		for (int i = 0; i < lengthP; i++) {
			if (Math.abs(arrP[i]) - 1 < lengthP && arrP[Math.abs(arrP[i]) - 1] > 0) {
				arrP[Math.abs(arrP[i]) - 1] = -arrP[Math.abs(arrP[i]) - 1];
			}
		}

		int printElement = -1;
		for (int i = 0; i < lengthP; i++) {
			if (arrP[i] > 0) {
				printElement = i;
				break;
			}
		}
		System.out.println(printElement == -1 ? lengthP + 1 : printElement + 1);
	}

	private static int segregateNegativeAndPositive(int[] arr, int length) {
		int start = 0;
		int end = length - 1;
		while (start < end) {
			if (arr[start] <= 0) {
				start++;
			}

			if (arr[end] > 0) {
				end--;
			}

			if (arr[start] > 0 && arr[end] <= 0) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return arr[start] <= 0 ? start + 1 : start;
	}

	private static int segregateNegativeAndPositiveGFG(int[] arr, int length) {
		int j = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] <= 0) {
				swap(arr, i, j++);
			}
		}
		return j;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	private static void usingHashing(int[] arr, int length) {
		int min = 1;
		Set<Integer> set = new HashSet<>();
		for (int j = 0; j < length; j++) {
			set.add(arr[j]);
			if (min == arr[j]) {
				while (set.contains(min)) {
					min++;
				}
			}

		}
		System.out.println(min);
	}

}
