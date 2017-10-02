package com.test.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TopKNumbersInStream {

	private static class Data {
		public Data(int element, int count) {
			this.data = element;
			this.count = count;
		}

		int data;
		int count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		HashMap<Integer, Integer> mapInt = new HashMap<>();
		TreeSet<Data> treeSet = new TreeSet<>(new Comparator<Data>() {

			@Override
			public int compare(Data p, Data q) {

				if (p.data == q.data) {
					return 0;
				} else if (p.count == q.count)
					return p.data - q.data;
				else {
					return q.count - p.count;
				}
			}
		});
		for (int i = 0; i < testCases; i++) {
			mapInt.clear();
			treeSet.clear();
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			for (int j = 0; j < n; j++) {
				int element = scanner.nextInt();
				if (mapInt.get(element) == null) {
					mapInt.put(element, 1);
					treeSet.add(new Data(element, 1));
				} else {
					Data data = new Data(element, mapInt.get(element));
					boolean remove = treeSet.remove(data);
					data.count += 1;
					treeSet.add(data);
					mapInt.put(element, data.count);
				}

				Iterator<Data> iterator = treeSet.iterator();
				int tempCount = 0;
				while (iterator.hasNext() && tempCount < k) {
					System.out.print(iterator.next().data + " ");
					tempCount++;
				}
			}

			System.out.println();
		}

	}

}
