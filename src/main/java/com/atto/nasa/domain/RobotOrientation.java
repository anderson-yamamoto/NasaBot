package com.atto.nasa.domain;

/*
 * Enumeration for the Instructions a Nasa Robot can receive
 */
public enum RobotOrientation {
	
	N(0, 0, 1), E(1, 1, 0), S(2, 0, -1),  W(3, -1, 0);
	
	public static RobotOrientation[] directions = new RobotOrientation[]{N,E,S,W};
	
	/*
	 * Pointer to the array of codes 
	 */
	private int code;
	
	/*
	 * Expected movement for this direction on the X plane 
	 */
	private int x;
	
	/*
	 * Expected movement for this direction on the Y plane
	 */
	private int y;
	
	RobotOrientation(int code, int x, int y){
		this.code = code;
		this.x = x;
		this.y = y;
	}
	
	public RobotOrientation turn(RobotInstruction instruction){
		if (N.equals(this)  && RobotInstruction.L.equals(instruction))
			return W;
		else if (W.equals(this) && RobotInstruction.R.equals(instruction))
			return N;
		else
			return directions[code + instruction.getDirection()];
	}
	
	public int getXMovement(){
		return x;
	}
	
	public int getYMovement(){
		return y;
	}
}
