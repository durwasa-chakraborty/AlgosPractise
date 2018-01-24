package com.test.codementor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TODO
 * https://www.geeksforgeeks.org/construct-sum-array-sum-elements-given-range/
 * have to study later
 * 
 * @author Reema
 *
 */
public class WindowSlidingAlgorithms {

	public static void main(String[] args) {
		// int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		// int k = 4;
		// System.out.println("Max sum of consecutive : " +
		// getMaxSumOfConsecutiveKElements(arr, k));

		// int arr[] = { 2, 5, 7, 1, 9, 3, 9 };
		// int m = 4;
		// System.out.println(" Mean subaray : " +
		// getMeansOfSubarrayofKLengthMeans(arr, m));

		// int arr[] = { 3, 4, 1 };
		// int L = 2, R = 4;
		// System.out.println(
		// " Max Subarray with given range : " +
		// getNumberOfSubarraysWithMaxElementsInGivenRange(arr, L, R));

		// int arr[] = { 1, 2, 2, 3, 3 };
		// int arr[] = { 3, 3, 3, 4, 4, 2 };
		// int k = 4;
		// maximumUniqueElementForEverySubarrayOfSizeK(arr, k);

		// int arr[] = { 1, 2, 3, 4, 5 };
		// int arr[] = { 6, 5, 1, 2, 3, 2, 1, 4, 5 };
		// int k = 3;
		// printLongestSubarrayNotMoreThanKDistinctElments(arr, k);

		// int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5 };
		// int k = 3;
		// int[] arr = { 1, 2, 2, 3 };
		// int k = 2;
		// printSmallestSubarrayWithKDistintctNumbers(arr, k);

		// int[] arr = { 0, 1, 0, 3, 0, 0, 3, 2, 4 };
		// getDistanceFromClosestZeroToEveryElement(arr);

		// int arr[] = { 1, 2, 3, 4 };
		// int k = 10;

		// int arr[] = { 5, 3, 2 };
		// int k = 16;

		// int arr[] = { 1, 9, 2, 8, 6, 4, 3 };
		// int k = 100;
		// getNumberOfSubarraysHavingProductLessThanK(arr, k);

		// int arr[] = { 1, 2, 1, 0, 1, 1, 0 };
		// int k = 4;

		// int arr[] = { 5, 2, 1, 0, 5, 2, 0 };
		// int k = 4;
		// int arr[] = { 1, 2, -1, -2, 5, 1, 1, 0 };
		// int k = 4;
		// longestSubarrayHavingSumOfElementsAtmostK(arr, k);
		// Input String
		// Scanner scanner = new Scanner(System.in);
		// int inputLength = scanner.nextInt();
		// scanner.nextLine();
		// for (int i = 0; i < inputLength; i++) {
		// String str = scanner.nextLine();
		// printSmallestSubstringMaximumDistinctCharacters(str);
		// }
		// scanner.close();

		// String str = "12212";
		// int k = 3;
		// int b = 3;
		// convertAllSubstringsOfLengthKOfBasebtoDecimal(str, k, b);

		// int arr[] = { 1, 2, 3, 4, 5, 6 };
		// int k = 3;
		// printSumOfProductOfSubarraysOfSizeK(arr, k);
		// int arr[] = { 2, 1, 3, 2, 3 };
		// int arr[] = { 2, 4, 5, 2, 1 };
		// int arr[] = { 2, 4, 4, 2, 4 };
		// countSubarraysHavingTotalDistinctElementsSameAsOriginalArray(arr);

		// int arr[] = { -8, 2, 3, -6, 10 };
		// int k = 2;

		// int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		// int k = 3;
		// printFirstNegativeIntegerInEveryWindowOfSizeK(arr, k);

		// int arr[] = { -4, -2, 1, -3 };
		// int k = 2;

		// int arr[] = { 1, 1, 1, 1, 1, 1 };
		// int k = 2;
		// printLargestSumSubarrayWithAtleastKNumbers(arr, k);
		// String str = "aabcbcdbca";
		// String str = "aaab";
		// printSmallestWindowContainsAllDistinctCharacters(str);
		// int arr[] = { 100, 200, 300, 400 };
		// int k = 2;

		// int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		// int k = 4;

		// int arr[] = { 10, 2, 3, 4, 5 };
		// int k = 4;
		// printMaxSumOfSubarrayOfSizeK(arr, k);

		// int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
		// int k = 4;
		// printSumOfMaxAndMinElementOfWindowOfSizeK(arr, k);
		// printSumOfMaxAndMinElementOfWindowOfSizeKUsingDeque(arr, k);
		// int arr[] = { 10, 20, 30, 50, 10, 70, 30 };
		// printMaxOfMinOfEveryWindowSize(arr);
		// printMaxOfMinOfEveryWindowSizeUsingDp(arr);

		// String orig = "this is a test string";
		// String substring = "tist";
		String orig = "geeksforgeeks";
		String substring = "ork";
		printSmallestWindowInStringContainingAllCharactersOfAnotherString(orig, substring);
	}

