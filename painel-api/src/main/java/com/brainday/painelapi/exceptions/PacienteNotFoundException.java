package com.brainday.painelapi.exceptions;

public class PacienteNotFoundException extends RuntimeException{

	public PacienteNotFoundException(Long id) {
		super("Paciente com id: " + id + " não encontrado.");
	}
}
