package com.test;

/* Linked list Node */
 class NodeLL {
	public int data;
	public char textData;
	public NodeLL next;
	public NodeLL random;
	public int x, y;

	/**
	 * @param x
	 * @param y
	 */
	public NodeLL(int x, int y) {
		this.x = x;
		this.y = y;
	}

	NodeLL(int d) {
		setData(d);
		setNext(null);
	}

	NodeLL(char d) {
		textData = d;
		setNext(null);
	}

	@Override
	public String toString() {
		NodeLL cur = this;
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

	public NodeLL getNext() {
		return next;
	}

	public void setNext(NodeLL next) {
		this.next = next;
	}

	public NodeLL getPrev() {
		return random;
	}

	public void setPrev(NodeLL prev) {
		this.random = prev;
	}
}