package com.atto.nasa.service;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.BeforeClass;
import org.junit.Test;

import com.atto.nasa.controller.RobotService;
import com.atto.nasa.domain.exception.InvalidPositionException;
import com.atto.nasa.domain.exception.RobotInstructionParseException;
import com.atto.nasa.util.SimpleTerrainFormatter;

public class RobotServiceTest {

	private static RobotService robotService = new RobotService();

	@BeforeClass
	public static void setup() {
		//Using this as Mockito is not on the lib list
		try {
			Field field = RobotService.class.getDeclaredField("formatter");
			field.setAccessible(true);
			field.set(robotService, new SimpleTerrainFormatter());
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Test
	public void moveValidPositions() throws InvalidPositionException, RobotInstructionParseException {
		assertEquals("(0, 2, E)", robotService.moveRobot("MMR"));
		assertEquals("(2, 0, S)", robotService.moveRobot("MMRMMRMM"));
		assertEquals("(0, 2, W)", robotService.moveRobot("MML"));
		assertEquals("(0, 2, W)", robotService.moveRobot("MML"));
	}
	
	@Test(expected=RobotInstructionParseException.class)
	public void moveInvalidInstruction() throws InvalidPositionException, RobotInstructionParseException {
		robotService.moveRobot("AAA");
	}
	
	@Test(expected=InvalidPositionException.class)
	public void moveInvalidPosition() throws InvalidPositionException, RobotInstructionParseException {
		robotService.moveRobot("MMMMMMMMMMMMMMMMMMMMMMMM");
	}
}