	// Find the smallest window in a string containing all characters of another
	// string
	public static void printSmallestWindowInStringContainingAllCharactersOfAnotherString(String origString,
			String subString) {
		char[] origCharArray = origString.toCharArray();
		char[] subStringCharArray = subString.toCharArray();

		int[] origCharMap = new int[256];
		int[] subStringCharMap = new int[256];

		int length = origCharArray.length;

		int counterOrig = 0;
		int counterSubString = 0;
		for (int i = 0; i < subStringCharArray.length; i++) {
			if (subStringCharMap[subStringCharArray[i]] == 0) {
				counterSubString++;
			}
			subStringCharMap[subStringCharArray[i]]++;
		}

		int end = 0, beg = 0, d = Integer.MAX_VALUE;
		int resBeg = -1, resEnd = -1;
		while (end < length) {
			char ch;
			while (end < length && counterOrig != counterSubString) {
				ch = origCharArray[end];
				if (subStringCharMap[ch] > 0) {
					if (origCharMap[ch] == subStringCharMap[ch] - 1) {
						counterOrig++;
					}
					origCharMap[ch]++;
				}
				end++;
			}

			if (counterOrig != counterSubString) {
				break;
			}

			while (beg <= end && counterOrig == counterSubString) {
				if (d > (end - beg)) {
					d = end - beg;
					resBeg = beg;
					resEnd = end - 1;
				}
				ch = origCharArray[beg++];
				if (subStringCharMap[ch] > 0) {
					if (origCharMap[ch] == subStringCharMap[ch]) {
						counterOrig--;
					}
					origCharMap[ch]--;
				}
			}
			if (counterOrig == counterSubString && d > (end - beg)) {
				d = end - beg;
				resBeg = beg;
				resEnd = end - 1;
			}
		}
		System.out.println(" length : " + d + " index beg : " + resBeg + " index end : " + resEnd + " substring : "
				+ origString.substring(resBeg, resEnd + 1));
	}

	/**
	 * TODO read this while dp programs reading. Not cleared should be came
	 * while working on DP
	 * 
	 * @param arr
	 */
	public static void printMaxOfMinOfEveryWindowSizeUsingDp(int[] arr) {
		int n = arr.length;
		int dp[][] = new int[n + 1][n + 1];
		int ans[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			ans[i] = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp[i][i] = arr[i];
			ans[0] = max(ans[0], dp[i][i]);
		}

		for (int len = 1; len < n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len;
				dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]);
				ans[len] = max(ans[len], dp[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(" " + ans[i]);
		}
		System.out.println();

	}

	public static void printMaxOfMinOfEveryWindowSizeGFGON(int[] arr) {

	}

