package com.atto.nasa.domain.exception;

public class InvalidPositionException extends Exception {
	public InvalidPositionException(){
		super("Attempted to reach an out of bounds position.");
	}
	
	public InvalidPositionException(int x, int y){
		super("Attempted to reach an out of bounds position: " + x + "," + y);
	}
	
	private static final long serialVersionUID = 1L;
}
