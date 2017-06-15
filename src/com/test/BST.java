package com.test;

public class BST {
	NodeBST root;

	public static void main(String[] args) {

		// LinkedList list = new LinkedList();
		// list.push(12);
		// list.push(11);
		// list.push(10);
		// list.push(9);
		// list.push(8);
		// list.push(7);
		// list.push(6);
		// list.push(5);
		// list.push(4);
		// list.push(3);
		// list.push(2);
		// list.push(1);
		// //
		// // list.printList();
		//// NodeBST bst =
		// sortedLinkedListToBalancedBSTWithouthChangeLL(list.head);
		// // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// // NodeBST bst = sortedArrayToBalancedBST(arr, 0, arr.length - 1);
		// // System.out.println();
		// System.out.println("BST.main() list to balance bst");
		// inorderTraversal(bst);
		BST tree = new BST();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);

		// TreePrinter.print(tree.root);
		//
		// tree.preorderTraversal();
		tree.inorderTraversal();
		// // tree.postorderTraversal();
		System.out.println("BST.main()");
		System.out.println("kth largest in bst " + tree.getKthLargestElement(tree.root, 4));

	}

	public void insert(int key) {
		insert(root, key);
	}

	public NodeBST insert(NodeBST node, int key) {
		if (node == null) {
			node = new NodeBST(key);
			if (root == null) {
				root = node;
			}
			return node;
		}

		if (node.key < key) {
			node.right = insert(node.right, key);
		} else {
			node.left = insert(node.left, key);
		}
		return node;
	}

	// DFS Traversals
	// preorder - root left right
	// inorder - left root right
	// postorder - left right root

	public void inorderTraversal() {
		System.out.println();
		System.out.println("BST.inorderTraversal()");
		inorderTraversal(root);
	}

	public static void inorderTraversal(NodeBST root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(" " + root.key);
		inorderTraversal(root.right);
	}

	public void preorderTraversal() {
		System.out.println();
		System.out.println("BST.preorderTraversal()");
		preorderTraversal(root);
	}

	public static void preorderTraversal(NodeBST root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.key);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public void postorderTraversal() {
		System.out.println();
		System.out.println("BST.postorderTraversal()");
		postorderTraversal(root);
	}

	public static void postorderTraversal(NodeBST root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(" " + root.key);
	}

	private static NodeBST sortedLinkedListToBalancedBST(Node head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new NodeBST(head.data);
		}

		// procedure to find middlenode
		Node slowNode = head;
		Node fastNode = head;
		Node prevNode = null;

		while (fastNode != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			prevNode = slowNode;
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}

		// because slowNode means middle node so make it as root
		NodeBST root = new NodeBST(slowNode.data);

		if (prevNode != null) {
			prevNode.next = null;
		}
		Node next = slowNode.next;
		slowNode.next = null;
		// if head node equals slownode that means middlenode is first node so
		// not move forward because already that node created
		if (head != slowNode) {
			root.left = sortedLinkedListToBalancedBST(head);
		}
		root.right = sortedLinkedListToBalancedBST(next);
		return root;

	}

	private static NodeBST sortedArrayToBalancedBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		NodeBST node = new NodeBST(arr[middle]);
		node.left = sortedArrayToBalancedBST(arr, start, middle - 1);
		node.right = sortedArrayToBalancedBST(arr, middle + 1, end);
		return node;
	}

	private static NodeBST sortedLinkedListToBalancedBSTWithouthChangeLL(Node head) {
		int count = LinkedList.getCount(head);

		return sortedLinkedListToBalancedBST(head, 0, count - 1);
	}

	// in linked list class please check there
	private static NodeBST sortedLinkedListToBalancedBSTOptimized(Node head, int start, int end) {

		return null;
	}

	private static NodeBST sortedLinkedListToBalancedBST(Node head, int start, int end) {
		if (head == null) {
			return null;
		}
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		int i = start;
		Node temp = head;
		while (i < middle) {
			temp = temp.next;
			i++;
		}

		NodeBST bst = new NodeBST(temp.data);
		bst.left = sortedLinkedListToBalancedBST(head, start, middle - 1);
		bst.right = sortedLinkedListToBalancedBST(temp.next, middle + 1, end);

		return bst;
	}

	int current = -1;

	private int getKthLargestElement(NodeBST root, int k) {
		if (root == null) {
			return -1;
		}
		getKthLargestElement(root.left, k);
		if (++current == k) {
			return root.key;
		}

		System.out.print(" " + root.key);
		return getKthLargestElement(root.right, k);
	}
}