	public static void printMaxOfMinOfEveryWindowSize(int[] arr) {
		int length = arr.length;
		for (int k = 1; k <= length; k++) {
			int i;
			int max = Integer.MIN_VALUE;
			Deque<Integer> increasingOrderDequeue = new LinkedList<>();
			for (i = 0; i < k; i++) {
				while (!increasingOrderDequeue.isEmpty() && arr[i] <= arr[increasingOrderDequeue.getLast()]) {
					increasingOrderDequeue.removeLast();
				}
				increasingOrderDequeue.addLast(i);
			}

			max = max(arr[increasingOrderDequeue.getFirst()], max);

			for (; i < length; i++) {

				while (!increasingOrderDequeue.isEmpty() && increasingOrderDequeue.getFirst() <= (i - k)) {
					increasingOrderDequeue.removeFirst();
				}

				while (!increasingOrderDequeue.isEmpty() && arr[i] <= arr[increasingOrderDequeue.getLast()]) {
					increasingOrderDequeue.removeLast();
				}
				increasingOrderDequeue.addLast(i);
				max = max(arr[increasingOrderDequeue.getFirst()], max);
			}

			System.out.print(max + " ");
		}
	}

	public static void printSumOfMaxAndMinElementOfWindowOfSizeKUsingDeque(int[] arr, int k) {
		int beg = 0, end = 0, sum = 0;
		int length = arr.length;
		Deque<Integer> increasingOrderDeque = new LinkedList<>();
		Deque<Integer> decreasingOrderDeque = new LinkedList<>();
		for (end = 0; end < k; end++) {
			while (!increasingOrderDeque.isEmpty() && arr[increasingOrderDeque.getLast()] >= arr[end]) {
				increasingOrderDeque.removeLast();
			}

			while (!decreasingOrderDeque.isEmpty() && arr[decreasingOrderDeque.getLast()] <= arr[end]) {
				decreasingOrderDeque.removeLast();
			}

			increasingOrderDeque.addLast(end);
			decreasingOrderDeque.addLast(end);
		}
		sum += arr[increasingOrderDeque.getFirst()] + arr[decreasingOrderDeque.getFirst()];
		for (; end < length; end++) {

			while (!increasingOrderDeque.isEmpty() && increasingOrderDeque.getFirst() <= (end - k)) {
				increasingOrderDeque.removeFirst();
			}

			while (!decreasingOrderDeque.isEmpty() && decreasingOrderDeque.getFirst() <= (end - k)) {
				decreasingOrderDeque.removeFirst();
			}

			while (!increasingOrderDeque.isEmpty() && arr[increasingOrderDeque.getLast()] >= arr[end]) {
				increasingOrderDeque.removeLast();
			}

			while (!decreasingOrderDeque.isEmpty() && arr[decreasingOrderDeque.getLast()] <= arr[end]) {
				decreasingOrderDeque.removeLast();
			}

			increasingOrderDeque.addLast(end);
			decreasingOrderDeque.addLast(end);

			sum += arr[increasingOrderDeque.getFirst()] + arr[decreasingOrderDeque.getFirst()];
		}

		System.out.println(" sum of max and min of k window size using deque  : " + sum);
	}

	public static void printSumOfMaxAndMinElementOfWindowOfSizeK(int[] arr, int k) {
		int beg = 0, end = 0;
		TreeSet<Integer> treeSet = new TreeSet<>();
		int length = arr.length;
		for (end = 0; end < k; end++) {
			treeSet.add(arr[end]);
		}
		int sum = treeSet.iterator().next() + treeSet.descendingIterator().next();
		while (end < length) {
			treeSet.remove(arr[end - k]);
			treeSet.add(arr[end]);
			sum += treeSet.iterator().next() + treeSet.descendingIterator().next();
			end++;
		}

		System.out.println(" Sum of max and min element : " + sum);
	}

