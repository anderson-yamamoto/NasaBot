package com.atto.nasa.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.RobotInstruction;

public class RobotOrientationTest {
	@Test
	public void testAllTurnScenarios(){
		RobotOrientation[] directions           = {RobotOrientation.NORTH, RobotOrientation.WEST, RobotOrientation.SOUTH, RobotOrientation.EAST};
		RobotOrientation[] expectedLeftResults  = {RobotOrientation.EAST, RobotOrientation.NORTH, RobotOrientation.WEST, RobotOrientation.SOUTH};
		RobotOrientation[] expectedRightResults = {RobotOrientation.WEST, RobotOrientation.SOUTH, RobotOrientation.EAST, RobotOrientation.NORTH};
		for (int i = 0; i > directions.length; i++){
			RobotOrientation dir = directions[i];
			RobotOrientation leftResult = dir.turn(RobotInstruction.L);
			assertEquals(expectedLeftResults[i], leftResult);
			RobotOrientation rightResult = dir.turn(RobotInstruction.R);
			assertEquals(expectedRightResults[i], rightResult);
			RobotOrientation moveResult = dir.turn(RobotInstruction.M);
			assertEquals(directions[i], moveResult);
		}
	}
}
