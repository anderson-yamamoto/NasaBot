package com.atto.nasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atto.nasa.domain.RobotInstruction;
import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;
import com.atto.nasa.domain.exception.InvalidPositionException;
import com.atto.nasa.domain.exception.RobotInstructionParseException;
import com.atto.nasa.util.TerrainFormatter;

/**
 * Service for providing the robot movement coordinates. 
 */
@Service
public class RobotService {
	
	//TODO Load this from a properties file?
	private static final int INITIAL_SIZE_X = 5;
	private static final int INITIAL_SIZE_Y = 5;
	
	@Autowired
	private TerrainFormatter formatter; 
	
	/**
	 * Generates a new terrain, and moves the Robot, starting at position "0,0,N", according to the movement String.
	 * @param movement A string containing only "L", "R" and "M" characters in any case.
	 * @return A formatted String with the Robot position. 
	 * @throws RobotInstructionParseException If movement contains anything other than L,R and M
	 * @throws InvalidPositionException If the robot reaches one of the lower or upper bounds at any stage of its movement.
	 */
	public String moveRobot(String movement) throws RobotInstructionParseException, InvalidPositionException{
		List<RobotInstruction> list = RobotInstruction.parse(movement);
		Terrain terrain = new Terrain(INITIAL_SIZE_X,INITIAL_SIZE_Y,0,0);
		RobotOrientation currentOrientation = RobotOrientation.N; 
		
		//Considered changing this into a lambda, not worth it because of the checked exceptions 
		for (RobotInstruction instr : list){
			if (RobotInstruction.M.equals(instr))
				terrain.move(currentOrientation);
			else
				currentOrientation = currentOrientation.turn(instr);
		}
		return formatter.format(terrain, currentOrientation);
	}
}
