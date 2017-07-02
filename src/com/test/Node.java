package com.test;

public class Node implements PrintableNode {

	int data;
	Node left, right;

	public Node(int key) {
		this.data = key;
	}

	@Override
	public PrintableNode getLeft() {
		return left;
	}

	@Override
	public PrintableNode getRight() {
		return right;
	}

	@Override
	public String getText() {
		return data + "";
	}

}
