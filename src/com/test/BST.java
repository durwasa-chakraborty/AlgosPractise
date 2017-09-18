package com.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BST {
	Node root;

	public static void main(String[] args) {

		BST tree = new BST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

		tree.root.left.left.left.left = new Node(16);
		tree.root.left.left.left.right = new Node(17);
		tree.root.left.left.right.left = new Node(18);
		tree.root.left.left.right.right = new Node(19);
		tree.root.left.right.left.left = new Node(20);
		tree.root.left.right.left.right = new Node(21);
		tree.root.left.right.right.left = new Node(22);
		tree.root.left.right.right.right = new Node(23);
		tree.root.right.left.left.left = new Node(24);
		tree.root.right.left.left.right = new Node(25);
		tree.root.right.left.right.left = new Node(26);
		tree.root.right.left.right.right = new Node(27);
		tree.root.right.right.left.left = new Node(28);
		tree.root.right.right.left.right = new Node(29);
		tree.root.right.right.right.left = new Node(30);
		tree.root.right.right.right.right = new Node(31);

		levelOrderTraversalPerfectBinaryTree(tree.root);

		// BST tree = new BST();
		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(7);
		// tree.root.left.right = new Node(6);
		// tree.root.right.left = new Node(5);
		// tree.root.right.right = new Node(4);
		// System.out.println("Spiral order traversal of Binary Tree is ");
		// levelOrderTraversalSpiralFormPractise(tree.root);

		// BST tree = new BST();
		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		//
		// tree.root.left.left = new Node(4);
		// tree.root.left.right = new Node(5);
		// tree.root.right.right = new Node(6);
		// tree.root.left.left.left = new Node(7);
		// tree.root.left.left.right = new Node(8);
		// tree.root.right.right.left = new Node(9);
		// tree.root.right.right.right = new Node(10);
		// inorderTraversal(tree.root);
		// System.out.println();
		// tree.extractLeavesOfBinaryTreePractise(tree.root);
		// checkPrevPointers(head);
		//
		// System.out.println();
		// inorderTraversal(tree.root);

		// BST tree = new BST();
		//
		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		//
		// tree.root.left.left = new Node(4);
		// tree.root.left.right = new Node(5);
		// tree.root.right.right = new Node(6);
		// tree.root.left.left.left = new Node(7);
		// tree.root.left.left.right = new Node(8);
		// // tree.root.right.right.left = new Node(9);
		// tree.root.right.right.right = new Node(10);
		//
		// TreePrinter.print(tree.root);
		//
		// printMaximumLevelSumBinaryTree(tree.root);
		// printMaximumLevelSumBinaryTreeQueue(tree.root);

		//
		// levelOrderTraversalSpiralFormONOptimizedDeque(tree.root);
		// levelOrderTraversalSpiralForm(tree.root);

		// extractLeavesOfBinaryTree(tree.root);
		// printLikeDoublyLinkedList(head);
		// System.out.println();
		// System.out.println("AFter extraction");
		// TreePrinter.print(tree.root);

		// printBottomViewPractise(tree.root);
		// levelOrderTraversalPractise(tree.root);
		// printLeftViewPractise(tree.root);
		// System.out.println("check bst practise " +
		// checkBSTPractise(tree.root));

		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(4);

		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(4);
		// tree.root.left.right = new Node(5);
		// tree.root.right.left = new Node(6);
		// tree.root.right.right = new Node(7);
		// tree.root.right.left.right = new Node(8);
		// tree.root.right.right.right = new Node(9);
		// tree.root.right.right.left = new Node(10);
		// tree.root.right.right.left.right = new Node(11);
		// tree.root.right.right.left.right.right = new Node(12);
		// TreePrinter.print(tree.root);

		// printVerticalOrderHashMap(tree.root);
		// printVerticalOrderLevelOrderTraversal(tree.root);

		// printBottomViewGFG(tree.root);
		// printTopView(tree.root);

		// levelOrderTraversal(tree.root);
		//
		// System.out.println();
		// System.out.println("left view ");
		// printLeftViewOfBinaryTree(tree.root);
		//
		// System.out.println();
		// System.out.println("right view ");
		// printRightViewOfBinaryTree(tree.root);
		//
		// System.out.println();
		// printBottomView(tree.root);
		//
		// // System.out.println();
		// // System.out.println("GFG solution ");
		// // printLeftViewGFG(tree.root, 1);
		// System.out.println("");

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

	public static void printLeftViewOfBinaryTree(Node root) {
		if (root == null) {
			return;
		}
		int heightOfSubTree = heightOfSubTree(root);

		for (int i = 1; i <= heightOfSubTree; i++) {
			printLeftViewAtLevelOfBinaryTree(root, i);
		}

	}

	public static void printRightViewOfBinaryTree(Node root) {
		if (root == null) {
			return;
		}
		int heightOfSubTree = heightOfSubTree(root);

		for (int i = 1; i <= heightOfSubTree; i++) {
			printRightViewAtLevelOfBinaryTree(root, i);
		}

	}

	public static int heightOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}

		int left = heightOfBinaryTree(root.left);
		int right = heightOfBinaryTree(root.right);

		if (left > right) {
			return left + 1;
		}
		return right + 1;
	}

	private static boolean printLeftViewAtLevelOfBinaryTree(Node root, int level) {

		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(" " + root.data);
			return true;
		} else {
			boolean left = printLeftViewAtLevelOfBinaryTree(root.left, level - 1);
			if (left) {
				return true;
			}
			return printLeftViewAtLevelOfBinaryTree(root.right, level - 1);

		}

	}

	private static boolean printRightViewAtLevelOfBinaryTree(Node root, int level) {

		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(" " + root.data);
			return true;
		} else {
			boolean left = printRightViewAtLevelOfBinaryTree(root.right, level - 1);
			if (left) {
				return true;
			}
			return printRightViewAtLevelOfBinaryTree(root.left, level - 1);

		}

	}

	public static void levelOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		int heightOfSubTree = heightOfSubTree(root);

		for (int i = 1; i <= heightOfSubTree; i++) {
			printAGivenLevel(root, i);
		}
	}

	public static void printAGivenLevel(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(" " + root.data);
		} else if (level > 1) {
			printAGivenLevel(root.left, level - 1);
			printAGivenLevel(root.right, level - 1);
		}

	}

	public static int heightOfSubTree(Node root) {
		if (root == null) {
			return 0;
		}

		int lHeight = heightOfSubTree(root.left);
		int rHeight = heightOfSubTree(root.right);

		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
	}

	private static int maxLevelLeftView = 0;

	public static void printLeftViewGFG(Node root, int level) {

		if (root == null) {
			return;
		}

		if (maxLevelLeftView < level) {
			System.out.print(" " + root.data);
			maxLevelLeftView = level;
		}

		printLeftViewGFG(root.left, level + 1);
		printLeftViewGFG(root.right, level + 1);

	}

	public static void printBottomView(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int heightOfBinaryTree = heightOfBinaryTree(root);
		for (int i = 1; i <= heightOfBinaryTree; i++) {
			putDistanceForBottomNodes(root, map, 0, i);
		}

		System.out.println("bottom view");
		printMap(map);
	}

	private static void printMap(Map<Integer, Integer> map) {
		Set<Entry<Integer, Integer>> set = map.entrySet();

		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		// Traverse the map elements using the iterator.
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}

	public static void putDistanceForBottomNodes(Node root, TreeMap<Integer, Integer> map, int distanceFromRoot,
			int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			map.put(distanceFromRoot, root.data);
			return;
		}

		putDistanceForBottomNodes(root.left, map, distanceFromRoot - 1, level - 1);
		putDistanceForBottomNodes(root.right, map, distanceFromRoot + 1, level - 1);
	}

	public static void printBottomViewGFG(Node root) {
		Queue<Node> queue = new java.util.LinkedList<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		queue.add(root);
		root.horizontalDistance = 0;

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			treeMap.put(node.horizontalDistance, node.data);

			if (node.left != null) {
				node.left.horizontalDistance = node.horizontalDistance - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.horizontalDistance = node.horizontalDistance + 1;
				queue.add(node.right);
			}
		}

		System.out.println("bottom view");
		System.out.println();
		printMap(treeMap);
	}

	public static void printTopView(Node root) {

		Queue<Node> queue = new java.util.LinkedList<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		queue.add(root);
		root.horizontalDistance = 0;

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (!treeMap.containsKey(node.horizontalDistance)) {
				treeMap.put(node.horizontalDistance, node.data);
			}

			if (node.left != null) {
				node.left.horizontalDistance = node.horizontalDistance - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.horizontalDistance = node.horizontalDistance + 1;
				queue.add(node.right);
			}
		}

		System.out.println("top view");
		System.out.println();
		printMap(treeMap);
	}

	public static void printVerticalOrderHashMap(Node root) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		printVerticalOrderHashMap(root, map, 0);

		System.out.println("vertical order");
		printMapArrayList(map);
	}

	private static void printMapArrayList(Map<Integer, ArrayList<Integer>> map) {
		Iterator<Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println();
			ArrayList<Integer> value = iterator.next().getValue();
			for (int i = 0; i < value.size(); i++) {
				System.out.print(" " + value.get(i));
			}

		}
	}

	private static void printVerticalOrderHashMap(Node root, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
		if (root == null) {
			return;
		}

		if (map.containsKey(hd)) {
			map.get(hd).add(root.data);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(hd, list);
		}

		printVerticalOrderHashMap(root.left, map, hd - 1);
		printVerticalOrderHashMap(root.right, map, hd + 1);
	}

	public static void printVerticalOrderLevelOrderTraversal(Node root) {
		Queue<Node> queue = new java.util.LinkedList<>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		root.horizontalDistance = 1;
		queue.add(root);
		int hd = 0;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			hd = node.horizontalDistance;
			if (map.containsKey(hd)) {
				map.get(hd).add(node.data);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(node.data);
				map.put(hd, list);
			}

			if (node.left != null) {
				node.left.horizontalDistance = hd - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.horizontalDistance = hd + 1;
				queue.add(node.right);
			}

		}
		System.out.println();
		System.out.println("vertical order level order traversal");
		printMapArrayList(map);
	}

	private static boolean checkBSTPractise(Node root) {
		return checkBSTPractise(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBSTPractise(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data > min && root.data < max) {
			boolean left = checkBSTPractise(root.left, min, root.data);
			if (left) {
				return checkBSTPractise(root.right, root.data, max);
			}

		}

		return false;

	}

	private void insertInBSTPractise(Node element) {
		if (root == null) {
			root = element;
			return;
		}
		insertInBSTPractise(root, element);
	}

	private void insertInBSTPractise(Node node, Node element) {

		if (node.data < element.data) {
			if (node.right != null) {
				insertInBSTPractise(node.right, element);
			} else {
				node.right = element;
			}
		} else {

			if (node.left != null) {
				insertInBSTPractise(node.left, element);
			} else {
				node.left = element;
			}
		}

	}

	public static int heightOfBTPractise(Node root, int height) {
		if (root == null) {
			return height;
		}
		int heightL = heightOfBTPractise(root.left, height + 1);
		int heightR = heightOfBTPractise(root.right, height + 1);

		return heightL > heightR ? heightL : heightR;
	}

	public static void levelOrderTraversalPractise(Node root) {
		int height = heightOfBTPractise(root, 0);

		for (int i = 1; i <= height; i++) {
			printAGivenLevelPractise(root, i);
			System.out.println();
		}

	}

	private static void printAGivenLevelPractise(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(" " + root.data);
			return;
		}

		printAGivenLevel(root.left, level - 1);
		printAGivenLevel(root.right, level - 1);
	}

	public static void printLeftViewPractise(Node root) {
		int height = heightOfBTPractise(root, 0);

		for (int i = 1; i <= height; i++) {
			printLeftOneForALevel(root, i);
			System.out.println();
		}

	}

	private static boolean printLeftOneForALevel(Node root, int level) {
		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(" " + root.data);
			return true;
		}

		boolean isLeft = printLeftOneForALevel(root.left, level - 1);
		if (isLeft) {
			return true;
		}
		return printLeftOneForALevel(root.right, level - 1);
	}

	private static void printBottomViewPractise(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int height = heightOfBTPractise(root, 0);
		for (int i = 1; i <= height; i++) {
			printBottomViewPractise(root, 0, map, i);
		}
		printMap(map);
	}

	private static void printBottomViewPractise(Node root, int vLine, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			map.put(vLine, root.data);
			return;
		}
		printBottomViewPractise(root.left, vLine - 1, map, level - 1);
		printBottomViewPractise(root.right, vLine + 1, map, level - 1);
	}

	private static Node head;
	private static Node dll;

	private static boolean extractLeavesOfBinaryTree(Node root) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		boolean isLeafNode = extractLeavesOfBinaryTree(root.left);
		if (isLeafNode) {
			if (dll == null) {
				dll = root.left;
				head = dll;
			} else {
				dll.right = root.left;
				dll.right.left = dll;
				dll = dll.right;
			}
			root.left = null;
		}

		isLeafNode = extractLeavesOfBinaryTree(root.right);
		if (isLeafNode) {
			if (dll == null) {
				dll = root.right;
				head = dll;
			} else {
				dll.right = root.right;
				dll.right.left = dll;
				dll = dll.right;
			}
			root.right = null;
		}

		return false;
	}

	public static void printLikeDoublyLinkedList(Node head) {
		if (head == null) {
			System.out.println("DoubleLinkedList.print() empty");
			return;
		}
		Node tnode = head;
		while (tnode != null) {
			System.out.println(tnode.data + " " + "prev is : " + (tnode.left == null ? null : tnode.left.data));
			tnode = tnode.right;
		}
	}

	public static void levelOrderTraversalSpiralForm(Node root) {
		int height = heightOfBinaryTree(root);
		for (int i = 1; i <= height; i++) {
			if (i % 2 == 0) {
				printAGivenLevelLeft(root, i);
			} else {
				printAGivenLevelRight(root, i);
			}
			System.out.println();
		}
	}

	private static void printAGivenLevelRight(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(" " + root.data);
			return;
		}

		printAGivenLevelRight(root.right, level - 1);
		printAGivenLevelRight(root.left, level - 1);
	}

	private static void printAGivenLevelLeft(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(" " + root.data);
			return;
		}

		printAGivenLevelLeft(root.left, level - 1);
		printAGivenLevelLeft(root.right, level - 1);
	}

	private static void levelOrderTraversalSpiralFormONOptimized(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				Node item = s1.pop();
				System.out.print(" " + item.data);
				if (item.right != null) {
					s2.push(item.right);
				}

				if (item.left != null) {
					s2.push(item.left);
				}
			}

			while (!s2.isEmpty()) {
				Node item = s2.pop();
				System.out.print(" " + item.data);

				if (item.left != null) {
					s1.push(item.left);
				}
				if (item.right != null) {
					s1.push(item.right);
				}
			}

		}
	}

	private static void levelOrderTraversalSpiralFormONOptimizedDeque(Node root) {
		Deque<Node> dequeue = new java.util.LinkedList<>();
		dequeue.addFirst(root);
		boolean isReverseLevel = true;
		while (!dequeue.isEmpty()) {

			int count = dequeue.size();
			while (count > 0) {
				if (isReverseLevel) {
					Node node = dequeue.removeLast();
					System.out.print(" " + node.data);

					if (node.right != null) {
						dequeue.addFirst(node.right);
					}

					if (node.left != null) {
						dequeue.addFirst(node.left);
					}

				} else {
					Node node = dequeue.removeFirst();
					System.out.print(" " + node.data);

					if (node.left != null) {
						dequeue.addLast(node.left);
					}

					if (node.right != null) {
						dequeue.addLast(node.right);
					}
				}

				count--;
			}
			isReverseLevel = !isReverseLevel;
		}
	}

	public static void printMaximumLevelSumBinaryTreeQueue(Node root) {
		if (root == null) {
			System.out.println("empty tree");
			return;
		}

		Queue<Node> queue = new java.util.LinkedList<>();
		root.level = 1;
		queue.add(root);
		int max = Integer.MIN_VALUE, level = -1;
		while (!queue.isEmpty()) {
			int count = queue.size();
			int sum = 0;
			int currLevel = 0;
			while (count-- != 0) {
				Node node = queue.remove();
				sum += node.data;
				currLevel = node.level;
				if (node.left != null) {
					node.left.level = node.level + 1;
					queue.add(node.left);
				}

				if (node.right != null) {
					node.right.level = node.level + 1;
					queue.add(node.right);
				}
			}

			if (sum > max) {
				max = sum;
				level = currLevel;
			}
		}

		System.out.println(" Max Sum is : " + max + " level is : " + level);
	}

	public static void printMaximumLevelSumBinaryTree(Node root) {
		if (root == null) {
			System.out.println("empty tree");
			return;
		}

		int height = heightOfBinaryTreeTest(root);

		int sum, max = Integer.MIN_VALUE, level = -1;

		for (int i = 1; i <= height; i++) {
			sum = getSumAtLevel(root, i);
			if (sum > max) {
				max = sum;
				level = i;
			}

		}

		System.out.println(" Max Sum is : " + max + " level is : " + level);
	}

	private static int getSumAtLevel(Node root, int level) {
		if (root == null) {
			return 0;
		}

		if (level == 1) {
			return root.data;
		}
		int sum = 0;
		sum += getSumAtLevel(root.left, level - 1);
		sum += getSumAtLevel(root.right, level - 1);
		return sum;
	}

	public static int heightOfBinaryTreeTest(Node root) {

		if (root == null) {
			return 0;
		}

		int heightLeft = heightOfBinaryTree(root.left);
		int heightRight = heightOfBinaryTree(root.right);
		if (heightLeft > heightRight) {
			return heightLeft + 1;
		}
		return heightRight + 1;
	}

	Node currentElement = null;

	public Node extractLeavesOfBinaryTreePractise(Node root) {

		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			if (head == null) {
				head = root;
				currentElement = head;
				currentElement.left = null;
			} else {
				currentElement.right = root;
				root.left = currentElement;
				currentElement = currentElement.right;

			}
			return null;
		}
		root.left = extractLeavesOfBinaryTreePractise(root.left);
		root.right = extractLeavesOfBinaryTreePractise(root.right);
		return root;
	}

	private static void checkPrevPointers(Node head) {
		System.out.println("BST.checkPrevPointers()");
		System.out.println();
		System.out.print(head.data + " ");
		while (head.right != null) {
			head = head.right;
			System.out.print(head.data + " ");
		}

		System.out.println("");
		System.out.println("BST.checkPrevPointers() ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.left;
		}
	}

	private static void levelOrderTraversalSpiralFormPractise(Node root) {
		Node temp = root;
		Deque<Node> deque = new java.util.LinkedList<Node>();
		deque.addLast(temp);
		boolean isReverseLevel = true;
		while (!deque.isEmpty()) {

			int size = deque.size();

			while (size > 0) {
				if (isReverseLevel) {
					Node pollLast = deque.pollLast();
					System.out.print(" " + pollLast.data);
					if (pollLast.right != null) {
						deque.addFirst(pollLast.right);
					}
					if (pollLast.left != null) {
						deque.addFirst(pollLast.left);
					}
				} else {
					Node pollFirst = deque.pollFirst();
					System.out.print(" " + pollFirst.data);
					if (pollFirst.left != null) {
						deque.addLast(pollFirst.left);
					}
					if (pollFirst.right != null) {
						deque.addLast(pollFirst.right);
					}

				}
				size--;
			}
			isReverseLevel = !isReverseLevel;
		}
	}

	private static void levelOrderTraversalPractise2(Node root) {
		Queue<Node> queue = new java.util.LinkedList<>();
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			System.out.print(" " + poll.data);

			if (poll.left != null) {
				queue.add(poll.left);
			}

			if (poll.right != null) {
				queue.add(poll.right);
			}

		}

	}

	private static void levelOrderTraversalPerfectBinaryTree(Node root) {
		Deque<Node> dequeue = new java.util.LinkedList<>();
		dequeue.addFirst(root);
		while (!dequeue.isEmpty()) {
			int count = dequeue.size();
			while (count > 0) {
				Node nodeA = dequeue.poll();
				Node nodeB = dequeue.poll();

				System.out.print(" " + (nodeA != null ? nodeA.data : "") + " " + (nodeB != null ? nodeB.data : ""));

				if (nodeA != null && nodeA.left != null) {
					dequeue.addLast(nodeA.left);
				}

				if (nodeB != null && nodeB.right != null) {
					dequeue.addLast(nodeB.right);
				}

				if (nodeA != null && nodeA.right != null) {
					dequeue.addLast(nodeA.right);
				}

				if (nodeB != null && nodeB.left != null) {
					dequeue.addLast(nodeB.left);
				}

				count -= 2;
			}

		}

	}

}
