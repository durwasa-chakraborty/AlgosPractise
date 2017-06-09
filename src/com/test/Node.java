package com.test;

/* Linked list Node */
 class Node {
	public int data;
	public char textData;
	public Node next;
	public Node random;
	public int x, y;

	/**
	 * @param x
	 * @param y
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Node(int d) {
		setData(d);
		setNext(null);
	}

	Node(char d) {
		textData = d;
		setNext(null);
	}

	@Override
	public String toString() {
		Node cur = this;
		String str = "";

		while (cur != null) {
			str += cur.getData() + "->";
			cur = cur.getNext();
		}

		return str;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return random;
	}

	public void setPrev(Node prev) {
		this.random = prev;
	}
}