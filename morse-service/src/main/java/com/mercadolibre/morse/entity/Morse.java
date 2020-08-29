package com.mercadolibre.morse.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Morse {

	public Morse() {
	}

	public Morse(String codMorse) {
		String[] arrayCodMorse = codMorse.split("");

		for (int i = 0; i < arrayCodMorse.length; i++) {
			if (arrayCodMorse[i].equals((new Dah()).getCode()))
				listSignals.add(new Dah());
			else if (arrayCodMorse[i].equals((new Dit()).getCode()))
				listSignals.add(new Dah());
			else if (arrayCodMorse[i].equals((new Pause()).getCode()))
				listSignals.add(new Dah());
			else
				listSignals.add(null);
		}
	}

	private List<Signal> listSignals;

	public List<Signal> getListSignals() {
		return listSignals;
	}

	public void setListSignals(List<Signal> listSignals) {
		this.listSignals = listSignals;
	}

	@Override
	public String toString() {
		return listSignals.stream()
				.map(signal -> signal.getCode())
				.collect(Collectors.joining(""))
				.trim();
	}

}
