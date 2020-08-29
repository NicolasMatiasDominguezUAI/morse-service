package com.mercadolibre.morse.entity;

public class Pause implements Signal{

	public final static int LENGTH = 3;
	
	public String getCode() {
		return " ";
	}
}
