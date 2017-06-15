package com.test;

public class NodeBST implements PrintableNode {

	int key;
	NodeBST left, right;

	public NodeBST(int key) {
		this.key = key;
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
		return key + "";
	}

}
