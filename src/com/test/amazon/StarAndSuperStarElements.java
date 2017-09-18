package com.test.amazon;

import java.util.Scanner;
import java.util.Stack;

public class StarAndSuperStarElements {

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
			printStartAndSuperStarElements(arr, n);
		}

	}

	/**
	 * http://practice.geeksforgeeks.org/problems/start-elements/0
	 * 
	 * @param arr
	 */
	private static void printStartAndSuperStarElements(int[] arr, int n) {

		Stack<Integer> stackStar = new Stack<>();

		stackStar.push(arr[0]);
		for (int i = 1; i < n; i++) {
			while (!stackStar.isEmpty() && stackStar.peek() < arr[i]) {
				stackStar.pop();
			}
			stackStar.push(arr[i]);
		}

		StringBuilder starElement = new StringBuilder();
		String lastElement = -1 + "";
		String prevElement = -1 + "";
		while (!stackStar.isEmpty()) {
			prevElement = lastElement;
			lastElement = stackStar.pop() + "";
			if (!prevElement.equals(lastElement)) {
				starElement.insert(0, lastElement + " ");
			}
		}

		System.out.println(starElement.toString().isEmpty() ? ("" + -1) : starElement.toString());
		System.out.print((lastElement.equals(prevElement)) ? (-1 + "") : lastElement);

	}
}
