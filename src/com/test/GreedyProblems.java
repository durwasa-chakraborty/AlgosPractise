package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GreedyProblems {

	public static void main(String[] args) {
		Activity acivities[] = { new Activity(5, 9), new Activity(1, 2), new Activity(3, 4), new Activity(0, 6),
				new Activity(5, 7), new Activity(8, 9) };

		activitySelectionProblems(acivities);
	}

	static class Activity {
		int startTime, endTime;

		public Activity(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public String toString() {
			return "start time : " + startTime + " end time : " + endTime;
		}
	}

	private static void printArray(int[] arr) {
		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void printActivity(Activity[] arr) {
		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	public static void activitySelectionProblems(Activity[] activity) {

		Arrays.sort(activity, new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				if (o1.endTime > o2.endTime) {
					return 1;
				}
				return -1;
			}
		});

		printActivity(activity);

		int selected = 0;
		System.out.println("Work done for : " + selected + " activity is " + activity[selected]);
		for (int i = 1; i < activity.length; i++) {
			if (activity[i].startTime >= activity[selected].endTime) {
				selected = i;
				System.out.println("Work done for : " + selected + " activity is " + activity[selected]);
			}
		}

	}

}
