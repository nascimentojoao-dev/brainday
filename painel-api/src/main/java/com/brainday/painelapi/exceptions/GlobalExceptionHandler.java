package com.brainday.painelapi.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(PacienteNotFoundException.class)
	public ResponseEntity<String> handlePacienteNotFoundException(PacienteNotFoundException ex) {
        logger.error("Erro ocorreu: ", ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LaudoNotFoundException.class)
	public ResponseEntity<String> handleLaudoNotFoundException(LaudoNotFoundException ex) {
		logger.error("Erro ocorreu: ", ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PacienteAlreadyExistsException.class)
	public ResponseEntity<String> handlePacienteAlreadyExistsException(PacienteAlreadyExistsException ex){
		logger.error("Erro ocorreu: ", ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}
}
