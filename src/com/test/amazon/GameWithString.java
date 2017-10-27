package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/game-with-string/0
 * 
 * @author Reema
 *
 */
public class GameWithString {
	static final int SIZE_MAP = 26;

	public static void main(String[] args) {
			char[] gameString = "abbccc".toCharArray();
			int k = 2;

			int length = gameString.length;

			int map[] = new int[SIZE_MAP];
			for (int j = 0; j < length; j++) {
				map[gameString[j] - 'a']++;
			}

			for (int j = SIZE_MAP / 2 - 1; j >= 0; j--) {
				maxHeap(map, SIZE_MAP, j);
			}

			for (int j = 0; j < k; j++) {
				decreaseKey(map, 0, SIZE_MAP);
			}

			int sum = 0;
			for (int j = 0; j < SIZE_MAP; j++) {
				if (map[j] != 0) {
					sum += Math.pow(map[j], 2);
				}
			}

			System.out.println(sum);
	}

	private static void decreaseKey(int[] map, int i, int size) {
		map[i]--;
		maxHeap(map, size, i);
	}

	private static void maxHeap(int[] map, int size, int j) {
		int left = 2 * j + 1;
		int right = 2 * j + 2;
		int greater = j;
		if (left < size && map[left] >= map[greater]) {
			greater = left;
		}

		if (right < size && map[right] >= map[greater]) {
			greater = right;
		}

		if (greater != j) {
			swap(map, j, greater);
			maxHeap(map, size, greater);
		}
	}

	private static void swap(int[] map, int i, int j) {
		int temp = map[i];
		map[i] = map[j];
		map[j] = temp;
	}
}
