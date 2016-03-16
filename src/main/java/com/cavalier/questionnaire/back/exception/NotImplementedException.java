package com.cavalier.questionnaire.back.exception;

public class NotImplementedException extends Exception {

	/**
	* 
	*/
	private static final long serialVersionUID = 7466202671298436761L;

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(String message, NotImplementedException cause) {
		super(message, cause);
	}
}
