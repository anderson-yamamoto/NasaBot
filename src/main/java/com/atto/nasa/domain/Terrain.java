package com.atto.nasa.domain;

import com.atto.nasa.domain.exception.InvalidPositionException;

public class Terrain {
	protected int sizeX;
	protected int sizeY;
	protected int posX;
	protected int posY;

	/**
	 * 
	 * @param sizeX Horizontal size for this terrain 
	 * @param sizeY
	 * @param initialPosX Starting X position 
	 * @param initialPosY Starting Y position
	 * @throws InvalidPositionException If the initial position is less than zero or more than or equal to the size specified  
	 */
	public Terrain(int sizeX, int sizeY, int initialPosX, int initialPosY) throws InvalidPositionException{
		if (initialPosX < 0 || initialPosX >= sizeX || initialPosY < 0 || initialPosY >= sizeY)
			throw new InvalidPositionException();
		
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.posX = initialPosX;
		this.posY = initialPosY;
	}
	
	/**
	 * Moves one step on this terrain, on the orientation specified. 
	 * @param
	 * @throws InvalidPositionException if the edges are reached.
	 */
	public void move(RobotOrientation currentOrientation) throws InvalidPositionException{
		this.posX += currentOrientation.getX();
		this.posY += currentOrientation.getY();
		if (this.posX >= sizeX || this.posX < 0 || this.posY >= sizeY || this.posY < 0)
			throw new InvalidPositionException();
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
