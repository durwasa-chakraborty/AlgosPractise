package com.test.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EvenAndOddElementsAtEvenAndOddPositions {

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

			evenAndOddPositionUsingO1Space(arr, n);
			// evenAndOddPositions(arr, n);

			printArray(arr);
		}
	}

	private static void evenAndOddPositions(int[] arr, int n) {
		Queue<Integer> evenQueue = new LinkedList<>();
		Queue<Integer> oddQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 0) {
				evenQueue.add(arr[i]);
			} else {
				oddQueue.add(arr[i]);
			}
		}

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (!evenQueue.isEmpty()) {
					arr[i] = evenQueue.poll();
				} else {
					arr[i] = oddQueue.poll();
				}
			} else {
				if (!oddQueue.isEmpty()) {
					arr[i] = oddQueue.poll();
				} else {
					arr[i] = evenQueue.poll();
				}
			}
		}
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void evenAndOddPositionUsingO1Space(int[] arr, int n) {
		int even = 0;
		int odd = 1;
		while (even < n && odd < n) {
			while (even < n && arr[even] % 2 == 0) {
				even += 2;
			}

			while (odd < n && arr[odd] % 2 != 0) {
				odd += 2;
			}

			if (even < n && odd < n) {
				swap(arr, even, odd);
				even += 2;
				odd += 2;
			}
		}

	}

	private static void swap(int[] arr, int i, int index) {
		if (arr[i] == arr[index]) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
	
//	Input:
//		87
//		78 16 94 36 50 22 28 60 64 12 68 30 24 68 36 30 70 68 94 12 30 74 22 20 38 16 14 92 74 82 6 26 28 6 30 14 58 96 46 68 44 88 4 52 55 33 61 77 69 13 27 87 95 71 35 79 3 93 53 57 81 87 45 41 57 87 7 25 29 33 71 69 9 41 97 19 47 89 65 29 51 1 35 65 25 15 57 
//
//		Its Correct output is:
//		78 55 16 33 94 61 36 77 50 69 22 13 28 27 60 87 64 95 12 71 68 35 30 79 24 3 68 93 36 53 30 57 70 81 68 87 94 45 12 41 30 57 74 87 22 7 20 25 38 29 16 33 14 71 92 69 74 9 82 41 6 97 26 19 28 47 6 89 30 65 14 29 58 51 96 1 46 35 68 65 44 25 88 15 4 57 52
//
//		And Your Code's Output is:
//		78 55 94 61 50 69 28 27 64 95 68 35 24 3 36 53 70 81 94 45 30 57 22 7 38 29 14 71 74 9 6 97 28 47 30 65 58 51 46 35 44 25 4 57 16 33 36 77 22 13 60 87 12 71 30 79 68 93 30 57 68 87 12 41 74 87 20 25 16 33 92 69 82 41 26 19 6 89 14 29 96 1 68 65 88 15 52

}
