package com.atto.nasa.domain.exception;

/**
 * Exception thrown when a RobotInstruction cannot be parsed.
 */
public class RobotInstructionParseException extends Exception {

	public RobotInstructionParseException(String message) {
		super(message);
	}

	
	private static final long serialVersionUID = 1L;

}
