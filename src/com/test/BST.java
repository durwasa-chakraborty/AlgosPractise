package com.test;

public class BST {
	Node root;

	public static void main(String[] args) {

		BST tree = new BST();
		tree.root = new Node(4);

		tree.root.left = new Node(3);
		tree.root.right = new Node(5);

		tree.root.left.left = new Node(2);

		TreePrinter.print(tree.root);
		System.out.println("check bst" + checkBST(tree.root));
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
		// BST tree = new BST();
		// tree.insert(5);
		// tree.insert(1);
		// tree.insert(2);
		// tree.insert(4);
		// tree.insert(3);
		//
		// TreePrinter.print(tree.root);
		// //
		// // tree.preorderTraversal();
		// tree.inorderTraversal();
		// // // tree.postorderTraversal();
		// System.out.println("BST.main()");
		//
		// // tree.getKthSmallestElement(2);
		// tree.getKthLargestElement(2);
	}

	public void getKthSmallestElement(int i) {
		current = 0;
		getKthSmallestElement(root, i);
	}

	public void insert(int key) {
		insert(root, key);
	}

	public Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			if (root == null) {
				root = node;
			}
			return node;
		}

		if (node.data < key) {
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

	public static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(" " + root.data);
		inorderTraversal(root.right);
	}

	public void preorderTraversal() {
		System.out.println();
		System.out.println("BST.preorderTraversal()");
		preorderTraversal(root);
	}

	public static void preorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public void postorderTraversal() {
		System.out.println();
		System.out.println("BST.postorderTraversal()");
		postorderTraversal(root);
	}

	public static void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(" " + root.data);
	}

	private static Node sortedLinkedListToBalancedBST(NodeLL head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new Node(head.data);
		}

		// procedure to find middlenode
		NodeLL slowNode = head;
		NodeLL fastNode = head;
		NodeLL prevNode = null;

		while (fastNode != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			prevNode = slowNode;
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}

		// because slowNode means middle node so make it as root
		Node root = new Node(slowNode.data);

		if (prevNode != null) {
			prevNode.next = null;
		}
		NodeLL next = slowNode.next;
		slowNode.next = null;
		// if head node equals slownode that means middlenode is first node so
		// not move forward because already that node created
		if (head != slowNode) {
			root.left = sortedLinkedListToBalancedBST(head);
		}
		root.right = sortedLinkedListToBalancedBST(next);
		return root;

	}

	private static Node sortedArrayToBalancedBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		Node node = new Node(arr[middle]);
		node.left = sortedArrayToBalancedBST(arr, start, middle - 1);
		node.right = sortedArrayToBalancedBST(arr, middle + 1, end);
		return node;
	}

	private static Node sortedLinkedListToBalancedBSTWithouthChangeLL(NodeLL head) {
		int count = LinkedList.getCount(head);

		return sortedLinkedListToBalancedBST(head, 0, count - 1);
	}

	// in linked list class please check there
	private static Node sortedLinkedListToBalancedBSTOptimized(NodeLL head, int start, int end) {

		return null;
	}

	private static Node sortedLinkedListToBalancedBST(NodeLL head, int start, int end) {
		if (head == null) {
			return null;
		}
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		int i = start;
		NodeLL temp = head;
		while (i < middle) {
			temp = temp.next;
			i++;
		}

		Node bst = new Node(temp.data);
		bst.left = sortedLinkedListToBalancedBST(head, start, middle - 1);
		bst.right = sortedLinkedListToBalancedBST(temp.next, middle + 1, end);

		return bst;
	}

	static int current = 0;

	private void getKthSmallestElement(Node root, int k) {
		if (root == null || current > k) {
			return;
		}
		getKthSmallestElement(root.left, k);
		if (++current == k) {
			System.out.println("kth smallest element " + root.data);
		}

		getKthSmallestElement(root.right, k);
	}

	public void getKthLargestElement(int k) {
		current = 0;
		getKthLargestElement(root, k);
	}

	private void getKthLargestElement(Node root, int k) {
		if (root == null || current > k) {
			return;
		}
		getKthLargestElement(root.right, k);
		if (++current == k) {
			System.out.println("kth largest" + root.data);
			return;
		}
		getKthLargestElement(root.left, k);
	}

	static boolean checkBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		boolean checkLeft = checkBST(root.left, min, root.data);
		if (!checkLeft || !(root.data > min && root.data < max)) {
			return false;
		}
		return checkBST(root.right, root.data, max);
	}

	static boolean checkBST(Node root) {

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
