package com.test.amazon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class FindAllFourSumNumbers {

	static Comparator<String> comp = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			String[] split1 = o1.split(" ");
			String[] split2 = o2.split(" ");
			for (int i = 0; i < 4; i++) {
				if (!split1[i].equals(split2[i])) {
					if (Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])) {
						return -1;
					} else {
						return 1;
					}
				}
			}
			return 0;
		}
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = scanner.nextInt();
			int X = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}

			getFourNumbersSum(arr, X, n);
			System.out.println();
		}
	}

	private static void getFourNumbersSum(int[] arr, int x, int n) {

		// TreeSet is used to remove duplicates and custom comparator 'comp' is
		// used so that print in increasing order always
		TreeSet<String> set = new TreeSet<>(comp);
		HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			// 'map' hastable holds all possible sums a[k] + a[l]
			// where k and l are both less than i
			for (int j = i + 1; j < n; j++) {
				int rest = x - arr[i] - arr[j];

				// Now we need to find if there're different numbers k and l
				// such that a[k] + a[l] == rest and k < i and l < i
				// but we have 'map' hashtable prepared for that
				if (map.containsKey(rest)) {
					int[] res = new int[4];
					ArrayList<Point> points = map.get(rest);
					for (int k = 0; k < points.size(); k++) {
						Point point = points.get(k);
						res[0] = arr[i];
						res[1] = arr[j];
						res[2] = arr[point.x];
						res[3] = arr[point.y];
						Arrays.sort(res);
						StringBuilder builder = new StringBuilder();
						for (int l = 0; l < 4; l++) {
							builder.append(res[l] + " ");
						}
						builder.append("$");
						set.add(builder.toString());
					}

				}
			}

			// now let's put in 'map' hashtable all possible sums
			// a[i] + a[k] where k < i
			for (int k = 0; k < i; k++) {
				int sum = arr[i] + arr[k];
				if (map.containsKey(sum)) {
					map.get(sum).add(new Point(i, k));
				} else {
					ArrayList<Point> point = new ArrayList<>();
					point.add(new Point(i, k));
					map.put(sum, point);
				}
			}
		}
		if (set.isEmpty()) {
			System.out.print(-1 + "");
			return;
		}
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}

	}

}
