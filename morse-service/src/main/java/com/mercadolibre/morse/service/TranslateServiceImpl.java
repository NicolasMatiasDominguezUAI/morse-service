package com.mercadolibre.morse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.morse.entity.Dah;
import com.mercadolibre.morse.entity.Dit;
import com.mercadolibre.morse.entity.Morse;
import com.mercadolibre.morse.entity.MorseDialect;
import com.mercadolibre.morse.entity.Pause;
import com.mercadolibre.morse.entity.Signal;

@Service
public class TranslateServiceImpl implements TranslateService {

	@Override
	public String decodeBits2Morse(boolean[] binaryArray) {
		List<Signal> listSiganls = new ArrayList<>();
		Morse morse = new Morse();

		int lengthDit = Dit.LENGTH; // length dit
		int lengthDah = Dah.LENGTH; // length dah
		int lengthPause = Pause.LENGTH; // length pause

		int errorRange = 0; // error length

		for (int i = 0; i < binaryArray.length; i++) {
			int count = 1;
			boolean startBinary = binaryArray[i];

			while (i + 1 < binaryArray.length && startBinary == binaryArray[i + 1]) {
				count++;
				i++;
			}

			if (startBinary && count > 0 && count < (lengthDah + errorRange)) {
				listSiganls.add(new Dit());
				errorRange = count - lengthDit;

			} else if (startBinary && count >= (lengthDah + errorRange)) {
				listSiganls.add(new Dah());

			} else if (!startBinary && count >= (lengthPause + errorRange)) {
				listSiganls.add(new Pause());
				if (count >= (lengthPause * 2) + errorRange)
					listSiganls.add(new Pause()); // SPACE
			}
		}
		morse.setListSignals(listSiganls);

		return morse.toString();
	}

	@Override
	public String translate2Human(String morse) {
		String[] arrayMorse = morse.split("\\s");
		String text = "";

		for (int i = 0; i < arrayMorse.length; i++) {

			if (arrayMorse[i].equals(MorseDialect.FULLSTOP))
				break; // TEXT END

			text = text + MorseDialect.morseToCaracter(arrayMorse[i]);
		}

		return text;
	}

	@Override
	public String translate2Morse(String text) {
		String[] arrayMorse = text.toUpperCase().split("");
		String morse = "";

		for (int i = 0; i < arrayMorse.length; i++) {
			morse = morse + " " + MorseDialect.caracterToMorse(arrayMorse[i]);
		}

		return morse.trim();
	}
}
