package com.test;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 0;

	public MaxHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		heap = new int[this.maxsize];
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}

	private void maxHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
				if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					maxHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					maxHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int element) {
		heap[size++] = element;
		int current = size - 1;

		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + ((2 * i + 1 >= size) ? -1 : heap[2 * i + 1])
					+ " RIGHT CHILD :" + ((2 * i + 2 >= size ? -1 : heap[2 * i + 2])));
			System.out.println();
		}
	}

	public void maxHeap() {
		for (int pos = (size / 2 - 1); pos >= 0; pos--) {
			maxHeapify(pos);
		}
	}

	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[--size];
		heap[size] = 0;
		maxHeapify(FRONT);
		return popped;
	}

	public static void main(String... arg) {
		System.out.println("The Max Heap is ");
		MaxHeap maxHeap = new MaxHeap(15);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		// maxHeap.maxHeap();

		printArray(maxHeap.heap);
		System.out.println("The max val is my method" + maxHeap.extractMax());

		printArray(maxHeap.heap);
		System.out.println("The max val is " + maxHeap.remove());

		printArray(maxHeap.heap);
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

	public int extractMax() {
		int item = heap[0];
		heap[0] = heap[--size];
		heap[size] = 0;
		maxHeapify(0);
		return item;
	}

	public int getMax() {
		return heap[0];
	}
}