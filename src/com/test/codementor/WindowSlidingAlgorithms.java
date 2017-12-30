package com.test.codementor;

public class WindowSlidingAlgorithms {

	public static void main(String[] args) {
		// int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		// int k = 4;
		// System.out.println("Max sum of consecutive : " +
		// getMaxSumOfConsecutiveKElements(arr, k));

		int arr[] = { 2, 5, 7, 1, 9, 3, 9 };
		int m = 4;
		System.out.println(" Mean subaray : " + getMeansOfSubarrayofKLengthMeans(arr, m));
	}

	private static void getDistanceOfClosestZeroFromEveryElement(int[] arr, int length) {
		int previous = -1, after = -1;
		int[] distance = new int[length];
		for (int i = 0; i < length; i++) {

		}
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
	 * https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
	 * 
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	private static int getNumberOfSubarraysWithMaxValueInGivenRange(int[] arr, int L, int R) {
		int beg = 0, end = 0;
		

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
