package com.atto.nasa.domain;

/*
 * Enumeration for the Instructions a Nasa Robot can receive
 */
public enum RobotOrientation {
	
	NORTH(0, 0, 1), EAST(1, 1, 0), SOUTH(2, 0, -1),  WEST(3, -1, 0);
	
	public static RobotOrientation[] directions = new RobotOrientation[]{NORTH,EAST,SOUTH,WEST};
	
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
		if (NORTH.equals(this)  && RobotInstruction.L.equals(instruction))
			return WEST;
		else if (WEST.equals(this) && RobotInstruction.R.equals(instruction))
			return NORTH;
		else
			return directions[code + instruction.getDirection()];
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
