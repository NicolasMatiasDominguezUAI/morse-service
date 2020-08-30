package com.mercadolibre.morse.entity;

import java.util.HashMap;

public class MorseDialect {

	public final static String FULLSTOP = ".-.-.-";// End of morse message

	private static HashMap<String, String> MORSE = new HashMap<>();
	private static HashMap<String, String> CARACTER = new HashMap<>();

	private static final String COD_CARACTER[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", null, " " };

	private static final String COD_MORSE[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", FULLSTOP,
			"" };

	static {
		for (int i = 0; i < COD_MORSE.length; i++) {
			MORSE.put(COD_MORSE[i], COD_CARACTER[i]);
			CARACTER.put(COD_CARACTER[i], COD_MORSE[i]);
		}
	}

	public static String caracterToMorse(String caracter) throws Exception {
		if (CARACTER.containsKey(caracter)) {
			return CARACTER.get(caracter);
		} else {
			throw new Exception("El caracter '" + caracter + "' no pertenece al dialecto morse");
		}
	}

	public static String morseToCaracter(String morse) throws Exception {
		if (MORSE.containsKey(morse)) {
			return MORSE.get(morse);
		} else {
			throw new Exception("El codigo morse '" + morse + "' no pertenece al dialecto");
		}
	}
}
