package com.atto.nasa.domain;

import com.atto.nasa.domain.exception.InvalidPositionException;

/**
 * Class for representing a rectangular terrain, with defined borders.
 */
public class Terrain {
	
	//TODO make this a terrain superclass and create a RectangularTerrain specialization if other terrain requirements are required.
	protected int sizeX;
	protected int sizeY;
	protected int posX;
	protected int posY;

	/**
	 * Creates a new terrain instance.
	 * @param sizeX Horizontal size for this terrain. 
	 * @param sizeY Vertical size for this terrain.
	 * @param initialPosX Starting X position.
	 * @param initialPosY Starting Y position.
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
		this.posX += currentOrientation.getXMovement();
		this.posY += currentOrientation.getYMovement();
		if (this.posX >= sizeX || this.posX < 0 || this.posY >= sizeY || this.posY < 0)
			throw new InvalidPositionException();
	}

	/**
	 * Returns the total size on the horizontal plane for this terrain.
	 * @return An integer indicating the size
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Returns the total size on the vertical plane for this terrain.
	 * @return An integer indicating the size
	 */
	public int getSizeY() {
		return sizeY;
	}


	/**
	 * Returns the current position on the horizontal plane for this terrain.
	 * @return An integer indicating the position. Will be between 0 and SizeX - 1 inclusive.
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Returns the current position on the vertical plane for this terrain.
	 * @return An integer indicating the position. Will be between 0 and SizeY - 1 inclusive.
	 */
	public int getPosY() {
		return posY;
	}

}
