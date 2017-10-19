package com.atto.nasa.domain;

/**
 * Enumeration for the Instructions a Nasa Robot can receive
 */
public enum RobotOrientation {

	N(0, 0, 1), E(1, 1, 0), S(2, 0, -1), W(3, -1, 0);

	private static final RobotOrientation[] directions = new RobotOrientation[] { N, E, S, W };

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

	RobotOrientation(int code, int x, int y) {
		this.code = code;
		this.x = x;
		this.y = y;
	}

	/**
	 * Indicates the new Orientation for a RobotOrientation after turning to the
	 * indicated direction
	 * 
	 * @param instruction
	 *            The instruction to which the new Orientation will be
	 *            generated. If "M", same Orientation will be returned. If "L",
	 *            then the next counterclockwise orientation will be returned,
	 *            and if "R", next clockwise orientation.
	 * @return A new RobotOrientation enum indicating the direction the Robot
	 *         will be facing after executing the instruction passed.
	 */
	public RobotOrientation turn(RobotInstruction instruction) {
		if (N.equals(this) && RobotInstruction.L.equals(instruction))
			return W;
		else if (W.equals(this) && RobotInstruction.R.equals(instruction))
			return N;
		else
			return directions[code + instruction.getDirection()];
	}

	/**
	 * Indicates what action on the X plane a RobotInstruction.M will result for this RobotOrientation value.
	 * @return An integer, 0, 1 or -1 
	 */
	public int getXMovement() {
		return x;
	}

	/**
	 * Indicates what action on the Y plane a RobotInstruction.M will result for this RobotOrientation value.
	 * @return An integer, 0, 1 or -1 
	 */
	public int getYMovement() {
		return y;
	}
}
