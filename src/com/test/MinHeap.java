package com.test;

public class MinHeap {

	final int MAX_CAPACITY = 10;
	int[] heap;
	int capacity;
	int size;

	public MinHeap() {
		heap = new int[MAX_CAPACITY];
		capacity = MAX_CAPACITY;
	}

	public MinHeap(int capcity) {
		heap = new int[capcity];
		this.capacity = capcity;
	}

	public static void main(String[] args) {

	}

	private int extractMin() {
		return 0;

	}

	private void insert(int key) {
		if (size + 1 > capacity) {
			System.out.println("MinHeap.insert() No space to insert in heap");
			return;
		}
		heap[++size] = key;

		int current = size;
		while (heap[current] < heap[parent(current)]) {
			swap(heap, current, parent(current));
			current = parent(current);
		}
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private static void minHeapify(int[] arr, int size, int elementIndex) {

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
			minHeapify(arr, size, smallest);
		}

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

}
