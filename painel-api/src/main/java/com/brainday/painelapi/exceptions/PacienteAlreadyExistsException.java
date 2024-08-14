package com.brainday.painelapi.exceptions;

public class PacienteAlreadyExistsException extends RuntimeException{

	    public PacienteAlreadyExistsException(String nome) {
	        super("Paciente com o nome: " + nome + " já existe.");
	    }
}
