package com.aravena.arriendolibrosbackend.exception;

public class ModeloNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 8763304709650066112L;

	public ModeloNotFoundException(String message) {
        super(message);
    }
}
