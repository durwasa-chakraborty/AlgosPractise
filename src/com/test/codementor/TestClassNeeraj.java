package com.test.codementor;

public class TestClassNeeraj {

	int a = 0;
	double b = 0;
	float c = 0;
	long d = 0;

	class View {
		public int getId() {
			double e = (a + d) * (c + b);
			return 0;
		}

	}

	class ViewGroup extends View {
		public int getChildCount() {
			return 0;
		}

		public View getChildAt(int index) {
			return null;
		}

	}

	public static void main(String[] args) {

	}

	public static View findViewById(ViewGroup root, int id) {
		int childCount = root.getChildCount();
		if (childCount == 0) {
			return null;
		}

		for (int i = 0; i < childCount; i++) {
			if (root.getChildAt(i).getId() == id) {
				return root.getChildAt(i);
			}
		}

		return null;
	}
}
