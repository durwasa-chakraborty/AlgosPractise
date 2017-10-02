package com.test.amazon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {

	private static int FRESH_ORANGES = 1;
	private static int ROTTEN_ORANGES = 2;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		for (int i = 1; i <= numberOfTestCases; i++) {
			String rc[] = reader.nextLine().split(" ");
			int r = reader.nextInt();
			int c = reader.nextInt();

			Queue<Point> queue = new LinkedList<>();

			int arr[][] = new int[r][c];
			for (int i1 = 0; i1 < r; i1++) {
				for (int j = 0; j < c; j++) {
					arr[i1][j] = reader.nextInt();
					if (arr[i1][j] == ROTTEN_ORANGES) {
						queue.add(new Point(i1, j));
					}
				}
			}

			System.out.println("" + getRottenOrangeTimeTaken(arr, r, c, queue));

		}
	}

	private static int getRottenOrangeTimeTaken(int[][] arr, int r, int c, Queue<Point> queue) {

		int ans = 0;
		while (!queue.isEmpty()) {

			boolean flag = false;
			int count = queue.size();
			while (count > 0) {
				Point temp = queue.poll();

				// right
				if (isValid(temp.x + 1, temp.y, r, c) && arr[temp.x + 1][temp.y] == FRESH_ORANGES) {
					if (!flag) {
						ans++;
						flag = true;
					}

					arr[temp.x + 1][temp.y] = ROTTEN_ORANGES;
					queue.add(new Point(temp.x + 1, temp.y));

				}

				// left
				if (isValid(temp.x - 1, temp.y, r, c) && arr[temp.x - 1][temp.y] == FRESH_ORANGES) {
					if (!flag) {
						ans++;
						flag = true;
					}

					arr[temp.x - 1][temp.y] = ROTTEN_ORANGES;
					queue.add(new Point(temp.x - 1, temp.y));
				}

				// top
				if (isValid(temp.x, temp.y - 1, r, c) && arr[temp.x][temp.y - 1] == FRESH_ORANGES) {
					if (!flag) {
						ans++;
						flag = true;
					}

					arr[temp.x][temp.y - 1] = ROTTEN_ORANGES;
					queue.add(new Point(temp.x, temp.y - 1));
				}

				// bottom
				if (isValid(temp.x, temp.y + 1, r, c) && arr[temp.x][temp.y + 1] == FRESH_ORANGES) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y + 1] = ROTTEN_ORANGES;
					queue.add(new Point(temp.x, temp.y + 1));
				}
				count--;
			}
		}
		return checkAllRotten(arr, r, c) ? ans : -1;
	}

	private static boolean checkAllRotten(int[][] arr, int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == (FRESH_ORANGES)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	private static boolean isDelimiter(Point point) {
		return point.x == -1 && point.y == -1;
	}

}
