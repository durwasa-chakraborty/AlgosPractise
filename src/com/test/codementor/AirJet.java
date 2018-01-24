package com.test.codementor;

import java.io.IOException;

public class AirJet {
	interface test {
		void method();
	}

	public static void main(String[] args) {
		test2 t = new test3();
		((test3) t).method1();

	}

	public static class test2 {
		public void method() {
			System.out.println("method in test 2");
		}

		public void method1() {

		}
	}

	public static class test3 extends test2 implements test {
		@Override
		public void method() {
			super.method();
		}
	}
}