package com.atto.nasa.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atto.nasa.domain.RobotInstruction;
import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;
import com.atto.nasa.domain.exception.InvalidPositionException;
import com.atto.nasa.domain.exception.RobotInstructionParseException;

@Service
public class RobotService {
	public String moveRobot(String movement) throws RobotInstructionParseException, InvalidPositionException{
		List<RobotInstruction> list = RobotInstruction.parse(movement);
		Terrain terrain = new Terrain(5,5,0,0);
		RobotOrientation currentOrientation = RobotOrientation.N; 
		for (RobotInstruction instr : list){
			if (RobotInstruction.M.equals(instr))
				terrain.move(currentOrientation);
			else
				currentOrientation = currentOrientation.turn(instr);
		}
		return "(" + terrain.getPosX() + "," + terrain.getPosY()  + "," + currentOrientation +")";
	}
}