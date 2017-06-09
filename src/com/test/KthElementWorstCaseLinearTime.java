package com.test;
/* package whatever; // don't place package name! */

import java.util.Arrays;

/* Name of the class has to be "Main" only if the class is public. */
class KthElementWorstCaseLinearTime {
	public static void main(String[] args) throws java.lang.Exception {
		int[] arr = new int[] { 7, 15, 4, 3, 20, 10 };
		printArray(arr);
		System.out.println("TestSort.main() kth smallest quick select "
				+ getKthSmallestQuickSelectWorstCaseLinearTime(arr, 0, arr.length - 1, 4));
	}

	private static int getKthSmallestQuickSelectWorstCaseLinearTime(int arr[], int low, int high, int k) {

		if (k > 0 && k <= high - low + 1) {
			// number of elements in array
			int n = high - low + 1;

			int i, median[] = new int[(n + 4) / 5];

			for (i = 0; i < median.length - 1; i++) {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
			}

			if (n % 5 == 0) {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
				i++;
			} else {
				median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + (n % 5)), n % 5);
				i++;
			}

			int medOfMed = i == 1 ? median[i - 1]
					: getKthSmallestQuickSelectWorstCaseLinearTime(median, 0, i - 1, i / 2);

			int partition = partitionPractise(arr, low, high, medOfMed);

			if (partition - low == k - 1) {
				return arr[partition];
			}

			if (partition - low > k - 1) {
				return getKthSmallestQuickSelectWorstCaseLinearTime(arr, low, partition - 1, k);
			}

			return getKthSmallestQuickSelectWorstCaseLinearTime(arr, partition + 1, high, k - (partition + 1) + low);
		}

		return -1;
	}

	/**
	 * this is only for odd size array size
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int getMedian(int arr[], int n) {
		mergeSort(arr, 0, arr.length - 1);
		return arr[n / 2];
	}

	private static void merge(int[] arr, int low, int middle, int high) {

		int[] L = new int[middle - low + 1];
		int[] R = new int[high - middle];

		int n1 = L.length;
		int n2 = R.length;
		for (int i = 0; i < n1; i++) {
			L[i] = arr[i + low];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = arr[i + middle + 1];
		}

		int iL = 0, iR = 0;

		int origStart = low;
		while (iL < n1 && iR < n2) {
			if (L[iL] < R[iR]) {
				arr[origStart] = L[iL];
				iL++;
			} else {
				arr[origStart] = R[iR];
				iR++;
			}
			origStart++;
		}

		while (iL < n1) {
			arr[origStart] = L[iL];
			origStart++;
			iL++;
		}

		while (iR < n2) {
			arr[origStart] = R[iR];
			origStart++;
			iR++;
		}
	}

	private static void mergeSort(int arr[], int low, int high) {
		if (high <= low) {
			return;
		}
		int middle = (low + high) / 2;
		mergeSort(arr, low, middle);
		mergeSort(arr, middle + 1, high);
		merge(arr, low, middle, high);
	}

	private static void swap(int[] arr, int i, int index) {
		if (arr[i] == arr[index]) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	private static void printArray(int[] arr) {
		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int partitionPractise(int[] arr, int low, int high, int pivot) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == pivot) {
				swap(arr, i, high);
				break;
			}
		}
		int index = low - 1;
		int i = low;
		while (i < high) {
			if (arr[i] < pivot) {
				index++;
				swap(arr, i, index);
			}
			i++;
		}
		index++;
		swap(arr, index, high);
		return index;
	}

}