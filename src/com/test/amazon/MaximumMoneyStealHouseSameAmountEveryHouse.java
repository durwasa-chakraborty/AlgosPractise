package com.test.amazon;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/maximum-money/0
 *
 */
public class MaximumMoneyStealHouseSameAmountEveryHouse {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int houses = scanner.nextInt();
			int money = scanner.nextInt();
			if (houses == 1) {
				System.out.println(money);
				return;
			}
			System.out.println(houses % 2 == 0 ? (houses / 2) * money : ((houses / 2) + 1) * money);
		}

	}
}
