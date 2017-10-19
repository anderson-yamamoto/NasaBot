package com.atto.nasa.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.RobotInstruction;

public class RobotOrientationTest {
	@Test
	public void testAllTurnScenarios(){
		RobotOrientation[] directions           = {RobotOrientation.N, RobotOrientation.W, RobotOrientation.S, RobotOrientation.E};
		RobotOrientation[] expectedLeftResults  = {RobotOrientation.E, RobotOrientation.N, RobotOrientation.W, RobotOrientation.S};
		RobotOrientation[] expectedRightResults = {RobotOrientation.W, RobotOrientation.S, RobotOrientation.E, RobotOrientation.N};
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
