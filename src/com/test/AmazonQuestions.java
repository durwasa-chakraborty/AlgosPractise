package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class AmazonQuestions {

	public static void main(String[] args) {

		// int arr[] = {0, 0, 1, 1, 0};
		// printArray(arr);
		// System.out.println();
		// largestSubArrayWithEqualNumberOfZeroandOne(arr);

		// System.out.println("Decimal to Roman : " + decimalToRoman(3549));

		// int[] arr = { 1, 5, 7, 2, 9, 14 };
		// System.out.println("Number of combinations : " +
		// numOfCombinationsDivisibleBy3(arr, arr.length));
		// waterJugProblemMinSteps(3, 5, 4);
		// System.out.println("Greatest common divisor : " +
		// greatestCommonDivisor(5, 7));

		// Nuts and bolts are represented as array of characters
		// char nuts[] = { '@', '#', '$', '%', '^', '&' };
		// char bolts[] = { '$', '%', '&', '^', '@', '#' };
		//
		// printArray(nuts);
		// printArray(bolts);
		// nutsAndBoltsProblem(nuts, bolts, 0, nuts.length - 1);
		// printArray(nuts);
		// printArray(bolts);

		// int[] arr = { 1, 3, 2, 5, 5, 6 };
		// twoMissingNumbers(arr);
		// findRepeatedAndMissing(arr);
		// printArray(arr);
		// quickSort(arr, 0, arr.length - 1);
		// mergeSort(arr, 0, arr.length - 1);
		// System.out.println();
		// printArray(arr);

	}

	private static void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void printArray(char[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void twoMissingNumbers(int[] arr) {

		int originalLength = arr.length + 2;
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}

		for (int i = 1; i <= originalLength; i++) {
			xor ^= i;
		}

		// rightmost set bit
		// xor = xor & (~(xor - 1));
		xor = (xor & -xor);

		int p = 0, q = 0;

		for (int i = 0; i < arr.length; i++) {

			// elements in which this last bit set
			if ((xor & arr[i]) == 0) {
				p ^= arr[i];
			} else {
				q ^= arr[i];
			}
		}

		for (int i = 1; i <= originalLength; i++) {
			if ((xor & i) == 0) {
				p ^= i;
			} else {
				q ^= i;
			}
		}

		System.out.println("Missing numbers are : " + p + "    " + q);
	}

	public static void findRepeatedAndMissing(int[] arr) {
		int xor = 0;
		for (int i = 1; i <= arr.length; i++) {
			xor ^= i;
		}

		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}

		// now xor variable contains xor of repeated and missing number

		// rightmost set bit
		xor = xor & -xor;

		int p = 0, q = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((xor & arr[i]) == 0) {
				p ^= arr[i];
			} else {
				q ^= arr[i];
			}
		}

		for (int i = 1; i <= arr.length; i++) {
			if ((xor & i) == 0) {
				p ^= i;
			} else {
				q ^= i;
			}
		}

		System.out.println("Missing and repeating numbers are : " + p + "    " + q);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partition = partition(arr, low, high);
			quickSort(arr, low, partition - 1);
			quickSort(arr, partition + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];

		int index = low;
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				swap(arr, index, i);
				index++;
			}
		}
		swap(arr, index, high);
		return index;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}
	}

	private static void merge(int[] arr, int low, int middle, int high) {
		int lArray[] = Arrays.copyOfRange(arr, low, middle + 1);
		int rArray[] = Arrays.copyOfRange(arr, middle + 1, high + 1);

		int indexL = 0;
		int indexR = 0;

		int index = low;
		while (indexL < lArray.length && indexR < rArray.length) {
			if (lArray[indexL] < rArray[indexR]) {
				arr[index++] = lArray[indexL];
				indexL++;
			} else {
				arr[index++] = rArray[indexR];
				indexR++;
			}
		}

		while (indexL < lArray.length) {
			arr[index++] = lArray[indexL];
			indexL++;
		}

		while (indexR < rArray.length) {
			arr[index++] = rArray[indexR];
			indexR++;
		}
	}

	public static void threeWayQuickSort(int[] arr, int low, int high) {

		// two methods are there bentley and other one we will discuss later
	}

	/**
	 * Main point is to compare one kind to another kind not from its king. So
	 * here nuts compared to bolts and bolts compared to nuts. this is basic
	 * concept
	 * 
	 * we can also do this with help of hashmap O(N)
	 * 
	 * Travese the nuts array and create a hashmap Traverse the bolts array and
	 * search for it in hashmap. If it is found in the hashmap of nuts than this
	 * means bolts exist for that nut.
	 * 
	 * similarly water jugs problem clrs book
	 * 
	 * 
	 * SOME IMPORTANT POINTS(Beware we cant match among themselves) every time
	 * what we will do is 1.will take most extreme bolt and partition nut array
	 * on the basis of that extreme bolt. 2 Now nuts got partition on the basis
	 * that extreme bolt. 3. Now on the basis of this pivot along which nuts got
	 * partitioned we partition bolt 4 So after this step what we can make sure
	 * that pivot of both nuts and bolts array are at right position i.e we got
	 * optimal matching of Pivot...... 5.Similarly via recursion we will see
	 * array pairs on both side of pivot. ## Other important thing give look the
	 * partition method is somewat different we are sending the pivot from
	 * sorting function only......so its helpful to implement us and give us
	 * idea how to implement randomised quicksort All u have to do do is if u
	 * find pivot element in the midway swapp it with the extreme element and
	 * yess that J-- important to visualise
	 * 
	 * @param nuts
	 * @param bolts
	 * @param low
	 * @param high
	 */
	private static void nutsAndBoltsProblem(char[] nuts, char bolts[], int low, int high) {
		if (low < high) {
			int partition = partitionNutsAndBolts(nuts, low, high, bolts[high]);
			partitionNutsAndBolts(bolts, low, high, nuts[partition]);
			nutsAndBoltsProblem(nuts, bolts, low, partition - 1);
			nutsAndBoltsProblem(nuts, bolts, partition + 1, high);
		}
	}

	/**
	 * this is also helpful in randomized quick sort because element goes from
	 * outside
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param pivot
	 * @return
	 */
	private static int partitionNutsAndBolts(char[] arr, int low, int high, char pivot) {
		int index = low;

		for (int i = low; i < high; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, index);
				index++;
			} else if (arr[i] == pivot) {
				swap(arr, i, high);
				i--;
			}
		}

		swap(arr, index, high);

		return index;
	}

	/**
	 * Amazing solution to find gcd found in jug water problem to find coprime
	 * because gcd for two numbers should be 1 those are called coprime
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int greatestCommonDivisor(int a, int b) {
		return b == 0 ? a : greatestCommonDivisor(b, a % b);
	}

	/**
	 * Apart from GCD logic, we use below logic also: if it is not possible to
	 * measure the D liters then there would come situation when one of the jug
	 * would be full and other would be empty after pouring from 1st to 2nd jug.
	 * This means that we have reached to back to initial state and can not
	 * measure D. At this instance, break the loop and return -1;
	 * 
	 * @param a
	 * @param b
	 * @param d
	 */
	private static void waterJugProblemMinSteps(int a, int b, int d) {
		if (a > b) {
			a = a + b;
			b = a - b;
			a = a - b;
		}

		if (d > b) {
			System.out.println("not possible because can't calculate water more than jugs");
			return;
		}

		if (d % greatestCommonDivisor(a, b) != 0) {
			System.out.println("Not possible for non coprime numbers");
			return;
		}

		System.out.println("Number of steps used : " + min(pourWater(a, b, d), pourWater(b, a, d)));
	}

	private static int pourWater(int fromCap, int toCap, int d) {
		int steps = 1;

		int from = fromCap, to = 0;

		while (from != d && to != d) {

			int temp = min(from, toCap - to);

			from -= temp;
			to += temp;
			steps++;

			if (from == d || to == d)
				break;

			if (from == 0) {
				from += fromCap;
				steps++;
			}

			if (to == toCap) {
				to = 0;
				steps++;
			}
		}

		System.out.println(" steps : " + steps);

		return steps;
	}

	private static int min(int from, int i) {
		return from < i ? from : i;
	}

	/**
	 * group of 2 or group of 3 divisible by 3 solved by remainder system.
	 * http://www.geeksforgeeks.org/number-groups-sizes-two-three-divisible-3/
	 * 
	 * @param arr
	 * @param N
	 * @return
	 */
	public static int numOfCombinationsDivisibleBy3(int arr[], int N) {
		// Initialize groups to 0
		int C[] = { 0, 0, 0 };

		// Increment group with specified remainder
		for (int i = 0; i < N; ++i)
			++C[arr[i] % 3];

		// Return groups using the formula
		return C[1] * C[2] + C[0] * (C[0] - 1) / 2 + C[0] * (C[0] - 1) * (C[0] - 2) / 6
				+ C[1] * (C[1] - 1) * (C[1] - 2) / 6 + C[2] * (C[2] - 1) * (C[2] - 2) / 6 + C[0] * C[1] * C[2];
	}

	public static String decimalToRoman(int number) {

		if (number > 3999) {
			System.out.println("this function is only for converting decimal to roman <=3999");
			return null;
		}
		String m[] = { "", "M", "MM", "MMM" };
		String c[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String x[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String i[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		int temp = number;
		String thousands = m[temp / 1000];
		temp = temp % 1000;
		String hundreds = c[temp / 100];
		temp = temp % 100;
		String tens = x[temp / 10];
		temp = temp % 10;
		String ones = i[temp];
		return thousands + hundreds + tens + ones;
	}

	public static void largestSubArrayWithEqualNumberOfZeroandOne(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int start = -1, end = -1, maxLen = 0, sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum += -1;
			}

			if (arr[i] == 1) {
				sum += 1;
			}

			if (sum == 0) {
				maxLen = i + 1;
				start = 0;
				end = i;
			}

			if (map.containsKey(sum)) {
				Integer sumIndex = map.get(sum);
				if (maxLen < i - sumIndex) {
					maxLen = i - sumIndex;
					start = sumIndex + 1;
					end = i;
				}
			} else {
				map.put(sum, i);
			}

		}

		System.out.println(" Largest subarray with equal number of zero and one : " + maxLen + " start : " + start
				+ " end : " + end);
	}

}
