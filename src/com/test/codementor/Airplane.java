package com.test.codementor;

import java.io.IOException;

public class Airplane {

	public Airplane() throws IOException{
		System.out.print("Airplane");
		throw new IOException();
	}
}


