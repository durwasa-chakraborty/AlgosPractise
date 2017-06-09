package com.test;

public class SortLinkedList {

	Node startNode;

	public static void main(String[] args) {
		new SortLinkedList();
	}

	public SortLinkedList() {
		Node node1 = new Node(10);
		Node node2 = new Node(1);
		Node node3 = new Node(-2);
		Node node4 = new Node(8);
		Node node5 = new Node(9);
		Node node6 = new Node(10);
		Node node7 = new Node(1);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);

		startNode = node1;

		System.out.println("SortLinkedList.SortLinkedList() before   ");
		printLinkList(startNode);
		System.out.println("");
		System.out.println("SortLinkedList.SortLinkedList() after   ");
		Node sortedStartNode = mergeSortLinkList(startNode);
		printLinkList(sortedStartNode);
	}

	private Node mergeSortLinkList(Node startNode) {

		// Break the list until list is null or only 1 element is present in
		// List.
		if (startNode == null || startNode.getNext() == null) {
			return startNode;
		}

		// Break the linklist into 2 list.
		// Finding Middle node and then breaking the Linled list in 2 parts.
		// Now 2 list are, 1st list from start to middle and 2nd list from
		// middle+1 to last.

		Node middle = getMiddle(startNode);
		Node nextOfMiddle = middle.getNext();
		middle.setNext(null);

		// Again breaking the List until there is only 1 element in each list.
		Node left = mergeSortLinkList(startNode);
		Node right = mergeSortLinkList(nextOfMiddle);

		// Once complete list is divided and contains only single element,
		// Start merging left and right half by sorting them and passing Sorted
		// list further.
		Node sortedList = mergeTwoListIterative(left, right);

		return sortedList;
	}

	// Iterative Approach for Merging Two Sorted List
	private Node mergeTwoListIterative(Node leftStart, Node rightStart) {

		Node merged = null;
		Node temp = null;

		// To keep track of last element, so that we don't need to iterate for
		// adding the element at last of
		// list when either LeftStart or rightStart is NULL.
		Node lastAddedNode = null;

		while (leftStart != null && rightStart != null) {

			if (leftStart.getData() > rightStart.getData()) {
				temp = new Node(rightStart.getData());
				rightStart = rightStart.getNext();

			} else {
				temp = new Node(leftStart.getData());
				leftStart = leftStart.getNext();
			}

			if (merged == null) {
				merged = temp;
			} else {
				lastAddedNode.setNext(temp);
			}
			lastAddedNode = temp;
		}

		if (leftStart != null) {
			lastAddedNode.setNext(leftStart);
		} else {
			lastAddedNode.setNext(rightStart);
		}

		return merged;
	}

	private Node getMiddle(Node startNode) {
		if (startNode == null) {
			return startNode;
		}

		Node pointer1 = startNode;
		Node pointer2 = startNode;

		while (pointer2 != null && pointer2.getNext() != null && pointer2.getNext().getNext() != null) {
			pointer1 = pointer1.getNext();
			pointer2 = pointer2.getNext().getNext();

		}
		return pointer1;
	}

	private void printLinkList(Node startNode) {
		Node temp = startNode;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

}
