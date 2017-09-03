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
		MinHeap heap = new MinHeap();
		heap.insert(5);
		heap.insert(3);
		heap.insert(17);
		heap.insert(10);
		heap.insert(84);
		heap.insert(19);
		heap.insert(6);
		heap.insert(22);
		heap.insert(9);
		printArray(heap.heap);
		System.out.println("Extract min : " + heap.extractMin());
		printArray(heap.heap);

		System.out.println("Extract min : " + heap.extractMin());
		printArray(heap.heap);

	}

	private void buildHeap() {
		for (int i = 0; i < size / 2; i++) {
			minHeapify(heap, size, i);
		}
	}

	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + ((2 * i + 1 >= size) ? -1 : heap[2 * i + 1])
					+ " RIGHT CHILD :" + ((2 * i + 2 >= size ? -1 : heap[2 * i + 2])));
			System.out.println();
		}
	}

	public int extractMin() {
		int min = heap[0];
		heap[0] = heap[--size];
		heap[size] = 0;
		minHeapify(heap, size, 0);
		return min;

	}

	public void insert(int key) {
		if (size == capacity) {
			System.out.println("MinHeap.insert() No space to insert in heap");
			return;
		}
		heap[size++] = key;

		int current = size - 1;
		while (heap[current] < heap[parent(current)]) {
			swap(heap, current, parent(current));
			current = parent(current);
		}
	}

	private int parent(int pos) {
		return (pos - 1) / 2;
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

	public int getCount() {
		return size;
	}

	public int getMin() {
		return heap[0];
	}

	// TODO
	public void decreaseKey(int index, int modifiedKeyValue) {

	}

}
