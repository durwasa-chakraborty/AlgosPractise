package com.test.amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElementsWithLeftSideSmallerRightSideGreater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int length = scanner.nextInt();
			int[] arr = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j] = scanner.nextInt();
			}

			usingArrayLeftMaxRightMain(arr, length);

		}
	}

	public static int usingArrayLeftMaxRightMain(int[] arr, int length) {
		int[] leftMax = new int[length];

		leftMax[0] = Integer.MIN_VALUE;

		for (int i = 1; i < length; i++) {
			leftMax[i] = max(leftMax[i - 1], arr[i - 1]);
		}

		int rightMin[] = new int[length];
		rightMin[length - 1] = Integer.MAX_VALUE;
		for (int i = length - 2; i >= 0; i--) {
			rightMin[i] = min(rightMin[i + 1], arr[i + 1]);
		}

		for (int i = 1; i < length - 1; i++) {
			if (leftMax[i] <= arr[i] && rightMin[i] >= arr[i]) {
				System.out.println(arr[i]);
				return arr[i];
			}
		}

		System.out.println(-1);
		return -1;
	}

	private static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	private static int min(int i, int j) {
		return (i < j) ? i : j;
	}

	public static void usingQueue(int[] arr, int length) {
		int item = arr[0];
		int max = item;
		Queue<Integer> queue = new LinkedList<>();
		for (int j = 1; j < length; j++) {
			item = arr[j];
			if (item >= max) {
				if (j != length - 1) {
					queue.add(item);
				}
				max = item;
			} else {
				while (!queue.isEmpty() && queue.peek() > item) {
					queue.poll();
				}
			}
		}

		if (queue.isEmpty()) {
			System.out.println("-1");
		} else {
			System.out.println("" + queue.poll());
		}
	}

}
