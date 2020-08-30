package com.mercadolibre.morse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.morse.service.TranslateService;

@RestController
@RequestMapping(value = "/translate")
public class TranslateController {

	@Autowired
	private TranslateService translateService;

	@PostMapping(path = "/decodeBits2Morse")
	public ResponseEntity<String> translateMorse(@RequestBody boolean[] binariArray) {
		String morse = translateService.decodeBits2Morse(binariArray);

		if (morse == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.status(HttpStatus.OK).body(morse);
	}

	@PostMapping(path = "/2text")
	public ResponseEntity<String> translate2Human(@RequestBody String morse) {
		try {
			String texto = translateService.translate2Human(morse);

			if (texto == null)
				return ResponseEntity.notFound().build();

			return ResponseEntity.status(HttpStatus.OK).body(texto);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

	@PostMapping(path = "/2morse")
	public ResponseEntity<String> translate2Morse(@RequestBody String text) throws Exception {
		try {
			String morse = translateService.translate2Morse(text);

			if (morse == null)
				return ResponseEntity.notFound().build();

			return ResponseEntity.status(HttpStatus.OK).body(morse);

		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

}
