package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @author Reema
 *
 */
public class TestSort {

	public static void main(String[] args) {

		getKthLargestElementInStream();

		// int[] arr = new int[] { 7, 15, 4, 3, 20, 10 };
		// printArray(arr);
		// for (int i = arr.length / 2 - 1; i >= 0; i--) {
		// minHeapifyPractise(arr, arr.length - 1, i);
		// }
		// printArray(arr);

		// generateAllBinaryString(3);
		// generateBinaryStringWithoutConsecutiveOnes(3);

		// System.out.println("TestSort.main() subsequence Result stack " +
		// givenIsSubSequenceStack("AXY", "ADXCPY"));
		// System.out.println("TestSort.main() subsequence Result stack " +
		// givenIsSubSequenceStack("AXY", "YADXCP"));
		// System.out.println(
		// "TestSort.main() subsequence Result stack " +
		// givenIsSubSequenceStack("gksrek", "geeksforgeeks"));
		//
		// System.out.println(
		// "TestSort.main() subsequence Result recursive " +
		// givenIsSubSequenceRecursive("AXY", "ADXCPY"));
		// System.out.println(
		// "TestSort.main() subsequence Result recursive " +
		// givenIsSubSequenceRecursive("AXY", "YADXCP"));
		// System.out.println("TestSort.main() subsequence Result recursive "
		// + givenIsSubSequenceRecursive("gksrek", "geeksforgeeks"));

		// int[] arr = new int[] { 7, 15, 4, 3, 20, 10 };
		// printArray(arr);
		// System.out.println("TestSort.main() kth smallest quick select "
		// + getKthSmallestQuickSelectWorstCaseLinearTime(arr, 0, arr.length -
		// 1, 4));
		// heapSort(arr);
		// heapSortMinHeap(arr);
		// System.out.println("TestSort.main() kth smallest " +
		// getKthSmallestElement(arr, 3));
		// printArray(arr);
		// int[] arr = { 2, 1 };
		// System.out.println("TestSort.main() minimum element"
		// + findMinimumElementInSortedAndRotatedPractise(arr, 0, arr.length -
		// 1));

		// int arr1[] = { 1, 5, 9, 10, 15, 20 }, arr2[] = { 2, 3, 8, 13 };
		// printArray(arr1);
		// printArray(arr2);
		// System.out.println("");
		// mergeTwoSortedArraysWithNoExtraSpace(arr1, arr2);
		// printArray(arr1);
		// printArray(arr2);
		/* Initialize arrays */
		// int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		// int N[] = { 5, 7, 9, 25 };
		//
		// printArray(mPlusN);
		// printArray(N);
		// mPlusNSortedArray(mPlusN, N);
		// System.out.println("");
		// System.out.println("TestSort.main() after mplus n");
		// printArray(mPlusN);

		// int A[] = { 10, 50, 12, 14, 1, 2, 6, 7, 9, 50 };
		// int n = 16;
		// printLargestSumPair(A);
		// int arr[] = { 1, 2 };
		//
		// int sum = 22;

		// printArray(A);
		// pairOfSumSortedRotated(A, n);
		// pairOfSumUsingSorting(A, n);
		// int index = findIndexOfMinimumElementInSortedAndRotatedArray(arr, 0,
		// arr.length - 1);
		//
		// System.out.println("TestSort.main() minimum element" + arr[index]);

		// int index = findIndexOfElementInSortedAndRotatedArray(arr, 0,
		// arr.length - 1, 1);

		// System.out.println("TestSort.main() index of elment is " + index);

		// pairOfSumUsingSorting(A, n);

		// int arr[] = new int[] { 0, 0, 0, 1, 4, 0, 1, 10, 2, 0, 2, 0, 2, 1, 6,
		// 4, 0, 1 };
		// int arr[] = new int[] { 'p', 'a', 'b', 'x', 'w', 'p', 'p', 'v', 'p',
		// 'd', 'p', 'c', 'y', 'z' };

		// int arr[] = { 5, 2, 8, 10, 7, 6, 102 };

		// int[] arr = new int[] { 11, 3, 13, 21, 23, 10 };
		//
		// printArray(A);
		// System.out.println("");
		// printNextGreaterPractise(A);

		// insertionSortPractice(arr);

		// printArray(arr);
		// bubbleSort(arr);
		// insertionSort(arr);
		// selectionSort(arr);
		// mergeSort(arr, 0, arr.length - 1);

		// iterativeMergeSort(arr);
		// int inv = inversionCount(arr, 0, arr.length - 1);

		// System.out.println("TestSort.main() inversion count " + inv);

		// quickSort(arr, 0, arr.length - 1);
		// dutchNationalFlag(arr);
		// threewayBentleyQuickSort(arr, 0, arr.length - 1);
		// threeWayBentleyQuickSortMine(arr, 0, arr.length - 1);
		// threeWayQuickSort(arr, 0, arr.length - 1);
		// threewayPartitionBentley(arr, 0, arr.length - 1);
		// sort012(arr, arr.length);
		// System.out.println("TestSort.main() after quick sort");
		// printCharArray(arr);

		// System.out.println("TestSort.main() factorial " + fact(5, 1));

	}

