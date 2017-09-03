package com.test;

import com.test.MinHeapGraph.MinHeapNode;

public class MinHeapGraph {

	public static class MinHeapNode {
		public MinHeapNode(int vertex, int key) {
			this.vertex = vertex;
			this.key = key;
		}

		int vertex;
		int key;

		@Override
		public String toString() {
			return key + " " + "vertex : " + vertex;
		}
	}

	int size;
	MinHeapNode[] array;
	int[] pos;

	public MinHeapGraph(int capacity) {
		this.size = capacity;
		this.array = new MinHeapNode[size];
		this.pos = new int[capacity];
	}

	public MinHeapNode extractMin() {
		MinHeapNode root = array[0];
		MinHeapNode last = array[size - 1];
		array[0] = last;

		pos[root.vertex] = size - 1;
		pos[last.vertex] = 0;
		size--;
		minHeapify(size, 0);
		return root;
	}

	public boolean isEmptyHeap() {
		return size == 0;
	}

	private void insertItem(MinHeapNode item) {
		array[size++] = item;
		int current = size - 1;
		while (array[current].key < array[current / 2].key) {
			MinHeapNode temp = array[current];
			array[current] = array[current / 2];
			array[current / 2] = temp;

			current = current / 2;
		}
	}

	private void minHeapify(int size, int idX) {
		int left = 2 * idX + 1;
		int right = 2 * idX + 2;

		int smallest = idX;
		if (left < size) {
			if (array[smallest].key > array[left].key) {
				smallest = left;
			}
		}

		if (right < size) {
			if (array[smallest].key > array[right].key) {
				smallest = right;
			}
		}

		if (idX != smallest) {

			// Swap positions
			pos[array[smallest].vertex] = idX;
			pos[array[idX].vertex] = smallest;

			swapMinHeapNode(this, smallest, idX);
			minHeapify(size, smallest);

		}

	}

	private static void swapMinHeapNode(MinHeapGraph minHeap, int i, int current) {
		MinHeapNode temp = minHeap.array[i];
		minHeap.array[i] = minHeap.array[current];
		minHeap.array[current] = temp;
	}
}
