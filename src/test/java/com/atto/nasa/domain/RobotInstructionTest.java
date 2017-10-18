package com.atto.nasa.domain;
import java.util.List;


import static org.junit.Assert.*;

import org.junit.Test;

import com.atto.nasa.domain.RobotInstruction;
import com.atto.nasa.domain.exception.RobotInstructionParseException;

public class RobotInstructionTest {
	@Test()
	public void parse() throws RobotInstructionParseException{
		List<RobotInstruction> list = RobotInstruction.parse("LM");
		assertNotNull(list);
		assertEquals(2, list.size());
		assertEquals(RobotInstruction.L, list.get(0));
		assertEquals(RobotInstruction.M, list.get(1));
		
	}
	
	@Test()
	public void parseLowerCase() throws RobotInstructionParseException{
		List<RobotInstruction> list = RobotInstruction.parse("mlr");
		assertNotNull(list);
		assertEquals(3, list.size());
		assertEquals(RobotInstruction.M, list.get(0));
		assertEquals(RobotInstruction.L, list.get(1));
		assertEquals(RobotInstruction.R, list.get(2));
		
	}
	
	@Test(expected=RobotInstructionParseException.class)
	public void parseInvalidInput() throws RobotInstructionParseException{
		RobotInstruction.parse("AXLM");
	}
	
	@Test(expected=RobotInstructionParseException.class)
	public void parseInvalidInputSpace() throws RobotInstructionParseException{
		RobotInstruction.parse("LM ");
	}

}
