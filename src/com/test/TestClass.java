package com.test;

import java.util.Comparator;
import java.util.TreeSet;

public class TestClass {
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
		TreeSet<String> hashSet = new TreeSet<>(comp);
		hashSet.add("1 12 2 5 $");
		hashSet.add("1 12 2 5 $");
		hashSet.add("1 6 5 4 $");
		System.out.println("hash set size : " + hashSet.size());
	}
}
