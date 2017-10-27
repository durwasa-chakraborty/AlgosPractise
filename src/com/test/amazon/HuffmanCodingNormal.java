package com.test.amazon;

import java.util.Scanner;

public class HuffmanCodingNormal {

	private static class MinHeapNode {
		MinHeapNode left, right;
		int frequency;
		Character data;
		int index;

		@Override
		public String toString() {
			return " " + frequency;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			scanner.nextLine();
			char[] charArray = scanner.nextLine().toCharArray();
			int length = charArray.length;

			MinHeap minHeap = new MinHeap(length);

			// adding in minheap while reading frequency from input
			for (int j = 0; j < length; j++) {
				MinHeapNode node = new MinHeapNode();
				node.data = charArray[j];
				// getting frequency from input
				node.frequency = scanner.nextInt();
				node.index = j;
				minHeap.insert(node);
			}

			// prepare minHeap for adding internal nodes and loop until one
			// element remained in minHeap
			while (minHeap.size != 1) {
				MinHeapNode left = minHeap.extractMin();
				MinHeapNode right = minHeap.extractMin();

				MinHeapNode node = new MinHeapNode();
				node.left = left;
				node.right = right;
				node.frequency = left.frequency + right.frequency;
				node.data = '$';
				minHeap.insert(node);
			}

			MinHeapNode minHeapNode = minHeap.minHeapNodes[0];
			preOrderTraversal(minHeapNode, "");
			System.out.println();
		}
	}

	private static void preOrderTraversal(MinHeapNode minHeapNode, String prefix) {
		if (minHeapNode == null) {
			return;
		}

		if (minHeapNode.data != '$') {
			System.out.print(prefix + " ");
			return;
		}

		preOrderTraversal(minHeapNode.left, prefix + "0");
		preOrderTraversal(minHeapNode.right, prefix + "1");
	}

	private static class MinHeap {
		MinHeapNode[] minHeapNodes;
		int capacity, size;

		public MinHeap(int capacity) {
			this.capacity = capacity;
			minHeapNodes = new MinHeapNode[capacity];
		}

		public void insert(MinHeapNode node) {
			if (size == capacity) {
				System.out.println("Heap full Not able to add node");
				return;
			}

			minHeapNodes[size++] = node;
			int current = size - 1;
			int parent = parent(current);
			while (parent != current && minHeapNodes[current].frequency <= minHeapNodes[parent].frequency) {
				if (minHeapNodes[current].frequency == minHeapNodes[parent].frequency) {
					if (minHeapNodes[current].data != '$' || minHeapNodes[parent].data != '$') {
						if (minHeapNodes[current].index < minHeapNodes[parent].index) {
							swap(minHeapNodes, current, parent);
							current = parent;
							parent = parent(current);
						}
					}
				} else {
					swap(minHeapNodes, current, parent);
					current = parent;
					parent = parent(current);
				}
			}

		}

		public MinHeapNode extractMin() {
			MinHeapNode min = minHeapNodes[0];
			minHeapNodes[0] = minHeapNodes[--size];
			minHeapNodes[size] = null;
			minHeapify(0);
			return min;
		}

		private int parent(int current) {
			return (current - 1) / 2;
		}

		public void minHeapify(int index) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			int smaller = index;
			if (left < size && minHeapNodes[left].frequency <= minHeapNodes[smaller].frequency) {
				if (minHeapNodes[left].frequency == minHeapNodes[smaller].frequency) {
					if (minHeapNodes[left].data != '$' || minHeapNodes[smaller].data != '$') {
						if (minHeapNodes[left].index > minHeapNodes[smaller].index) {
							smaller = left;
						}
					}
				} else {
					smaller = left;
				}
			}

			if (right < size && minHeapNodes[right].frequency <= minHeapNodes[smaller].frequency) {
				if (minHeapNodes[right].frequency == minHeapNodes[smaller].frequency) {
					if (minHeapNodes[right].data != '$' || minHeapNodes[smaller].data != '$') {
						if (minHeapNodes[right].index > minHeapNodes[smaller].index) {
							smaller = right;
						}
					}
				} else {
					smaller = right;
				}
			}
			if (smaller != index) {
				swap(minHeapNodes, smaller, index);
				minHeapify(smaller);
			}

		}

		private void swap(MinHeapNode[] minHeapNodes2, int smaller, int index) {
			MinHeapNode temp = minHeapNodes2[smaller];
			minHeapNodes2[smaller] = minHeapNodes2[index];
			minHeapNodes2[index] = temp;
		}
	}
}
