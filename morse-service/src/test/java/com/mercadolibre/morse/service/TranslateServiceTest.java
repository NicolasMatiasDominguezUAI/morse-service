package com.mercadolibre.morse.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TranslateServiceTest {

	@Autowired
	private TranslateService translateService;

	
	@Test
	public void whenInputPulses_ThenMorse() {
		boolean[] binaryArray = {
				false,false,false,false,false,false,false,false,
				true,true,
				false,
				true,true,
				false,
				true,true,
				false,false,
				true,true,true,
				false,false,false,false,false,
				true,true,true,true,true,true,
				false,false,false,
				true,true,true,true,true,true,
				false,false,
				true,true,true,true,true,true,
				false,false,false,false,false,false,false,
				true,true,true,
				false,
				true,true,true,true,true,true,true,true,
				false,
				true,true,true,
				false,
				true,true,true,
				false,false,false,false,false,false,false,
				true,true,
				false,false,false,
				true,true,true,true,true,true,
				false,false,false,false,false,false,false, //pause *2
				true,true,true,true,true,true,
				false,false,
				true,true,true,true,true,true,
				false,false,false,false,false,
				true,true,
				false,false,false,false,
				true,true,
				false,
				true,true,true,true,true,true,true,true,
				false,
				true,true,true,
				false,
				true,true,true,
				false,false,false,false,false,false,
				true,true,
				false,
				true,true,true,
				false,false,false,false,false,false,false,false,
				false,false,false
				};

		String morse = translateService.decodeBits2Morse(binaryArray);
		String morseAssert = ".... --- .-.. .-  -- . .-.. ..";
		
		Assertions.assertTrue(morse.equals(morseAssert));
	}

	
	@Test
	public void whenInputMorse_ThenTextHuman() throws Exception{
		String morse = ".... --- .-.. .-  -- . .-.. ..";

		String textHuman = translateService.translate2Human(morse);
		String textHumanAssert = "HOLA MELI";

		Assertions.assertTrue(textHuman.equals(textHumanAssert));
	}
	
	@Test
	public void whenInputTextHuman_ThenMorse() throws Exception{
		String text = "HOLA MELI";

		String morse = translateService.translate2Morse(text);
		String morseAssert = ".... --- .-.. .-  -- . .-.. ..";

		Assertions.assertTrue(morse.equals(morseAssert));
	}
}
