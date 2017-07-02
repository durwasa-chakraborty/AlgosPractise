package com.test;

public class DoubleLinkedList {

	NodeLL head;

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.push(10);
		list.push(5);
		list.push(7);
		list.push(40);
		list.push(15);
		list.push(1);

		System.out.println("DoubleLinkedList.main()");
		print(list.head);

		list.quickSortData(list.head, getTail(list.head));

		System.out.println("");
		print(list.head);

		// list.head = quickSort(list.head, getTail(list.head));
		// print(list.head);
		// list.reverse();
		//
		// print(list.head);

		// list.head = list.mergeSort(list.head);
		// print(list.head);
		//
		list.checkPrevPointers(list.head);

	}

	NodeLL partitionN(NodeLL l, NodeLL h) {
		// set pivot as h element
		int x = h.data;

		// similar to i = l-1 for array implementation
		NodeLL i = l.random;

		// Similar to "for (int j = l; j <= h- 1; j++)"
		for (NodeLL j = l; j != h; j = j.next) {
			if (j.data <= x) {
				// Similar to i++ for array
				i = (i == null) ? l : i.next;
				int temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
		}
		i = (i == null) ? l : i.next; // Similar to i++
		int temp = i.data;
		i.data = h.data;
		h.data = temp;
		return i;
	}

	/* A recursive implementation of quicksort for linked list */
	void _quickSort(NodeLL l, NodeLL h) {
		if (h != null && l != h && l != h.next) {
			NodeLL temp = partitionN(l, h);
			_quickSort(l, temp.random);
			_quickSort(temp.next, h);
		}
	}

	// The main function to sort a linked list. It mainly calls _quickSort()
	public void quickSort(NodeLL node) {
		// Find last node
		NodeLL head = getTail(node);

		// Call the recursive QuickSort
		_quickSort(node, head);
	}

	private void quickSortData(NodeLL l, NodeLL h) {

		if (h != null && l != h && l.next != h) {

			NodeLL partitionData = partitionData(l, h);
			quickSortData(l, partitionData.random);
			quickSortData(partitionData.next, h);
		}
	}

	private static NodeLL partitionData(NodeLL head, NodeLL tail) {
		NodeLL temp = head;
		int x = tail.data;
		NodeLL index = head.random;
		while ( temp != tail) {
			if (temp.data <= x) {
				index = index == null ? head : index.next;
				int swap = temp.data;
				temp.data = index.data;
				index.data = swap;
			}

			temp = temp.next;
		}

		index = index == null ? head : index.next;
		int swap = tail.data;
		tail.data = index.data;
		index.data = swap;

		return index;
	}

	// private static Node partitionData(Node head, Node tail) {
	// Node temp = head;
	// Node index = head.prev;
	// while (temp != tail) {
	// if (temp.data <= tail.data) {
	//
	// index = index == null ? head : index.next;
	//
	// int swap = temp.data;
	// temp.data = index.data;
	// index.data = swap;
	// index = index.next;
	// }
	// temp = temp.next;
	// }
	//
	// index = (index == null ? head : index.next);
	//
	// int swap = tail.data;
	// tail.data = index.data;
	// index.data = swap;
	//
	// return index;
	// }

	private static NodeLL getTail(NodeLL head) {
		if (head == null) {
			return null;
		}

		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	public static NodeLL quickSort(NodeLL head, NodeLL endElement) {
		if (head == null || endElement == null || head == endElement) {
			return head;
		}
		NodeLL[] partition = partition(head, endElement);
		NodeLL left = quickSort(partition[0], partition[1]);
		NodeLL right = quickSort(partition[3], partition[4]);

		if (left != null) {
			NodeLL temp2 = left;
			while (temp2.next != null) {
				temp2 = temp2.next;
			}
			temp2.next = partition[2];
			partition[2].random = temp2;
		}

		partition[2].next = right;
		if (right != null) {
			right.random = partition[2];
		}
		if (left != null) {
			return left;
		} else {
			return partition[2];
		}

	}

	private static NodeLL[] partition(NodeLL head, NodeLL endElement) {
		NodeLL temp = head;
		NodeLL resultLeft = null, resultLeftHead = null;
		NodeLL resultRight = null, resultRightHead = null;
		while (temp != endElement) {

			if (endElement.data > temp.data) {
				if (resultLeft == null) {
					resultLeft = temp;
					resultLeftHead = resultLeft;
					temp.random = null;
				} else {
					resultLeft.next = temp;
					temp.random = resultLeft;
					resultLeft = resultLeft.next;
				}
			} else {

				if (resultRight == null) {
					resultRight = temp;
					resultRightHead = resultRight;
					temp.random = null;
				} else {
					resultRight.next = temp;
					temp.random = resultRight;
					resultRight = resultRight.next;
				}

			}

			temp = temp.next;
		}

		if (resultLeft != null) {
			resultLeft.next = null;
		}

		if (resultRight != null) {
			resultRight.next = null;
		}

		endElement.next = null;
		endElement.random = null;
		//
		// if (resultLeft != null) {
		// resultLeft.next = endElement;
		// endElement.prev = resultLeft;
		// }
		//
		// if (resultRight != null) {
		// endElement.next = resultRightHead;
		// resultRight.next = null;
		// }

		NodeLL[] result = new NodeLL[5];
		result[0] = resultLeftHead;
		result[1] = resultLeft;
		result[2] = endElement;
		result[3] = resultRightHead;
		result[4] = resultRight;

		return result;
	}

	public static void print(NodeLL head) {
		if (head == null) {
			System.out.println("DoubleLinkedList.print() empty");
			return;
		}
		NodeLL tnode = head;
		while (tnode != null) {
			System.out.print(tnode.getData() + " ");
			tnode = tnode.getNext();
		}
	}

	public void push(int item) {
		NodeLL newNode = new NodeLL(item);
		if (head == null) {
			head = newNode;
			return;
		}

		head.random = newNode;
		newNode.next = head;
		head = newNode;

	}

	public void reverse() {
		NodeLL prev = null;
		NodeLL current = head;
		NodeLL next;

		while (current != null) {
			prev = current.random;
			next = current.next;
			current.random = next;
			current.next = prev;
			current = next;
		}
		head = prev;

	}

	public NodeLL mergeSort(NodeLL head) {
		if (head == null || head.next == null) {
			return head;
		}

		NodeLL middle = getMiddle(head);
		NodeLL next = middle.next;

		middle.setNext(null);
		next.setPrev(null);
		NodeLL fList = mergeSort(head);
		NodeLL sList = mergeSort(next);

		return mergeR(fList, sList);

	}

	private NodeLL merge(NodeLL fList, NodeLL sList) {

		if (fList == null) {
			return sList;
		}

		if (sList == null) {
			return fList;
		}

		NodeLL head = null;
		NodeLL result = null;
		while (fList != null && sList != null) {
			if (fList.data < sList.data) {
				if (result == null) {
					head = fList;
					result = head;
				} else {
					result.next = fList;
					result.next.random = result;
					result = result.next;
				}
				fList = fList.next;
			} else {

				if (result == null) {
					head = sList;
					result = head;
				} else {
					result.next = sList;
					result.next.random = result;
					result = result.next;
				}
				sList = sList.next;
			}

		}

		if (sList == null) {
			if (result == null) {
				result = fList;
				head = result;
			} else {
				result.next = fList;
			}

			if (fList != null) {
				fList.random = result;
			}
		} else {
			if (result == null) {
				result = sList;
				head = result;
			} else {
				result.next = sList;
			}
			if (sList != null) {
				sList.random = result;
			}
		}

		return head;
	}

	@SuppressWarnings("unused")
	private NodeLL mergeR(NodeLL fList, NodeLL sList) {

		if (fList == null) {
			return sList;
		}

		if (sList == null) {
			return fList;
		}

		NodeLL result = null;

		if (fList.data < sList.data) {
			result = fList;
			result.next = mergeR(fList.next, sList);
			result.next.random = result;
		} else {
			result = sList;
			result.next = mergeR(fList, sList.next);
			result.next.random = result;
		}

		return result;
	}

	private NodeLL getMiddle(NodeLL head) {
		NodeLL slowPtr = head;
		NodeLL fastPtr = head;
		while (fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	private void checkPrevPointers(NodeLL head) {
		while (head.next != null) {
			head = head.next;
		}

		System.out.println("DoubleLinkedList.checkPrevPointers() ");
		System.out.println("");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.random;
		}
	}

}