	public static void printMaxSumOfSubarrayOfSizeK(int[] arr, int k) {
		if (k > arr.length) {
			System.out.println("length of array less than k ");
			return;
		}
		int beg = 0, end = 0;
		int sum = 0, d = 0;

		for (end = 0; end < k; end++) {
			sum += arr[end];
		}

		int length = arr.length;

		d = sum;

		while (end < length) {
			sum += arr[end] - arr[end - k];
			d = max(sum, d);
			end++;
		}

		System.out.println(" Max sum of subarray of size k : " + d);
	}

	public static void printSmallestWindowContainsAllDistinctCharacters(String input) {
		char[] arr = input.toCharArray();
		int length = arr.length;
		int[] countMap = new int[256];
		String smallestString = null;
		int distinctCharacters = 0;
		for (int i = 0; i < length; i++) {
			if (countMap[arr[i]]++ == 0) {
				distinctCharacters++;
			}
		}

		int end = 0, beg = 0;
		int counter = 0, d = Integer.MAX_VALUE;
		countMap = new int[256];
		while (end < length) {

			if (countMap[arr[end++]]++ == 0) {
				counter++;
			}

			while (counter == distinctCharacters) {
				if (d > end - beg) {
					d = end - beg;
					smallestString = input.substring(beg, end);
				}
				if (countMap[arr[beg]]-- == 1) {
					counter--;
				}
				beg++;
			}

		}

		System.out.println(" Smallest string : " + smallestString);

	}

	public static void printLargestSumSubarrayWithAtleastKNumbers(int[] arr, int k) {

		int length = arr.length;
		int[] maxSumArray = new int[length];
		int max = arr[0];
		for (int i = 1; i < length; i++) {
			max = max(arr[i], max + arr[i]);
			maxSumArray[i] = max;
		}

		int end = 0;
		int sum = 0;
		while (end < k) {
			sum += arr[end++];
		}

		max = sum;
		while (end < length) {
			sum += arr[end] - arr[end - k];
			max = max(sum, max);
			max = max(max, sum + maxSumArray[end - k]);
			end++;
		}

		System.out.println(" Sum of max sum subarray of k size : " + max);

	}

	public static void printFirstNegativeIntegerInEveryWindowOfSizeK(int[] arr, int k) {
		Queue<Integer> queueNegativeIndexes = new LinkedList<>();
		int end = 0, beg = 0;
		int length = arr.length;
		while (end < k - 1) {
			if (arr[end] < 0) {
				queueNegativeIndexes.add(end);
			}
			end++;
		}

		while (end < length) {
			if (arr[end] < 0) {
				queueNegativeIndexes.add(end);
			}

			if (queueNegativeIndexes.isEmpty()) {
				System.out.print("0 ");
			} else {
				System.out.print(arr[queueNegativeIndexes.peek()] + " ");
			}

			if (arr[beg] < 0) {
				queueNegativeIndexes.remove(beg);
			}

			beg++;
			end++;
		}
	}

