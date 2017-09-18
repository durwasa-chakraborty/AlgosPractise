package com.test.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * http://practice.geeksforgeeks.org/problems/similar-expressions/0
 * 
 * @author Reema
 *
 */
public class SimilarExpressions {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int numberOfTestCases = reader.nextInt();
		reader.nextLine();// to remove extra line character
		for (int i = 1; i <= numberOfTestCases; i++) {
			String expressionA = reader.nextLine();
			String expressionB = reader.nextLine();

			Stack<String> stackA = new Stack<>();
			Stack<String> stackB = new Stack<>();

			HashMap<String, Integer> mapA = new HashMap<>();
			HashMap<String, Integer> mapB = new HashMap<>();

			System.out.println(getIsSimilarExpressions(expressionA, expressionB, stackA, stackB, mapA, mapB));
		}

	}

	private static String getIsSimilarExpressions(String expA, String expB, Stack<String> stackA, Stack<String> stackB,
			HashMap<String, Integer> mapA, HashMap<String, Integer> mapB) {
		evaluateExpression(expA, stackA, mapA);
		evaluateExpression(expB, stackB, mapB);

		if (mapA.size() != mapB.size()) {
			return "NO";
		}

		Set<String> keySet = mapA.keySet();
		for (String string : keySet) {
			if (mapB.get(string) == null) {
				return "NO";
			} else if (mapB.get(string) != mapA.get(string)) {
				return "NO";
			}
		}

		return "YES";
	}

	private static void evaluateExpression(String expA, Stack<String> stackA, HashMap<String, Integer> mapA) {
		if (expA.isEmpty()) {
			return;
		}
		if (expA.startsWith("(") || expA.startsWith("+(")) {
			if (stackA.isEmpty() || !stackA.peek().contains("-")) {
				stackA.push("(");
			} else if (stackA.peek().contains("-")) {
				stackA.push("-(");
			}
			expA = expA.substring(expA.indexOf('(') + 1);
			evaluateExpression(expA, stackA, mapA);
			return;
		}

		if (expA.startsWith("-(")) {
			if (stackA.isEmpty() || !stackA.peek().contains("-")) {
				stackA.push("-(");
			} else if (stackA.peek().contains("-")) {
				stackA.push("(");
			}
			expA = expA.substring(2);
			evaluateExpression(expA, stackA, mapA);
			return;
		}

		if (expA.startsWith(")")) {
			stackA.pop();
			expA = expA.substring(1);
			evaluateExpression(expA, stackA, mapA);
			return;
		}

		if (expA.startsWith("-")) {
			String addedString;
			if (stackA.isEmpty()) {
				addedString = expA.substring(0, 2);
			} else if (stackA.peek().contains("-")) {
				addedString = "+" + expA.charAt(1);
			} else {
				addedString = expA.substring(0, 2);
			}

			checkForAddedString(addedString, mapA);

			expA = expA.substring(2);
			evaluateExpression(expA, stackA, mapA);
			return;
		}

		if (expA.startsWith("+")) {
			String addedString;
			if (stackA.isEmpty()) {
				addedString = expA.substring(0, 2);
			} else if (stackA.peek().contains("-")) {
				addedString = "-" + expA.charAt(1);
			} else {
				addedString = expA.substring(0, 2);
			}
			checkForAddedString(addedString, mapA);
			expA = expA.substring(2);
			evaluateExpression(expA, stackA, mapA);
		} else {
			String addedString;
			if (stackA.isEmpty()) {
				addedString = "+" + expA.charAt(0);
			} else if (stackA.peek().contains("-")) {
				addedString = "-" + expA.charAt(0);
			} else {
				addedString = "+" + expA.charAt(0);
			}
			checkForAddedString(addedString, mapA);
			expA = expA.substring(1);
			evaluateExpression(expA, stackA, mapA);
		}

	}

	private static void checkForAddedString(String addedString, HashMap<String, Integer> mapA) {
		if (addedString.contains("-")) {
			String mapKey = "+" + addedString.charAt(1);
			mapCalculations(mapKey, mapA, addedString);
		} else {
			String mapKey = "-" + addedString.charAt(1);
			mapCalculations(mapKey, mapA, addedString);
		}
	}

	private static void mapCalculations(String mapKey, HashMap<String, Integer> mapA, String addedString) {
		if (mapA.containsKey(mapKey)) {
			if (mapA.get(mapKey) > 1) {
				mapA.put(mapKey, mapA.get(mapKey) - 1);
			} else {
				mapA.remove(mapKey);
			}
		} else if (mapA.containsKey(addedString)) {
			mapA.put(addedString, mapA.get(addedString) + 1);
		} else {
			mapA.put(addedString, 1);
		}
	}

}
