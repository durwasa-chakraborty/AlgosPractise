package com.test;

public class RotationOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		printArray(arr);
		// rotateByd(arr, arr.length, 2);
		leftRotateJugglingAlgoPractise(arr, 10, arr.length);
		printArray(arr);
	}

	public static void rotateByd(int[] arr, int n, int d) {

		if (d >= n) {
			d = d % n;
		}
		int temp;
		for (int i = 1; i <= d; i++) {
			temp = arr[0];
			for (int j = 1; j < n; j++) {
				arr[j - 1] = arr[j];
			}
			arr[n - 1] = temp;
		}

	}

	/* Fuction to get gcd of a and b */
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void leftRotateJugglingAlgo(int arr[], int d, int n) {
		if (d >= n) {
			d = d % n;
		}
		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	public static void leftRotateJugglingAlgoPractise(int[] arr, int d, int n) {
		if (d >= n) {
			d = d % n;
		}

		int gcd = gcd(n, d);
		int j, k, temp;
		for (int gcd_i = 0; gcd_i < gcd; gcd_i++) {
			temp = arr[gcd_i];
			k = gcd_i;
			while (true) {
				j = k + d;
				if (j >= n) {
					j = j - n;
				}

				if (j == gcd_i) {
					break;
				}

				arr[k] = arr[j];
				k = j;
			}
			arr[k] = temp;

		}

	}

	public static void printArray(int[] arr) {
		System.out.println();
		System.out.println("Array Print : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
