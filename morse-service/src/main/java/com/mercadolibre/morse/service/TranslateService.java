package com.mercadolibre.morse.service;


public interface TranslateService {
	
	String decodeBits2Morse(boolean[] binaryArray);
	String translate2Human(String morse)throws Exception;
	String translate2Morse(String human) throws Exception;
}
