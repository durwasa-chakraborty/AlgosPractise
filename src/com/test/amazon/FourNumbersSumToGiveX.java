package com.test.amazon;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/four-elements/0
 * 
 * @author Reema
 *
 */
public class FourNumbersSumToGiveX {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}

			int X = scanner.nextInt();
			System.out.println(getFourNumbersSumUsingMap(arr, X, n));
			// System.out.println(getFourNumbersSum(arr, 0, X, 4) + " ");
		}
	}

	private static int getFourNumbersSumUsingMap(int[] arr, int x, int n) {

		HashMap<Integer, Point> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int rest = x - arr[i] - arr[j];
				if (map.containsKey(rest)) {
					return 1;
				}
			}
			for (int k = 0; k < i; k++) {
				map.put(arr[i] + arr[k], new Point(i, k));
			}
		}

		return 0;
	}

	private static class Pair {
		int x, y, sum;

		public Pair(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}

	private static void printFourNumberSum(int[] arr, int x, int n) {
		Pair aux[] = new Pair[(n * (n - 1)) / 2];
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				aux[count++] = new Pair(i, j, arr[i] + arr[j]);
			}
		}

		Arrays.sort(aux, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.sum - o2.sum;
			}
		});

		int l = 0, r = aux.length - 1;

		while (l <= r) {
			if ((aux[l].sum + aux[r].sum == x) && noCommon(aux[l], aux[r])) {

			}
		}

	}

	private static boolean noCommon(Pair pair, Pair pair2) {
		return pair.x == pair2.y || pair.x == pair2.x || pair.y == pair2.x || pair.y == pair2.y;
	}

	// private static int getFourNumbersSum(int[] arr, int i, int x, int
	// countRemained) {
	// if (countRemained == 0 && x == 0) {
	// return 1;
	// }
	// int itemRemained = arr.length - i;
	// if (countRemained == itemRemained) {
	// int sum = 0;
	// for (int j = i; j < arr.length; j++) {
	// sum += arr[j];
	// }
	// if (sum == x) {
	// return 1;
	// } else {
	// return 0;
	// }
	// }
	//
	// int included = 0;
	// int excluded = 0;
	// if (x - arr[i] >= 0) {
	// included = getFourNumbersSum(arr, i + 1, x - arr[i], countRemained - 1);
	// if (included == 1) {
	// return 1;
	// }
	// }
	// excluded = getFourNumbersSum(arr, i + 1, x, countRemained);
	// return excluded;
	// }
}
