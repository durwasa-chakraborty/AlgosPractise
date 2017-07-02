package com.test;

import java.util.HashMap;

// A complete working Java program to delete a node in a linked list
// at a given position
class LinkedList {
	NodeLL head; // head of list
	FlattenNode headFlattenNode;

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		NodeLL new_node = new NodeLL(new_data);

		/* 3. Make next of new Node as head */
		new_node.setNext(head);

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Inserts a new Node at front of the list. */
	public void push(int x, int y) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		NodeLL new_node = new NodeLL(x, y);

		/* 3. Make next of new Node as head */
		new_node.setNext(head);

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Inserts a new Node at front of the list. */
	public void push(char new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		NodeLL new_node = new NodeLL(new_data);

		/* 3. Make next of new Node as head */
		new_node.setNext(head);

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a
	 * position, deletes the node at the given position
	 */
	void deleteNode(int position) {
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		NodeLL temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.getNext(); // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.getNext();

		// If position is more than number of ndoes
		if (temp == null || temp.getNext() == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		NodeLL next = temp.getNext().getNext();

		temp.setNext(next); // Unlink the deleted node from list
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		NodeLL tnode = head;
		while (tnode != null) {
			System.out.print(tnode.getData() + " ");
			tnode = tnode.getNext();
		}
	}

	public void printListWithPointers() {
		NodeLL tnode = head;
		while (tnode != null) {
			System.out
					.println(tnode.getData() + " " + "next node data " + (tnode.next != null ? tnode.next.data : "null")
							+ "  random node data " + (tnode.random != null ? tnode.random.data : "null"));
			tnode = tnode.getNext();
		}
	}

	public void printXYList() {
		NodeLL tnode = head;
		while (tnode != null) {
			System.out.print(tnode.x + "-" + tnode.y + "--> ");
			tnode = tnode.getNext();
		}
	}

	public void printListFlattenDown() {
		FlattenNode tnode = headFlattenNode;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.down;
		}
	}

	/* Returns count of nodes in linked list */
	public static int getCount(NodeLL head) {
		NodeLL temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void swap(int x, int y) {
		if (head == null) {
			System.out.println("LinkedList.swap() linked list empty");
			return;
		}

		NodeLL prevNodeX = null, nodeX = null;
		NodeLL prevNodeY = null, nodeY = null;
		NodeLL prevNode = null;
		NodeLL tmp = head;
		if (tmp.getData() == x) {
			prevNodeX = null;
			nodeX = tmp;
			prevNode = tmp;
			tmp = tmp.getNext();
		} else if (tmp.getData() == y) {
			prevNodeY = null;
			nodeY = tmp;
			prevNode = tmp;
			tmp = tmp.getNext();
		}

		while (tmp != null) {

			if (tmp.getData() == x) {
				prevNodeX = prevNode;
				nodeX = tmp;
			} else if (tmp.getData() == y) {
				prevNodeY = prevNode;
				nodeY = tmp;
			}
			prevNode = tmp;
			tmp = tmp.getNext();

			if (nodeX != null && nodeY != null) {
				break;
			}
		}

		if (nodeX == null || nodeY == null) {
			System.out.println("LinkedList.swap() either element is not in linked list");
			return;
		}

		// means head element is X
		if (prevNodeX == null) {
			prevNodeY.setNext(nodeX);
			head = nodeY;
			swapNext(nodeX, nodeY);

		}
		// head element is Y
		else if (prevNodeY == null) {
			prevNodeX.setNext(nodeY);
			head = nodeX;
			swapNext(nodeX, nodeY);

		}
		// neither is head elmenet
		else {
			swapNext(prevNodeX, prevNodeY);
			swapNext(nodeX, nodeY);
		}

	}

	private void swapNext(NodeLL nodeX, NodeLL nodeY) {
		NodeLL tmpS = nodeX.getNext();
		nodeX.setNext(nodeY.getNext());
		nodeY.setNext(tmpS);
	}

	public static NodeLL reverseLinkedList(NodeLL head) {

		if (head == null) {
			System.out.println("LinkedList.reverseLinkedList() empty linked list");
			return null;
		}

		if (head.getNext() == null) {
			System.out.println("LinkedList.reverseLinkedList() single element already reversed");
		}

		NodeLL prev = null;
		NodeLL current = head;
		NodeLL next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		head = prev;

		return head;

	}

	public static NodeLL merge(NodeLL n1, NodeLL n2) {

		NodeLL result = null;

		if (n1 == null) {
			return n2;
		}

		if (n2 == null) {
			return n1;
		}

		if (n1 != null && n2 != null) {
			if (n1.getData() < n2.getData()) {
				result = n1;
				result.setNext(merge(n1.getNext(), n2));
			} else {
				result = n2;
				result.setNext(merge(n1, n2.getNext()));
			}
		}
		return result;
	}

	public static NodeLL mergeI(NodeLL n1, NodeLL n2) {
		NodeLL result = null;

		if (n1 == null) {
			return n2;
		}

		if (n2 == null) {
			return n1;
		}

		NodeLL tmpHead = null;
		while (n1 != null && n2 != null) {
			if (n1.getData() < n2.getData()) {
				if (result == null) {
					result = n1;
					tmpHead = result;
				} else {
					result.setNext(n1);
					result = result.getNext();
				}
				n1 = n1.getNext();
			} else {
				if (result == null) {
					result = n2;
					tmpHead = result;
				} else {
					result.setNext(n2);
					result = result.getNext();
				}
				n2 = n2.getNext();
			}
		}

		if (n1 == null) {
			result.setNext(n2);
		} else if (n2 == null) {
			result.setNext(n1);
		}

		return tmpHead;

	}

	/*
	 * Drier program to test above functions. Ideally this function should be in
	 * a separate user class. It is kept here to keep code compact
	 */

	private static NodeLL segregateEvenAndOddNodesAnother(NodeLL head) {
		NodeLL tail = getTail(head);
		NodeLL temp = head;
		NodeLL next = null;
		NodeLL prev = null;
		NodeLL lastT = tail;
		while (temp != tail) {
			next = temp.next;

			if (!isEven(temp)) {
				lastT.next = temp;
				lastT = lastT.next;
				lastT.next = null;

				// change next pointer
				if (prev != null) {
					prev.next = next;
				}

				// if head pointer is moving pointer
				if (head.data == temp.data) {
					head = next;
				}

				temp = next;
				continue;
			}

			prev = temp;
			temp = next;
		}

		// // all nodes are even then last so we don't need to check last
		// element
		// if (prev == null) {
		// return head;
		// }

		if (!isEven(temp)) {
			if (prev != null) {
				prev.next = temp.next;
			}
			// it means all are odd ones
			if (head.data == temp.data) {
				head = temp.next;
			}
			lastT.next = temp;
			lastT = lastT.next;
			lastT.next = null;
		}

		return head;
	}

	private static NodeLL getTail(NodeLL head) {
		if (head == null) {
			return null;
		}

		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	private static NodeLL addTwoLists(LinkedList list1, LinkedList list2) {

		if (list1.head == null) {
			return list2.head;
		}

		if (list2.head == null) {
			return list1.head;
		}

		int size1 = getCount(list1.head);
		int size2 = getCount(list2.head);

		if (size1 == size2) {
			return addTwoListsSameSize(list1.head, list2.head, true);
		}

		int diff;
		if (size1 > size2) {
			diff = size1 - size2;
		} else {
			diff = size2 - size1;
			LinkedList temp = list1;
			list1 = list2;
			list2 = temp;
		}

		NodeLL tempHead = list1.head;

		for (int i = 0; i < diff; i++) {
			tempHead = tempHead.next;
		}

		NodeLL addTwoListsSameSize = addTwoListsSameSize(tempHead, list2.head, false);

		addTwoListsSameSize = addCarryToRemaining(list1.head, diff, addTwoListsSameSize, true);

		if (addTwoListsSameSize.data >= 10) {

			int rem = addTwoListsSameSize.data / 10;
			addTwoListsSameSize.data %= 10;
			NodeLL newNode = new NodeLL(rem);
			newNode.next = addTwoListsSameSize;
			addTwoListsSameSize = newNode;
		}

		return addTwoListsSameSize;
	}

	private static NodeLL addCarryToRemaining(NodeLL startingHead, int diff, NodeLL addTwoListsSameSize,
			boolean isStartingCall) {
		if (diff <= 0) {
			return null;
		}

		NodeLL temp = addCarryToRemaining(startingHead.next, diff - 1, addTwoListsSameSize, false);
		if (temp == null) {
			int rem = 0;
			if (addTwoListsSameSize.data >= 10) {
				rem = addTwoListsSameSize.data / 10;
				addTwoListsSameSize.data %= 10;
			}
			NodeLL newNode = new NodeLL(startingHead.data + rem);
			newNode.next = addTwoListsSameSize;
			addTwoListsSameSize = newNode;
		} else {
			int rem = 0;
			if (temp.data >= 10) {
				rem = temp.data / 10;
				temp.data %= 10;
			}
			NodeLL newNode = new NodeLL(startingHead.data + rem);
			newNode.next = temp;
			temp = newNode;
			addTwoListsSameSize = temp;

		}

		if (isStartingCall && addTwoListsSameSize.data >= 10) {
			NodeLL newNode = new NodeLL(addTwoListsSameSize.data / 10);
			addTwoListsSameSize.data %= 10;
			newNode.next = addTwoListsSameSize;
			addTwoListsSameSize = newNode;
		}

		return addTwoListsSameSize;
	}

	private static NodeLL mergeSort(NodeLL head) {

		if (head == null || head.getNext() == null) {
			return head;
		}

		NodeLL middleNode = getMiddle(head);
		NodeLL endList = middleNode.getNext();

		middleNode.setNext(null);

		NodeLL startListSort = mergeSort(head);
		NodeLL endListSort = mergeSort(endList);

		return merge(startListSort, endListSort);
	}

	public static NodeLL getMiddle(NodeLL head) {
		if (head == null) {
			return null;
		}
		NodeLL slowNode = head;
		NodeLL fastNode = head;

		while (fastNode != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}

		return slowNode;
	}

	private static NodeLL reverseInGroups(NodeLL head, int size) {
		if (head == null) {
			return null;
		}

		int i = 0;
		NodeLL prev = null;
		NodeLL current = head;
		NodeLL next = null;
		while (i != size && current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			i++;
		}

		head.setNext(reverseInGroups(next, size));
		return prev;
	}

	private static void detectAndRemoveLoop(NodeLL head) {

		NodeLL slowPointer = head;
		NodeLL fastPointer = head;

		while (slowPointer != null && fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			// floyd's algo if same then loop detected
			if (slowPointer == fastPointer) {
				removeLoop(slowPointer, head);

			}
		}
	}

	private static void removeLoop(NodeLL loopPointer, NodeLL head) {
		NodeLL altHead = head;
		NodeLL altLoop;
		while (true) {
			altLoop = loopPointer;

			while (altLoop.getNext() != altHead && altLoop.getNext() != loopPointer) {
				altLoop = altLoop.getNext();
			}

			// find the linkedlist head pointer to find the looped one
			if (altLoop.getNext() == altHead) {
				break;
			}

			altHead = altHead.getNext();
		}

		altLoop.setNext(null);
	}

	private static NodeLL addTwoListsSameSize(NodeLL list1, NodeLL list2, boolean isStartNode) {

		if (list1 == null && list2 == null) {
			return null;
		}

		NodeLL addNode = addTwoListsSameSize(list1 != null ? list1.next : null, list2 != null ? list2.next : null, false);
		int add = (list1 != null ? list1.data : 0) + (list2 != null ? list2.data : 0);
		int prevRem = 0;
		if (addNode != null && addNode.data >= 10) {
			prevRem = addNode.data / 10;
			addNode.data %= 10;
		}

		add += prevRem;
		NodeLL newNode = new NodeLL(add);
		newNode.next = addNode;

		if (isStartNode && newNode.data >= 10) {
			NodeLL newNode2 = new NodeLL(newNode.data / 10);
			newNode2.next = newNode;
			newNode.data %= 10;
			newNode = newNode2;
		}

		return newNode;

	}

	// choose the last node as the pivot
	public NodeLL quickSortRecur(NodeLL head, NodeLL tail) {

		if (head == tail)
			return head;

		NodeLL pivot = tail, cur = head, pre = null, newhead = null;

		while (pivot != cur) {
			if (cur.data < pivot.data) {
				if (null == newhead)
					newhead = cur;
				pre = cur;
				cur = cur.next;
			} else {
				tail.next = cur;
				tail = tail.next;
				NodeLL tmp = cur.next;
				cur.next = null;
				cur = tmp;
				if (null != pre) {
					pre.next = cur;
				}
			}
		}
		if (pre != null) {
			newhead = quickSortRecur(newhead, pre);
			NodeLL tmp = newhead;
			while (tmp.next != null && pivot != tmp.next)
				tmp = tmp.next;
			tmp.next = pivot;
		} else {
			newhead = pivot;
		}
		if (pivot != tail)
			pivot.next = quickSortRecur(pivot.next, tail);
		return newhead;
	}

	public NodeLL quickSort(NodeLL start, NodeLL end) {
		/* Exist condition */
		// If the list contains one or less node, return the start node itself.
		if (null == start || null == start.getNext() || start == end) {
			return start;
		}
		/* Partition the list */
		// Result contains start/end of left and right segments and the pivot.
		NodeLL[] result = partitionC(start, end);

		/* Recur the left side */
		NodeLL resultLeft = null; // Start of left result.
		if (null != result[0]) {

			resultLeft = quickSort(result[0], result[1]);
		}

		/* Recur the right side */
		NodeLL resultRight = null; // Start of right result.
		if (null != result[3]) {
			resultRight = quickSort(result[3], result[4]);
		}

		/* Connect the pivot to the start of right segmen */
		if (resultRight != null) {
			result[2].setNext(resultRight);
		}

		/* Return start of the list */
		if (null == resultLeft) {
			// If left segment has nothing, return pivot.
			return result[2];
		} else {
			// Else return the start of left.
			return resultLeft;
		}
	}

	/**
	 * Partitioning.
	 * <p>
	 * Details - Choose the last node as pivot. Traverse and move the nodes with
	 * bigger value than pivot to the right of pivot.
	 * </p>
	 * 
	 * @param start
	 * @param end
	 * @return Array of nodes[Start of left, end of left, pivot, start of right,
	 *         end of right]
	 */
	private NodeLL[] partition(NodeLL start, NodeLL end) {
		/* Choose a pivot */
		// We are not moving pivot but the other nodes.
		NodeLL pivot = end;

		/* Define the required pointers */
		// Tail points to the end of new list
		NodeLL tail = end;
		// Start of newly arranged list
		NodeLL newStart = null;
		// Iteration pointers
		NodeLL current = start;
		NodeLL previous = null;

		/* Iterate and move nodes */
		// Iterate the original list till the end.
		boolean isFirstNodeWithoutMove = true;
		while (null != current && end != current) {
			NodeLL next = current.getNext();
			// For nodes with value grater than pivot move to the right of
			// pivot.
			if (current.data > pivot.data) {
				// Move the current node to the end of the list.
				moveNodeToEnd(current, previous, tail);
				// Advance tail.
				tail = tail.getNext();
			} else {
				if (isFirstNodeWithoutMove) {
					newStart = current;
					isFirstNodeWithoutMove = false;
				}
				// Advance iteration pointers.
				if (null != previous) {
					previous.setNext(current);
				}
				previous = current;
			}
			current = next;
		}

		/* Prepare result for returning */
		NodeLL[] result = new NodeLL[5];
		result[0] = newStart;
		result[1] = previous;
		result[2] = pivot;
		result[3] = pivot.getNext();
		result[4] = tail;

		return result;
	}

	private NodeLL quickSortC(NodeLL start, NodeLL end) {

		if (start == null || start.getNext() == null || start == end) {
			return start;
		}

		NodeLL[] partitionC = partitionC(start, end);

		NodeLL resultLeft = null;
		if (partitionC[0] != null) {
			resultLeft = quickSortC(partitionC[0], partitionC[1]);
		}

		if (resultLeft != null) {
			NodeLL temp = resultLeft;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = partitionC[2];
		}

		NodeLL resultRight = null;
		if (partitionC[3] != null) {
			resultRight = quickSortC(partitionC[3], partitionC[4]);
		}

		if (resultRight != null) {
			partitionC[2].next = resultRight;
		}

		if (resultLeft != null) {
			return resultLeft;
		} else {
			return partitionC[2];
		}

	}

	private NodeLL[] partitionC(NodeLL start, NodeLL end) {

		NodeLL temp = start;

		NodeLL fHead = null, fEnd = null;
		NodeLL sHead = null, sEnd = null;

		while (temp != end) {
			if (temp.data <= end.data) {
				if (fHead == null) {
					fHead = temp;
					fEnd = fHead;
				} else {
					fEnd.next = temp;
					fEnd = fEnd.next;
				}

			} else {

				if (sHead == null) {
					sHead = temp;
					sEnd = sHead;
				} else {
					sEnd.next = temp;
					sEnd = sEnd.next;
				}

			}

			temp = temp.next;
		}

		if (fEnd != null) {
			fEnd.next = null;
		}
		if (sEnd != null) {
			sEnd.next = null;
		}

		NodeLL[] result = new NodeLL[5];
		result[0] = fHead;
		result[1] = fEnd;
		result[2] = end;
		result[3] = sHead;
		result[4] = sEnd;

		return result;
	}

	private void moveNodeToEnd(NodeLL current, NodeLL previous, NodeLL tail) {
		if (null != previous) {
			previous.setNext(current.getNext());
		}
		current.setNext(null);
		tail.setNext(current);
	}

	public static boolean isPalidrome(NodeLL head) {

		if (head == null || head.next == null) {
			return true;
		}
		NodeLL slowNode = head;
		NodeLL fastNode = head;

		while (fastNode != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}

		// for odd
		NodeLL oddNode = null;
		NodeLL fList = head;
		NodeLL sList = null;
		if (fastNode.getNext() == null) {
			oddNode = slowNode;
		}
		sList = slowNode.next;

		sList = reverseLinkedList(sList);

		boolean isPalindrome = true;
		while (sList != null && fList != null) {
			if (sList.textData != fList.textData) {
				isPalindrome = false;
				break;
			}
			sList = sList.next;
			fList = fList.next;
		}

		return isPalindrome;

	}

	public NodeLL recursiveReverse(NodeLL node) {
		if (node == null) {
			return null;
		}

		if (node.next == null) {
			return node;
		}

		NodeLL next = node.next;

		node.next = null;

		NodeLL reverse = recursiveReverse(next);

		next.next = node;

		return reverse;
	}

	public NodeLL recursiveReverse(NodeLL curr, NodeLL prev) {
		if (curr == null) {
			return null;
		}

		if (curr.next == null) {
			curr.next = prev;
			return curr;
		}

		NodeLL next = curr.next;
		curr.next = prev;

		return recursiveReverse(next, curr);
	}

	public void removeSortedDuplicate(NodeLL head) {
		NodeLL temp = head;
		while (temp != null) {
			if (temp.next != null && temp.next.data == temp.data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
	}

	public NodeLL reverseInGroup(NodeLL head, int groupSize) {
		if (head == null || head.next == null) {
			return head;
		}
		int count = 0;
		NodeLL curr = head;
		NodeLL prev = null;
		NodeLL next = null;
		while (count < groupSize && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		head.next = reverseInGroup(next, groupSize);

		return prev;

	}

	public static NodeLL intersectionOfTwoSortedNodes(NodeLL headA, NodeLL headB) {
		if (headA == null || headB == null) {
			return null;
		}

		NodeLL result = null;
		if (headA.data == headB.data) {
			result = new NodeLL(headA.data);
			result.next = intersectionOfTwoSortedNodes(headA.next, headB.next);
			return result;
		} else if (headA.data < headB.data) {
			return intersectionOfTwoSortedNodes(headA.next, headB);
		} else {
			return intersectionOfTwoSortedNodes(headA, headB.next);
		}
	}

	public static NodeLL deleteAlternateNodes(NodeLL head) {
		NodeLL temp = head;
		NodeLL next = null;
		while (temp != null && temp.next != null) {
			next = temp.next.next;
			temp.next = next;
			temp = next;

		}
		return head;
	}

	void deleteAlt(NodeLL head) {
		if (head == null)
			return;

		NodeLL prev = head;
		NodeLL now = head.next;

		while (prev != null && now != null) {
			/* Change next link of previus node */
			prev.next = now.next;

			/* Free node */
			now = null;

			/* Update prev and now */
			prev = prev.next;
			if (prev != null)
				now = prev.next;
		}
	}

	public static NodeLL deleteAlternateNodesRecursive(NodeLL head) {
		if (head == null || head.next == null) {
			return head;
		}

		head.next = head.next.next;

		head.next = deleteAlternateNodesRecursive(head.next);

		return head;
	}

	public static void alternateSplit(NodeLL head) {
		NodeLL dummyA = new NodeLL(-5);
		NodeLL dummyB = new NodeLL(-4);

		NodeLL a = dummyA;
		NodeLL b = dummyB;

		NodeLL current = head;
		while (current != null) {
			NodeLL next = current.next;

			a.next = current;
			a = a.next;

			b.next = next;
			b = b.next;

			if (next != null) {
				current = next.next;
				a.next = null;
				b.next = null;

			} else {
				break;
			}
		}

		LinkedList list = new LinkedList();
		list.head = dummyA.next;
		System.out.println("LinkedList.alternateSplit() A ");
		list.printList();

		list.head = dummyB.next;
		System.out.println("LinkedList.alternateSplit() B ");
		list.printList();

	}

	public static boolean isIdenticalLinkedLists(NodeLL headA, NodeLL headB) {
		if (headA == null && headB == null) {
			return true;
		}

		if (headA != null && headB != null) {
			if (headA.data == headB.data) {
				return isIdenticalLinkedLists(headA.next, headB.next);
			}
		}
		return false;
	}

	public static NodeLL deleteNodesGreaterValueOnRightSide(NodeLL head) {

		NodeLL curr = head;
		NodeLL prev = null;

		NodeLL result = null;
		while (curr != null && curr.next != null) {

			if (curr.data < curr.next.data) {
				if (prev != null) {
					prev.next = curr.next;
					curr = prev;
				} else {
					result = curr.next;
					curr = curr.next;
				}

			} else {
				prev = curr;
				curr = curr.next;
			}

		}

		return result;

	}

	public static NodeLL segregateEvenAndOddNodes(NodeLL head) {

		NodeLL temp = head;
		NodeLL dummyNodeEven = new NodeLL(-5);
		NodeLL dummyNodeOdd = new NodeLL(-10);
		NodeLL evenLeft = dummyNodeEven;
		NodeLL oddRight = dummyNodeOdd;
		NodeLL next = null;

		while (temp != null) {
			next = temp.next;
			if (isEven(temp)) {
				evenLeft.next = temp;
				evenLeft = evenLeft.next;
			} else {
				oddRight.next = temp;
				oddRight = oddRight.next;
			}
			temp.next = null;
			temp = next;
		}

		NodeLL result = null;
		if (dummyNodeEven.next != null) {
			result = dummyNodeEven.next;
			evenLeft.next = dummyNodeOdd.next;
		} else {
			result = dummyNodeOdd.next;
		}

		return result;
	}

	private static boolean isEven(NodeLL lastNode) {
		return lastNode.data % 2 == 0;
	}

	private static NodeLL rotateByKNodes(int k, NodeLL head) {
		int count = k;
		NodeLL tail = getTail(head);
		NodeLL next = null;
		while (count != 0) {
			tail.next = head;
			tail = tail.next;
			next = head.next;
			head.next = null;
			head = next;
			count--;
		}

		return head;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		// list.push(7);
		// list.push(6);
		// list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);
		list.printList();

		list.rearrangeLinkedList();
		System.out.println();
		System.out.println("LinkedList.main() after rearranging");
		list.printList();

		// LinkedList list = new LinkedList();
		// list.push(14);
		// list.push(12);
		// list.push(10);
		// list.push(8);
		// list.push(6);
		// list.push(4);
		// list.push(2);
		// list.printList();
		// System.out.println();
		// System.out.println("LinkedList.main() after creating balanced bst");
		// NodeBST nodeBST =
		// list.sortedLinkedListToBalancedBSTWithouthChangeLL();
		//
		// BST.inorderTraversal(nodeBST);

		// list.printListWithPointers();
		//
		// list.head = pointRandomPointerInLinkedList(list.head);
		// System.out.println("LinkedList.main() after sorting");
		//
		// list.printListWithPointers();

		// list.head = insertionSortP(list.head);
		// LinkedList list = new LinkedList();
		// list.push(5);
		// list.push(4);
		// list.push(3);
		// list.push(2);
		// list.push(1);
		//
		// // Setting up random references.
		// list.head.random = list.head.next.next;
		// list.head.next.random = list.head.next.next.next;
		// list.head.next.next.random = list.head.next.next.next.next;
		// list.head.next.next.next.random = list.head.next.next.next.next.next;
		// list.head.next.next.next.next.random = list.head.next;
		//
		// list.printListWithPointers();
		// System.out.println("LinkedList.main() after cloning");
		// list.head =
		// cloneNextAndRandomPointerUsingConstantExtraSpace(list.head);
		// list.printListWithPointers();

		// LinkedList list = new LinkedList();
		// list.head = new Node(50);
		// list.head.next = new Node(20);
		// list.head.next.next = new Node(15);
		// list.head.next.next.next = new Node(4);
		// list.head.next.next.next.next = new Node(10);
		//
		// // Creating a loop for testing
		// list.head.next.next.next.next.next = list.head.next.next;
		// detectAndRemoveLoop(list.head);
		// System.out.println("Linked List after removing loop : ");
		// list.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(16);
		// llist.push(8);
		// llist.push(2);
		//
		// llist.push(15);
		// llist.push(10);
		// llist.push(5);
		// llist.push(6);
		// llist.push(7);
		// System.out.println("LinkedList.main() before ");
		// llist.printList();
		//
		// // llist.head = mergeSort(llist.head);
		//
		// llist.head = reverseInGroups(llist.head, 3);
		// System.out.println("LinkedList.main() after");
		//
		// llist.printList();

		// llist.deleteNode(4); // Delete node at position 4
		// llist.swap(8, 2);
		// llist.reverseLinkedList();

		// System.out.println("\nLinked List after Deletion at position 4: ");
		// llist.printList();

		/*
		 * LinkedList list = new LinkedList();
		 * 
		 * // creating first list list.head = new Node(9); // list.head.next =
		 * new Node(9); // list.head.next.next = new Node(6); //
		 * list.head.next.next.next = new Node(3); //
		 * list.head.next.next.next.next = new Node(5); System.out.println("");
		 * list.printList();
		 * 
		 * // creating second list LinkedList list2 = new LinkedList(); //
		 * list2.head = new Node(8); // list2.head.next = new Node(4); //
		 * list2.head.next.next = new Node(2); System.out.println("");
		 * list2.printList();
		 * 
		 * // add the two lists and see the result LinkedList list3 = new
		 * LinkedList();
		 * 
		 * list3.head = addTwoLists(list2, list);
		 * 
		 * System.out.println(""); list3.printList();
		 */

		// LinkedList llist = new LinkedList();
		//
		// llist.push(8);
		// llist.push(2);
		//
		// llist.push(15);
		// llist.push(16);
		// llist.push(10);
		// llist.push(5);
		// llist.push(6);
		// llist.push(7);
		//
		// llist.printList();
		// System.out.println("");
		// llist.head = llist.quickSortC(llist.head, getTail(llist.head));
		// System.out.println("LinkedList.main() after");
		// llist.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push('r');
		// llist.push('a');
		//
		// llist.push('d');
		// llist.push('a');
		// llist.push('r');
		// System.out.println("LinkedList.main() isPalindrome " +
		// isPalidrome(llist.head));
		// ;
		//
		// llist.printList();
		// System.out.println("");
		// llist.head = llist.quickSortC(llist.head, getTail(llist.head));
		// System.out.println("LinkedList.main() after");
		// llist.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(5);
		// llist.push(10);
		//
		// llist.push(15);
		// llist.push(18);
		// llist.push(20);
		// llist.push(30);

		// llist.printList();
		// System.out.println("");
		//
		// llist.head = llist.reverseInGroup(llist.head, 4);
		// llist.printList();

		// llist.head = llist.recursiveReverse(llist.head, null);
		// llist.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(10);
		// llist.push(8);
		//
		// llist.push(6);
		// llist.push(4);
		// // llist.push(2);
		// // llist.push(1);
		//
		// llist.printList();
		//
		// System.out.println("");
		//
		// LinkedList llist2 = new LinkedList();
		//
		// llist2.push(10);
		// llist2.push(8);
		//
		// llist2.push(6);
		// llist2.push(4);
		// // llist.push(2);
		// // llist.push(1);
		//
		// llist2.printList();
		//
		// System.out.println("");
		//
		// System.out.println("LinkedList.main()" +
		// isIdenticalLinkedLists(llist.head, llist2.head));

		// alternateSplit(llist.head);

		// llist.head = deleteAlternateNodesRecursive(llist.head);
		// llist.deleteAlt(llist.head);

		// llist.head = deleteAlternateNodesRecursive(llist.head);
		//
		// llist.printList();

		//
		// LinkedList llist2 = new LinkedList();
		//
		// llist2.push(10);
		//
		// llist2.push(6);
		// llist2.push(4);
		// llist2.push(2);
		//
		// llist2.printList();
		// System.out.println("");
		//
		// Node result = intersectionOfTwoSortedNodes(llist.head, llist2.head);
		// LinkedList list = new LinkedList();
		// list.head = result;
		//
		// System.out.println("");
		// list.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(3);
		//
		// llist.push(2);
		// llist.push(6);
		// llist.push(5);
		// llist.push(11);
		// llist.push(10);
		// llist.push(15);
		// llist.push(12);
		// // llist.push(2);
		// // llist.push(1);
		//
		// llist.printList();
		//
		// System.out.println("");
		//
		// llist.head = deleteNodesGreaterValueOnRightSide(llist.head);
		//
		// System.out.println("LinkedList.enclosing_method()");
		//
		// llist.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(2);
		// llist.push(6);
		// // llist.push(5);
		// // llist.push(11);
		// llist.push(10);
		// // llist.push(15);
		// llist.push(12);
		// // llist.push(3);
		//
		// llist.printList();
		//
		// System.out.println("");
		//
		// llist.head = segregateEvenAndOddNodesAnother(llist.head);
		//
		// System.out.println("LinkedList.main() result ");
		//
		// System.out.println("");
		//
		// llist.printList();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(60);
		// llist.push(50);
		// llist.push(40);
		// llist.push(30);
		// llist.push(20);
		// llist.push(10);
		//
		// llist.printList();
		//
		// System.out.println("");
		//
		// llist.head = rotateByKNodes(4, llist.head);
		//
		// llist.printList();

		// LinkedList list = new LinkedList();
		// list.headFlattenNode = list.pushFlattenNode(30,
		// list.headFlattenNode);
		// list.headFlattenNode = list.pushFlattenNode(8, list.headFlattenNode);
		// list.headFlattenNode = list.pushFlattenNode(7, list.headFlattenNode);
		// list.headFlattenNode = list.pushFlattenNode(5, list.headFlattenNode);
		//
		// list.headFlattenNode.right = list.pushFlattenNode(20,
		// list.headFlattenNode.right);
		// list.headFlattenNode.right = list.pushFlattenNode(10,
		// list.headFlattenNode.right);
		//
		// list.headFlattenNode.right.right = list.pushFlattenNode(50,
		// list.headFlattenNode.right.right);
		// list.headFlattenNode.right.right = list.pushFlattenNode(22,
		// list.headFlattenNode.right.right);
		// list.headFlattenNode.right.right = list.pushFlattenNode(19,
		// list.headFlattenNode.right.right);
		//
		// list.headFlattenNode.right.right.right = list.pushFlattenNode(45,
		// list.headFlattenNode.right.right.right);
		// list.headFlattenNode.right.right.right = list.pushFlattenNode(40,
		// list.headFlattenNode.right.right.right);
		// list.headFlattenNode.right.right.right = list.pushFlattenNode(35,
		// list.headFlattenNode.right.right.right);
		// list.headFlattenNode.right.right.right = list.pushFlattenNode(28,
		// list.headFlattenNode.right.right.right);
		//
		// list.flatten(list.headFlattenNode);
		//
		// list.printListFlattenDown();

		// LinkedList llist = new LinkedList();
		//
		// llist.push(40, 5);
		// llist.push(20, 5);
		// llist.push(10, 5);
		// llist.push(10, 8);
		// llist.push(10, 10);
		// llist.push(3, 10);
		// llist.push(1, 10);
		// llist.push(0, 10);
		//
		// System.out.println("Given list");
		// llist.printXYList();
		//
		// System.out.println("");
		// llist.head = deleteMiddleLineSegments(llist.head);
		// llist.printXYList();

		// LinkedList list = new LinkedList();
		// list.push(5);
		// list.push(4);
		// list.push(3);
		// list.push(2);
		// list.push(1);
		//
		// // Setting up random references.
		// list.head.random = list.head.next.next;
		// list.head.next.random = list.head.next.next.next;
		// list.head.next.next.random = list.head.next.next.next.next;
		// list.head.next.next.next.random = list.head.next.next.next.next.next;
		// list.head.next.next.next.next.random = list.head.next;
		//
		// list.printListWithPointers();
		// System.out.println("LinkedList.main() after cloning");
		// list.head = list.cloneNextAndRandomPointerList(list.head);
		// list.printListWithPointers();

		// LinkedList list = new LinkedList();
		// list.push(5);
		// list.push(20);
		// list.push(4);
		// list.push(3);
		// list.push(30);
		//
		// System.out.println("LinkedList.main() before sort");
		//
		// list.printList();
		//
		// list.head = insertionSort(list.head);
		// System.out.println("LinkedList.main() after sort");
		// list.printList();
	}

	private FlattenNode flatten(FlattenNode headFlattenNode) {

		if (headFlattenNode == null || headFlattenNode.right == null) {
			return headFlattenNode;
		}

		headFlattenNode.right = flatten(headFlattenNode.right);
		headFlattenNode = mergeTwoSortedFlatttenList(headFlattenNode, headFlattenNode.right);

		return headFlattenNode;

	}

	private FlattenNode mergeTwoSortedFlatttenList(FlattenNode nodeA, FlattenNode nodeB) {
		if (nodeA == null) {
			return nodeB;
		}

		if (nodeB == null) {
			return nodeA;
		}

		FlattenNode result = null;

		if (nodeA.data < nodeB.data) {
			result = nodeA;
			result.down = mergeTwoSortedFlatttenList(nodeA.down, nodeB);
		} else {
			result = nodeB;
			result.down = mergeTwoSortedFlatttenList(nodeA, nodeB.down);
		}

		return result;
	}

	public FlattenNode pushFlattenNode(int data, FlattenNode head) {
		FlattenNode flattenNode = new FlattenNode(data);
		flattenNode.down = head;
		head = flattenNode;
		return head;

	}

	public static NodeLL deleteMiddleLineSegments(NodeLL head) {

		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		NodeLL temp = head;
		NodeLL next = temp.next;
		NodeLL nextNext = temp.next.next;

		if (isHorizontalLine(temp, next) && isHorizontalLine(temp, nextNext)) {
			temp.next = nextNext;
			next = nextNext;
			nextNext = nextNext.next;
		} else if (isVerticalLine(temp, next) && isVerticalLine(temp, nextNext)) {
			temp.next = nextNext;
			next = nextNext;
			nextNext = nextNext.next;
		} else {
			temp = next;
		}

		deleteMiddleLineSegments(temp);

		return head;
	}

	private static boolean isHorizontalLine(NodeLL temp, NodeLL next) {
		return temp.y == next.y;
	}

	private static boolean isVerticalLine(NodeLL temp, NodeLL next) {
		return temp.x == next.x;
	}

	public NodeLL cloneNextAndRandomPointerList(NodeLL head) {

		NodeLL temp = head;
		HashMap<Integer, NodeLL> map = new HashMap<>();
		NodeLL newHead = null, tail = null;
		while (temp != null) {
			if (newHead == null) {
				newHead = prepareIfNotInMap(map, temp);
				tail = newHead;
			} else {
				tail.next = prepareIfNotInMap(map, temp);
				tail = tail.next;
			}
			temp = temp.next;
		}

		return newHead;
	}

	private NodeLL prepareIfNotInMap(HashMap<Integer, NodeLL> map, NodeLL node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node.data)) {
			return map.get(node.data);
		}
		NodeLL newNode = new NodeLL(node.data);
		map.put(newNode.data, newNode);
		newNode.random = prepareIfNotInMap(map, node.random);
		newNode.next = prepareIfNotInMap(map, node.next);
		return newNode;
	}

	private static NodeLL insertionSortP(NodeLL head) {

		if (head == null || head.next == null) {
			return head;
		}
		NodeLL sortedList = null;
		NodeLL temp = head;

		while (temp != null) {
			NodeLL next = temp.next;
			temp.next = null;
			sortedList = sortedInsert(sortedList, temp);
			temp = next;
		}

		return sortedList;
	}

	private static NodeLL sortedInsert(NodeLL sortedList, NodeLL addedNode) {
		if (sortedList == null) {
			return addedNode;
		}

		NodeLL prev = null;
		NodeLL current = sortedList;
		while (current != null && current.data < addedNode.data) {
			prev = current;
			current = current.next;
		}

		if (prev == null) {
			addedNode.next = sortedList;
			return addedNode;
		}
		NodeLL prevNext = prev.next;
		prev.next = addedNode;
		addedNode.next = prevNext;
		return sortedList;
	}

	private static NodeLL cloneNextAndRandomPointerUsingConstantExtraSpace(NodeLL head) {

		if (head == null) {
			return null;
		}
		NodeLL temp = head;
		NodeLL resultHead = null;
		NodeLL resultTemp = null;

		// create copy and insert elements in between as state above in algo
		while (temp != null) {
			NodeLL newNode = new NodeLL(temp.data);
			NodeLL tempNext = temp.next;
			temp.next = newNode;
			newNode.next = tempNext;
			temp = tempNext;
		}

		// now copy random link
		temp = head;

		while (temp != null) {
			if (temp.random != null) {
				temp.next.random = temp.random.next;
			}
			temp = temp.next.next;
		}

		// now make the cloned list detached from the original one
		temp = head;
		while (temp != null) {
			NodeLL tempNextNext = temp.next.next;
			if (resultHead == null) {
				resultHead = temp.next;
				resultTemp = resultHead;
			} else {
				resultTemp.next = temp.next;
				resultTemp = resultTemp.next;
			}

			resultTemp.next = null;
			temp.next = tempNextNext;
			temp = tempNextNext;
		}

		return resultHead;
	}

	private static NodeLL insertionSort(NodeLL head) {
		NodeLL item = head;

		NodeLL dummy = new NodeLL(-1);

		NodeLL prevItem = item;
		dummy.next = item;

		item = item.next;

		while (item != null) {

			NodeLL next = item.next;
			boolean isShifted = false;

			NodeLL prevSort = dummy;
			NodeLL tempSort = dummy.next;

			while (tempSort.data != item.data) {
				if (item.data < tempSort.data) {
					NodeLL prevSortNext = prevSort.next;
					prevSort.next = item;
					item.next = prevSortNext;
					prevItem.next = next;
					isShifted = true;
					break;
				}
				prevSort = tempSort;
				tempSort = tempSort.next;
			}

			if (!isShifted) {
				prevItem = item;
			}
			item = next;
		}

		return dummy.next;
	}

	private static NodeLL pointRandomPointerInLinkedList(NodeLL head) {
		NodeLL temp = head;
		while (temp != null) {
			NodeLL nextGreater = temp.next;
			if (nextGreater == null) {
				nextGreater = head;
			}
			while (nextGreater.data != temp.data && nextGreater.data < temp.data) {
				NodeLL nextNext = nextGreater.next;
				if (nextNext == null) {
					nextGreater = head;
				} else {
					nextGreater = nextNext;
				}
			}

			if (nextGreater.data != temp.data) {
				temp.random = nextGreater;
			}
			temp = temp.next;
		}

		return head;
	}

	private Node sortedLinkedListToBalancedBSTWithouthChangeLL() {
		int count = LinkedList.getCount(head);
		return sortedLinkedListToBalancedBSTOptimized(0, count - 1);
	}

	// http://www.crazyforcode.com/convert-sorted-list-balanced-bst/
	private Node sortedLinkedListToBalancedBSTOptimized(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		Node nodeLeft = sortedLinkedListToBalancedBSTOptimized(start, mid - 1);

		Node root = new Node(head.data);
		root.left = nodeLeft;
		head = head.next;

		root.right = sortedLinkedListToBalancedBSTOptimized((mid + 1), end);
		return root;
	}

	public NodeLL rearrangeLinkedList() {
		tempHead = head;
		if (tempHead == null || tempHead.next == null || tempHead.next.next == null) {
			return tempHead;
		}
		return rearrangeLinkedList(tempHead);
	}

	NodeLL tempHead = null;;

	public NodeLL rearrangeLinkedList(NodeLL current) {

		if (current.next == null) {
			return current;
		}

		NodeLL list = rearrangeLinkedList(current.next);
		if (tempHead == null || tempHead.next == null || tempHead.next.next == null) {
			return null;
		}
		NodeLL next = tempHead.next;
		current.next = null;
		tempHead.next = list;
		tempHead.next.next = next;

		tempHead = tempHead.next.next;
		return current;
	}

	// /**
	// * using fast and slow pointer algo and then reverse second hallf and put
	// in
	// * middle of elements
	// *
	// * @return
	// */
	// public Node rearrangeLinkedList() {
	//
	// Node temp = head;
	// Node middle = getMiddle(head);
	// Node temp2 = middle.next;
	// middle.next = null;
	// temp2 = reverseLinkedList(temp2);
	//
	// while (temp2 != null) {
	// Node next = temp.next;
	// temp.next = temp2;
	// temp2 = temp2.next;
	// temp.next.next = next;
	// temp = temp.next.next;
	// }
	//
	// return head;
	// }

}