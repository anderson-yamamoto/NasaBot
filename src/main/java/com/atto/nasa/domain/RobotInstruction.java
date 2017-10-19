package com.atto.nasa.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.atto.nasa.domain.exception.RobotInstructionParseException;

/**
 * Enumeration for the Instructions a Nasa Robot can receive
 */
public enum RobotInstruction {
	/**
	 * Indicates the Robot should turn left, resulting on a counter clockwise spin.
	 */
	L(-1),
	/**
	 * Indicates the Robot should turn right, resulting on a clockwise spin.
	 */
	R(1),
	/**
	 * Indicates the robot should move forward one space, to whichever direction he's pointing to..
	 */
	M(0);
	
	private static Predicate<String> regex = Pattern.compile("^[lLrRmM]+$").asPredicate();
	
	private int direction;
	
	private RobotInstruction(int direction)
	{
		this.direction = direction;
	}
	
	/**
	 * Parses a string into a series of RobotInstruction values.
	 * @param original The string to be parsed
	 * @return A list of RobotInstruction, with the commands in the order they appear on the original string
	 * @throws RobotInstructionParseException if the string contains any characters that are not parseable into the enumeration values
	 */
	public static List<RobotInstruction> parse(String original) throws RobotInstructionParseException{
		if (!regex.test(original))
			throw new RobotInstructionParseException("Invalid string:" + original);
		
		ArrayList<RobotInstruction> list = new ArrayList<RobotInstruction>(original.length());
		for (char c : original.toUpperCase().toCharArray()){
			RobotInstruction value = parse(c);
			if (value != null)
				list.add(value);
		}
		return list;
	}
	
	private static RobotInstruction parse(Character c){
		return valueOf(c.toString());
	}

	/**
	 * Defines whether this Instruction is clockwise (1) or counter clockwise (-1), or neither (0)
	 * @return An integer, possible values: 0, 1, -1.
	 */
	public int getDirection() {
		return direction;
	}
}
