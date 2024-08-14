package com.brainday.painelapi.exceptions;

public class LaudoNotFoundException extends RuntimeException{

	public LaudoNotFoundException(Long id) {
		super("Laudo com id: " + id + " não encontrado.");
	}
}