	// after removing return print all pairs
	private static void pairOfSumUsingSorting(int[] a, int n) {
		mergeSort(a, 0, a.length - 1);

		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			int sum = a[right] + a[left];
			if (sum == n) {
				System.out.println("");
				System.out.println("TestSort.pairOfSumUsingSorting() " + a[right] + " " + a[left]);
				return;
			}

			if (sum > n) {
				right--;
			} else {
				left++;
			}
		}

	}

	private static void printCharArray(int[] arr) {

		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(((char) arr[i]) + " ");
		}

	}

	private static void printArray(int[] arr) {
		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void bubbleSort(int[] arr) {

		if (arr.length == 1 || arr.length == 0) {
			return;
		}

		boolean isOneMovementDone = true;

		while (isOneMovementDone) {
			isOneMovementDone = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isOneMovementDone = true;

				}
			}
		}
	}

	private static void insertionSort(int arr[]) {
		if (arr.length == 0 || arr.length == 1) {
			return;
		}
		int j;
		for (int i = 1; i < arr.length; i++) {
			j = i - 1;
			int item = arr[i];
			while (j >= 0 && item < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = item;
		}
	}

	private static void binaryInsertionSort(int arr[]) {
		if (arr.length == 0 || arr.length == 1) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int j = i - 1;
			int item = arr[i];
			int pos = binarySearch(arr, item, 0, j);

			while (j >= pos) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = item;
		}

	}

	private static int binarySearch(int[] arr, int item, int low, int high) {
		if (high <= low) {
			return (item > arr[low]) ? low + 1 : low;
		}
		int middle = (low + high) / 2;

		if (item == arr[middle]) {
			return middle + 1;
		}

		if (item < arr[middle]) {
			return binarySearch(arr, item, low, middle - 1);
		}
		return binarySearch(arr, item, middle + 1, high);
	}

	private static void selectionSort(int[] arr) {
		int index;
		for (int i = 0; i < arr.length - 1; i++) {
			index = i;
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			swap(arr, i, index);
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

	private static void iterativeMergeSort(int arr[]) {

		int currSize;
		int leftStart;
		int length = arr.length;
		for (currSize = 1; currSize < length; currSize = 2 * currSize) {

			for (leftStart = 0; leftStart < length; leftStart += 2 * currSize) {

				int middle = min(leftStart + currSize - 1, length - 1);
				int rightStart = min(leftStart + 2 * currSize - 1, length - 1);
				merge(arr, leftStart, middle, rightStart);
			}

		}
	}

	private static int min(int x, int y) {
		return (x < y) ? x : y;
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

	public static int inversionCount(int arr[], int low, int high) {
		int invCount = 0;
		if (high > low) {
			int middle = (low + high) / 2;
			invCount = inversionCount(arr, low, middle);
			invCount += inversionCount(arr, middle + 1, high);

			invCount += mergeInv(arr, low, middle, high);
		}

		return invCount;

	}

	private static int mergeInv(int[] arr, int low, int middle, int high) {
		int n1 = middle - low + 1;
		int n2 = high - middle;
		int invCount = 0;

		int L[] = new int[n1];
		int R[] = new int[n1];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[low + i];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = arr[middle + i + 1];
		}

		int i = 0, j = 0;

		int k = low;
		while (i < n1 && j < n2) {
			if (L[i] < R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
				invCount += (n1 - i);
			}
		}

		while (i < n1) {
			arr[k++] = L[i++];
		}
		while (j < n2) {
			arr[k++] = R[j++];
		}

		return invCount;

	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {

			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int index = low - 1;
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				index++;
				swap(arr, i, index);
			}
		}
		index++;
		swap(arr, index, high);
		return index;
	}

	public static void threeWayQuickSort(int[] arr, int low, int high) {

		if (low < high) {
			int partitionIndex[] = threewayPartitionDikjestra(arr, low, high);
			threeWayQuickSort(arr, low, partitionIndex[0] - 1);
			threeWayQuickSort(arr, partitionIndex[1] + 1, high);
		}
	}

	private static void threewayBentleyQuickSort(int arr[], int left, int right) {
		int i = left - 1, j = right, p = left - 1, q = right;
		if (right <= left)
			return;
		int pivot = arr[right];
		while (true) {
			while (arr[++i] < pivot)
				;

			while (pivot < arr[--j])
				if (j == left)
					break;

			if (i >= j)
				break;

			swap(arr, i, j);

			if (arr[i] == pivot) {
				p++;
				swap(arr, p, i);
			}

			if (pivot == arr[j]) {
				q--;
				swap(arr, j, q);
			}
		}
		swap(arr, i, right);
		j = i - 1;
		i = i + 1;
		for (int k = left; k < p; k++, j--)
			swap(arr, k, j);
		for (int k = right - 1; k > q; k--, i++)
			swap(arr, i, k);

		printCharArray(arr);

		threewayBentleyQuickSort(arr, left, j);
		threewayBentleyQuickSort(arr, i, right);
	}

	public static void threeWayBentleyQuickSortMine(int[] arr, int low, int high) {

		if (low < high) {
			int partitionIndex[] = threewayPartitionBentley(arr, low, high);
			threeWayBentleyQuickSortMine(arr, low, partitionIndex[0]);
			threeWayBentleyQuickSortMine(arr, partitionIndex[1], high);
		}
	}

	// dikjestra algorithm
	private static int[] threewayPartitionDikjestra(int[] arr, int low, int high) {
		int lt = low, gt = high, i = low;
		int pivot = arr[high];
		while (i <= gt) {
			if (arr[i] < pivot) {
				swap(arr, lt, i);
				i++;
				lt++;
			} else if (arr[i] > pivot) {
				swap(arr, gt, i);
				gt--;
			} else {
				i++;
			}
		}
		return new int[] { lt, gt };
	}

	private static int[] threewayPartitionBentley(int[] arr, int left, int right) {
		int i = left - 1, j = right;
		int p = left - 1, q = right + 1;

		int pivot = arr[right];

		while (true) {

			// from left find first element greater than pivot
			while (arr[++i] < pivot)
				;
			// from right find first element less than pivot
			while (pivot < arr[--j])
				if (j == left)
					break;

			// if i and j cross then done.
			if (i >= j)
				break;

			// swap so that smaller goes left and larger goes on right
			swap(arr, i, j);

			// if equals to pivot then move it to start of array and count using
			// p
			if (arr[i] == pivot) {
				p++;
				swap(arr, p, i);
			}

			// if equals to pivot then move it to end of array and count using w
			if (pivot == arr[j]) {
				q--;
				swap(arr, j, q);
			}
		}

		// Move pivot element to its correct position
		swap(arr, i, right);

		// put in adjacent to i
		j = i - 1;
		i = i + 1;

		for (int k = left; k < p; k++, j--)
			swap(arr, k, j);
		for (int k = right - 1; k > q; k--, i++)
			swap(arr, i, k);

		return new int[] { j, i };
	}

	public static void dutchNationalFlag(int[] arr) {
		int n = arr.length - 1;
		int low = 0, mid = 0, high = n;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;
			}
		}

	}

	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				swap(a, lo, mid);
				lo++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				swap(a, mid, hi);
				hi--;
				break;
			}
			}
		}
	}

	/**
	 * This is a tail recursive function for finding factorial to optimize for
	 * compiler
	 * 
	 * @param n
	 * @param a
	 * @return
	 */
	private static int fact(int n, int a) {
		if (n == 0) {
			return a;
		}

		return fact(n - 1, n * a);
	}

	private static void insertionSortPractice(int arr[]) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int index = i - 1;
			int item = arr[i];
			while (index >= 0 && arr[index] > item) {
				arr[index + 1] = arr[index];
				index--;
			}
			arr[index + 1] = item;
		}
	}

	private static void pairOfSumHashing(int arr[], int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			int diff = sum - arr[i];
			if (set.contains(diff)) {
				System.out.println("TestSort.pairOfSumHashing()" + arr[i] + " : " + diff);
				return;
			}
		}
	}

	// after removing return print all pairs
	private static void pairOfSumSortedRotated(int arr[], int sum) {
		int length = arr.length;
		int low = 0, high = length - 1;
		for (int i = 0; i < length - 1; i++) {
			if (arr[i + 1] < arr[i]) {
				low = i + 1;
				high = i;
				break;
			}
		}

		while (low != high) {
			int tempSum = arr[low] + arr[high];
			if (tempSum == sum) {
				System.out.println("TestSort.pairOfSumSortedRotated()" + arr[low] + " : " + arr[high]);
				return;
			}

			if (tempSum < sum) {
				low = (low + 1) % length;
			} else {
				high = (length + high - 1) % length;
			}
		}

	}

	// logn
	private static int findIndexOfMinimumElementInSortedAndRotatedArray(int arr[], int low, int high) {

		// only one element remained
		if (high == low) {
			return low;
		}
		// this means array is already sorted
		if (high < low) {
			return 0;
		}

		int middle = (low + high) / 2;

		if (middle > low && arr[middle - 1] > arr[middle]) {
			return middle;
		}

		if (middle < high && arr[middle + 1] < arr[middle]) {
			return middle + 1;
		}

		if (arr[middle] > arr[high]) {
			// right
			return findIndexOfMinimumElementInSortedAndRotatedArray(arr, middle + 1, high);
		} else {
			// left
			return findIndexOfMinimumElementInSortedAndRotatedArray(arr, low, middle - 1);
		}
	}

	// search using logn in sorted and rotated
	private static int findIndexOfElementInSortedAndRotatedArray(int[] arr, int low, int high, int item) {
		if (high == low) {
			return arr[low] == item ? low : -1;
		}

		if (high < low) {
			return -1;
		}

		int middle = (low + high) / 2;
		if (arr[middle] == item) {
			return middle;
		}

		// left portion is sorted
		if (arr[low] < arr[middle]) {
			if (item >= arr[low] && item < arr[middle]) {
				return findIndexOfElementInSortedAndRotatedArray(arr, low, middle - 1, item);
			}

			return findIndexOfElementInSortedAndRotatedArray(arr, middle + 1, high, item);

		}

		if (item <= arr[high] && item > arr[middle]) {
			return findIndexOfElementInSortedAndRotatedArray(arr, middle + 1, high, item);
		}

		return findIndexOfElementInSortedAndRotatedArray(arr, low, middle - 1, item);
	}

	private static void mPlusNSortedArray(int[] mPlusN, int N[]) {
		int j = moveToEnd(mPlusN);
		int i = 0;
		int lengthN = N.length;
		int lengthmPlusN = mPlusN.length;
		int indexArray = 0;
		while (i < lengthN && j < lengthmPlusN) {
			if (mPlusN[j] < N[i]) {
				swap(mPlusN, j, indexArray);
				j++;
			} else {
				mPlusN[indexArray] = N[i];
				i++;
			}
			indexArray++;
		}

		while (i < lengthN) {
			mPlusN[indexArray] = N[i];
			i++;
			indexArray++;
		}

	}

	private static int moveToEnd(int[] mPlusN) {
		int j = mPlusN.length - 1;
		for (int i = j; i >= 0; i--) {
			if (mPlusN[i] != -1) {
				swap(mPlusN, i, j);
				j--;
			}
		}
		return j + 1;
	}

	private static void swap(int[] arr, int i, int index) {
		if (arr[i] == arr[index]) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	private static void printLargestSumPair(int[] arr) {
		int first, second;
		if (arr[0] > arr[1]) {
			first = arr[0];
			second = arr[1];
		} else {
			first = arr[1];
			second = arr[0];
		}

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] > second) {
				second = arr[i];
			}

		}
		System.out.println("TestSort.printLargestSumPair() " + (first + second));
	}

	private static int[] nearestSmallestOnLeftSideInArray(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int nearestSmallest[] = new int[arr.length];

		stack.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {
			if (stack.peek() != null) {
				while (true) {
					if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
						break;
					}
					nearestSmallest[stack.pop()] = arr[i];
				}
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			nearestSmallest[stack.pop()] = -1;
		}

		return nearestSmallest;
	}

	private static void printNextGreaterPractise(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (stack.peek() != null) {

				while (true) {
					if (stack.isEmpty() || stack.peek() >= arr[i]) {
						break;
					}
					System.out.print("   " + stack.pop() + " -- " + arr[i]);
				}
			}
			stack.push(arr[i]);
		}

		while (!stack.isEmpty()) {
			System.out.print("   " + stack.pop() + " -1");
		}
	}

	private static void printNextGreater(int a[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(a[0]);

		for (int i = 1; i < a.length; i++) {
			if (s.peek() != null) {
				while (true) {
					if (s.isEmpty() || s.peek() > a[i]) {
						break;
					}
					System.out.println(s.pop() + ":" + a[i]);
				}
			}
			s.push(a[i]);
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + ":" + -1);
		}
	}

	private static void mergeTwoSortedArraysWithNoExtraSpace(int arr1[], int arr2[]) {
		if (arr1.length == 0 || arr2.length == 0) {
			return;
		}

		int length1 = arr1.length, length2 = arr2.length;
		if (arr1[length1 - 1] < arr2[0]) {
			System.out.println("TestSort.mergeTwoSortedArraysWithNoExtraSpace() Already sorted");
			return;
		}

		// iterate through arr2 from last
		for (int i = length2 - 1; i >= 0; i--) {
			int last = arr1[length1 - 1];
			// if last of arr1 greater than arr2 element then no need to do
			// changing
			if (arr2[i] > last) {
				continue;
			}
			int j = length1 - 2;
			while (j >= 0 && arr1[j] > arr2[i]) {
				arr1[j + 1] = arr1[j];
				j--;
			}

			arr1[j + 1] = arr2[i];
			arr2[i] = last;

		}
	}

	// A binary search based function to find the position
	// where item should be inserted in a[low..high]
	int binarySearchInsert(int a[], int item, int low, int high) {
		if (high <= low)
			return (item > a[low]) ? (low + 1) : low;

		int mid = (low + high) / 2;

		if (item == a[mid])
			return mid + 1;

		if (item > a[mid])
			return binarySearchInsert(a, item, mid + 1, high);
		return binarySearchInsert(a, item, low, mid - 1);
	}

	// Function to ind missing number
	static int getMissingNo(int a[], int n) {
		int i, total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total -= a[i];
		return total;
	}

	// Function to find missing number
	static int getMissingNoXor(int a[], int n) {
		int i;
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}

	private static int findMinimumElementInSortedAndRotatedPractise(int arr[], int low, int high) {

		// array is sorted not rotated
		if (high < low) {
			return arr[0];
		}

		if (high == low) {
			return arr[low];
		}

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1]) {
			return arr[mid + 1];
		}

		if (mid > low && arr[mid] < arr[mid - 1]) {
			return arr[mid];
		}

		// left array is sorted send right to search
		if (arr[mid] > arr[low]) {
			return findMinimumElementInSortedAndRotatedPractise(arr, mid + 1, high);
		}

		return findMinimumElementInSortedAndRotatedPractise(arr, low, mid - 1);
	}

	private static void heapSort(int[] arr) {

		int size = arr.length;
		// build heap upto size/2 means not taking leaf nodes for calculation.
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, size, i);
		}

		for (int i = size - 1; i >= 0; i--) {
			printArray(arr);
			printHeap(arr);
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
		}

	}

	public static void printHeap(int Heap[]) {
		System.out.println();
		int size = Heap.length;
		for (int i = 0; i < size / 2; i++) {

			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + ((2 * i + 1) < size ? Heap[2 * i + 1] : "null")
					+ " RIGHT CHILD :" + ((2 * i + 2) < size ? Heap[2 * i + 2] : null));

			System.out.println();
		}
	}

	private static void minHeapify(int[] arr, int size, int root) {

		int smallest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < size && arr[left] < arr[smallest]) {
			smallest = left;
		}

		if (right < size && arr[right] < arr[smallest]) {
			smallest = right;
		}

		if (smallest != root) {
			swap(arr, smallest, root);
			minHeapify(arr, size, smallest);
		}
	}

	private static void minHeapifyPractise(int[] arr, int size, int elementIndex) {

		int left = 2 * elementIndex + 1;
		int right = 2 * elementIndex + 2;

		int smallest = elementIndex;
		if (left < size && arr[smallest] > arr[left]) {
			smallest = left;
		}

		if (right < size && arr[smallest] > arr[right]) {
			smallest = right;
		}

		if (smallest != elementIndex) {
			swap(arr, smallest, elementIndex);
			minHeapifyPractise(arr, size, smallest);
		}

	}

	private static void heapSortMinHeap(int[] arr) {

		int size = arr.length;
		// build heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			minHeapify(arr, size, i);
		}

		for (int i = size - 1; i >= 0; i--) {
			printArray(arr);
			printHeap(arr);
			swap(arr, 0, i);
			minHeapify(arr, i, 0);
		}

	}

	private static int getKthLargestElement(int[] arr, int k) {

		int size = arr.length;
		// build heap upto size/2 means not taking leaf nodes for calculation.
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, size, i);
		}

		for (int i = size - 1; i >= 0; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, i, 0);
			if (i == (size - k - 1)) {
				return arr[i];
			}
		}

		return -1;

	}

	private static int getKthSmallestElement(int[] arr, int k) {
		int size = arr.length;
		if (k > size || k <= 0) {
			return -1;
		}
		// build heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			minHeapify(arr, size, i);
		}

		for (int i = size - 1; i >= size - (k - 1); i--) {
			swap(arr, 0, i);
			minHeapify(arr, i, 0);
		}
		return arr[0];
	}

	private static void maxHeapify(int[] arr, int size, int root) {
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != root) {

			swap(arr, root, largest);
			maxHeapify(arr, size, largest);
		}
	}

	private static int getKthSmallestUsingQuickSelect(int[] arr, int low, int high, int k) {
		if (k > 0 && k <= high - low + 1) {

			int partition = partitionPractise(arr, low, high);
			if (partition - low == k - 1) {
				return arr[partition];
			}

			if (partition - low > k - 1) {
				return getKthSmallestUsingQuickSelect(arr, low, partition - 1, k);
			}

			return getKthSmallestUsingQuickSelect(arr, partition + 1, high, k - (partition + 1) + low);
		}

		return -1;
	}

	private static int partitionPractise(int[] arr, int low, int high) {
		int pivot = arr[high];
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

	public static boolean givenIsSubSequenceStack(String subSequence, String origString) {
		System.out.println("subsequence : " + subSequence + "  origSTring " + origString);
		if (subSequence == null || origString == null || subSequence.length() > origString.length()) {
			return false;
		}

		// push element from last in stack such that first element at top
		Stack<Character> stack = new Stack<>();
		char[] charArray = subSequence.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			stack.push(charArray[i]);
		}

		// now pop elements from stack if present in order
		for (int i = 0; i < origString.length(); i++) {
			if (stack.isEmpty()) {
				return true;
			}
			if (stack.peek() == origString.charAt(i)) {
				stack.pop();
			}
		}

		return stack.isEmpty() ? true : false;
	}

	public static boolean givenIsSubSequenceRecursive(String subSequence, String origString) {
		if (subSequence.isEmpty()) {
			return true;
		}

		if (subSequence.length() > origString.length()) {
			return false;
		}

		if (subSequence.charAt(0) == origString.charAt(0)) {
			return givenIsSubSequenceRecursive(subSequence.substring(1), origString.substring(1));
		}
		return givenIsSubSequenceRecursive(subSequence, origString.substring(1));
	}

	public static void generateBinaryStringWithoutConsecutiveOnes(int k) {
		if (k <= 0) {
			return;
		}
		int[] arrA = new int[k];
		arrA[0] = 0;
		generateBinaryStringWithoutConsecutiveOnesUtil(k, arrA, 1);

		arrA[0] = 1;
		generateBinaryStringWithoutConsecutiveOnesUtil(k, arrA, 1);
	}

	public static void generateBinaryStringWithoutConsecutiveOnesUtil(int k, int[] arr, int n) {
		if (n == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		if (arr[n - 1] == 0) {
			arr[n] = 0;
			generateBinaryStringWithoutConsecutiveOnesUtil(k, arr, n + 1);
			arr[n] = 1;
			generateBinaryStringWithoutConsecutiveOnesUtil(k, arr, n + 1);
		}

		if (arr[n - 1] == 1) {
			arr[n] = 0;
			generateBinaryStringWithoutConsecutiveOnesUtil(k, arr, n + 1);
		}

		if (arr[n - 1] == 1) {

		}

	}

	public static void generateAllBinaryString(int k) {
		int[] arrA = new int[k];
		generateAllBinaryString(arrA, k);
	}

	private static void generateAllBinaryString(int[] arrA, int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arrA));
		} else {
			arrA[n - 1] = 0;
			generateAllBinaryString(arrA, n - 1);
			arrA[n - 1] = 1;
			generateAllBinaryString(arrA, n - 1);
		}
	}

	private static void getKthLargestElementInStream() {
		System.out.println("Enter value of k and enter k elements");
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int arr[] = new int[k];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter Elements upto k :");
			arr[i] = scan.nextInt();
		}

		printArray(arr);
		buildMinHeap(arr);
		printArray(arr);
		System.out.println("k th largest for Min Heap is root element " + arr[0]);

		while (true) {
			System.out.println("Enter next");
			int nextInt = scan.nextInt();
			if (nextInt > arr[0]) {
				arr[0] = nextInt;
				minHeapify(arr, k, 0);
			}
			printArray(arr);
			System.out.println("k th largest for Min Heap is root element " + arr[0]);
		}
	}

	private static void buildMinHeap(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapify(arr, n, i);
		}
	}
}