	public static void countSubarraysHavingTotalDistinctElementsSameAsOriginalArray(int[] arr) {
		int distinctElements = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int c : arr) {
			if (map.get(c) == null) {
				distinctElements++;
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		map.clear();
		int end = 0, beg = 0;
		int counter = 0, d = 0;
		int size = arr.length;
		System.out.println(" Distinct elements :" + distinctElements);

		while (end < size || counter == distinctElements) {
			if (counter == distinctElements) {
				if (map.get(arr[beg]) == 1) {
					counter--;
					map.remove(arr[beg]);
				} else {
					map.put(arr[beg], map.get(arr[beg]) - 1);
				}
				d += size - end + 1;
				beg++;
			} else if (end < size) {
				if (map.get(arr[end]) == null) {
					counter++;
					map.put(arr[end], 1);
				} else {
					map.put(arr[end], map.get(arr[end]) + 1);
				}
				end++;
			}

		}

		System.out.println(" Number of Subarrays : " + d);
	}

	public static void printSumOfProductOfSubarraysOfSizeK(int[] arr, int k) {
		int beg = 0, end = 0;
		int length = arr.length;
		int sum = 0, product = 1;
		for (end = 0; end < (k - 1); end++) {
			product *= arr[end];
		}
		while (end < length) {
			product *= arr[end++];
			sum += product;
			product /= arr[beg++];
		}
		System.out.println(" sum of product : " + sum);
	}

	public static void convertAllSubstringsOfLengthKOfBasebtoDecimal(String str, int k, int b) {
		int end = 0, beg = 0;
		int counter = k - 1;
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		int sum = 0;
		for (end = 0; end < k; end++) {
			sum += (Integer.parseInt(charArray[end] + "") * Math.pow(b, counter--));
		}
		System.out.print(sum + "   ");
		while (end < length) {
			// subtract first element from substring each time
			sum -= (Integer.parseInt(charArray[beg] + "") * Math.pow(b, k - 1));
			// add next element with base multiply by sum to shift one element
			sum = (int) ((sum * b) + (Integer.parseInt(charArray[end] + "") * Math.pow(b, 0)));
			System.out.print(sum + "   ");
			end++;
			beg++;
		}
	}

	public static void longestSubarrayHavingSumOfElementsAtmostK(int[] arr, int k) {
		int beg = 0, end = 0;
		int counter = 0, d = Integer.MIN_VALUE;
		int length = arr.length;
		int sum = 0;
		int resBeg = -1, resEnd = -1;
		while (end < length) {
			if (sum <= k) {
				sum += arr[end++];
			} else {
				sum -= arr[beg++];
			}

			if (sum <= k) {
				if (d < end - beg) {
					d = end - beg;
					resBeg = beg;
					resEnd = end - 1;
				}
			}
		}

		System.out.println("longest subarray length : " + d + " beg : " + resBeg + " end : " + resEnd);
	}

	private static int getNumberOfSubarraysHavingProductLessThanK(int[] arr, int k) {
		int beg = 0, end = 0;
		int mul = 1, counter = 0;
		int size = arr.length;

		while (end < size) {
			mul *= arr[end++];

			while (mul >= k && beg < end - 1) {
				mul /= arr[beg++];
			}

			if (mul < k) {
				counter += 1 + (end - beg - 1);
			}

		}
		System.out.println(" Number of subarrays having product less than K : " + k + " is : " + counter);
		return counter;
	}

	private static void printSmallestSubstringMaximumDistinctCharacters(String input) {
		char[] arr = input.toCharArray();
		int distinctChar = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : arr) {
			if (map.get(c) == null) {
				distinctChar++;
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		map.clear();
		int end = 0, beg = 0;
		int counter = 0, d = Integer.MAX_VALUE;
		int size = arr.length;
		while (end < size || counter >= distinctChar) {

			if (counter < distinctChar) {
				if (map.get(arr[end]) == null) {
					counter++;
					map.put(arr[end], 1);
				} else {
					map.put(arr[end], map.get(arr[end]) + 1);
				}
				end++;
			} else {
				if (counter == distinctChar) {
					d = min(d, end - beg);
				}
				if (map.get(arr[beg]) == 1) {
					map.remove(arr[beg]);
					counter--;
				} else {
					map.put(arr[beg], map.get(arr[beg]) - 1);
				}
				beg++;
			}

		}
		System.out.println(" smallest subarray length : " + d);
	}

	/**
	 * we can also do this by iterating first from left to right and then update
	 * distance while iterating from right to left
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] getDistanceFromClosestZeroToEveryElement(int[] arr) {
		int[] resArray = new int[arr.length];
		ArrayList<Integer> list = new ArrayList<>();
		int length = arr.length;

		// put all zeros for array in arraylist
		for (int i = 0; i < length; i++) {
			if (arr[i] == 0) {
				list.add(i);
			}
		}

		int d = 0, prevZeroIndex = -1;
		for (int i = 0; i < length; i++) {

			// update d here
			if (list.isEmpty()) {
				d = Math.abs(i - prevZeroIndex);
			} else {
				if (prevZeroIndex == -1) {
					d = Math.abs(i - list.get(0));
				} else {
					d = min(Math.abs(i - prevZeroIndex), Math.abs(i - list.get(0)));
				}
			}
			resArray[i] = d;

			// remove from list and store in prevZeroIndex to find minimum value
			// compared to first element of list
			if (!list.isEmpty() && list.get(0) <= i) {
				prevZeroIndex = list.get(0);
				list.remove(0);
			}
		}

		printSubArray(resArray, 0, length - 1);
		return resArray;
	}

	private static int min(int d, int i) {
		return d < i ? d : i;
	}

	public static void printSmallestSubarrayWithKDistintctNumbers(int[] arr, int k) {
		int beg = 0, end = 0;
		int size = arr.length;
		int d = -1, counter = 0;
		int resBeg = -1, resEnd = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		while (end < size) {

			// mark element visited
			if (map.get(arr[end]) == null) {
				counter++;
				map.put(arr[end], 1);
			} else {
				map.put(arr[end], map.get(arr[end]) + 1);
			}
			end++;

			// When the counter of distinct elements
			// increases from k, then reduce it to k and find smallest subarray
			while (beg < end && counter >= k) {

				// find minimum before removing item
				if (counter == k && (d == -1 || d > (end - beg - 1))) {
					resBeg = beg;
					resEnd = end - 1;
					d = (end - beg - 1);
				}

				if (map.get(arr[beg]) == 1) {
					map.remove(arr[beg]);
					counter--;
				} else {
					map.put(arr[beg], map.get(arr[beg]) - 1);
				}
				beg++;
			}

		}

		System.out.println(" Beg : " + resBeg + " End : " + resEnd);
		printSubArray(arr, resBeg, resEnd);

	}

	public static void printLongestSubarrayNotMoreThanKDistinctElments(int[] arr, int k) {
		int beg = 0, end = 0;
		int size = arr.length;
		int d = 0, counter = 0;
		int resBeg = -1, resEnd = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		while (end < size) {

			// mark element visited
			if (map.get(arr[end]) == null) {
				counter++;
				map.put(arr[end], 1);
			} else {
				map.put(arr[end], map.get(arr[end]) + 1);
			}
			end++;

			// When the counter of distinct elements
			// increases from k, then reduce it to k
			while (beg < size && counter > k) {
				if (map.get(arr[beg]) == 1) {
					map.remove(arr[beg]);
					counter--;
				} else {
					map.put(arr[beg], map.get(arr[beg]) - 1);
				}
				beg++;
			}

			// check length of longest subsegment
			if (d < (end - beg - 1)) {
				resBeg = beg;
				resEnd = end - 1;
				d = (end - beg - 1);
			}
		}

		System.out.println(" Beg : " + resBeg + " End : " + resEnd);
		printSubArray(arr, resBeg, resEnd);
	}

	/**
	 * https://www.geeksforgeeks.org/find-mean-subarray-means-given-array/
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	private static float getMeansOfSubarrayofKLengthMeans(int[] arr, int k) {
		int beg = 0, end = 0;
		int size = arr.length;

		int tempSum = 0;

		for (end = 0; end < k; end++) {
			tempSum += arr[end];
		}

		float meanSum = 0;
		meanSum += tempSum / (float) k;
		while (end < size) {
			tempSum = tempSum - arr[beg++] + arr[end++];
			meanSum += tempSum / (float) k;
		}

		return meanSum / (float) (size - k + 1);

	}

	/**
	 * https://www.geeksforgeeks.org/maximum-unique-element-every-subarray-size-k/
	 * 
	 * @param arr
	 * @param k
	 */
	public static void maximumUniqueElementForEverySubarrayOfSizeK(int[] arr, int k) {
		int size = arr.length;
		if (size < k) {
			System.out.println("Value of array less than K");
			return;
		}
		int beg = 0, end = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (end = 0; end < k - 1; end++) {
			if (map.get(arr[end]) == null) {
				map.put(arr[end], 1);
			} else {
				map.put(arr[end], map.get(arr[end]) + 1);
			}
		}
		boolean isPrinted = false;
		while (end < size) {
			if (map.get(arr[end]) == null) {
				map.put(arr[end], 1);
			} else {
				map.put(arr[end], map.get(arr[end]) + 1);
			}

			Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, Integer> next = iterator.next();
				if (next.getValue() == 1) {
					isPrinted = true;
					System.out.print(" " + next.getKey() + " ");
					break;
				}
			}

			if (!isPrinted) {
				System.out.print(" Nothing ");
			}

			if (map.get(arr[beg]) == 1) {
				map.remove(arr[beg]);
			} else {
				map.put(arr[beg], map.get(arr[beg]) - 1);
			}
			isPrinted = false;
			end++;
			beg++;
		}

	}

	/**
	 * https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
	 * confusing
	 * 
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	private static long getNumberOfSubarraysWithMaxElementsInGivenRange(int[] arr, int L, int R) {
		int incl = 0, excl = 0;
		int size = arr.length;
		long result = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] > R) {
				result += countSubArrays(incl) - countSubArrays(excl);
				incl = 0;
				excl = 0;
			}

			else if (arr[i] < L) {
				excl++;
				incl++;
			} else {
				result -= countSubArrays(excl);
				excl = 0;
				incl++;
			}
		}
		result += (countSubArrays(incl) - countSubArrays(excl));
		return result;
	}

	private static long countSubArrays(long n) {
		return n * (n + 1) / 2;
	}

	private static void printSubArray(int[] arr, int beg, int end) {
		if (beg == -1 || end == -1) {
			System.out.println("Empty subarray");
			return;
		}
		System.out.print("Sub arrays : ");
		while (beg <= end) {
			System.out.print(arr[beg++] + " ");
		}
		System.out.println();
	}

	public static int getMaxSumOfConsecutiveKElements(int[] arr, int k) {
		int beg = 0, end = 0;
		int d = 0, counter = 0, tempSum = 0;
		int size = arr.length;
		while (end < size) {

			if (counter != k) {
				tempSum += arr[end++];
				counter++;
			}

			if (counter == k) {
				d = max(d, tempSum);
				tempSum -= arr[beg++];
				counter--;
			}

		}
		return d;
	}

	/**
	 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
	 * 
	 * @param str
	 * @param k
	 * @return
	 */
	private static int getLongestKUniqueCharactersSubstring(String str, int k) {
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		int start = 0, end = 0, max = -1, counter = 0;
		int[] map = new int[26];

		while (end < length) {
			if (map[charArray[end++] - 'a']++ == 0) {
				counter++;
			}

			while (counter > k) {
				if (start < end && map[charArray[start++] - 'a']-- == 1) {
					counter--;
				}

			}
			if (counter == k) {
				max = max(max, end - start);
			}

		}

		return max == 0 ? -1 : max;
	}

	public int getLongestKUniqueCharactersSubstringPractise(String string, int k) {
		char[] charArray = string.toCharArray();
		int start = 0, end = 0, length = charArray.length, value = Integer.MIN_VALUE, count = 0;
		int[] map = new int[26];
		while (end < length) {
			if (map[charArray[end++] - 'a']++ == 0) {
				count++;
			}

			if (count == k) {
				if (value < end - start) {
					value = end - start;
				}
			}

			while (count > k) {
				if (--map[charArray[start++] - 'a'] == 0) {
					count--;
				}
			}
		}

		return value < 0 ? -1 : value;
	}

	private static int max(int d, int i) {
		return d > i ? d : i;
	}
}
