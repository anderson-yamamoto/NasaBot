package com.atto.nasa.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.atto.nasa.domain.exception.InvalidPositionException;

public class TerrainTest {
	private static final int SIZEX = 3;
	private static final int SIZEY = 3;

	@Test
	public void createValidTerrain() throws InvalidPositionException{
		Terrain t = new Terrain(SIZEX, SIZEY, 0, 0);
		assertNotNull(t);
		assertEquals(SIZEX, t.getSizeX());
		assertEquals(SIZEY, t.getSizeY());
		assertEquals(0, t.getPosX());
		assertEquals(0, t.getPosY());
	}
	
	@Test()
	public void createValidTerrainHighestBounds() throws InvalidPositionException{
		Terrain t = new Terrain(SIZEX, SIZEY, SIZEX - 1, SIZEY - 1);
		assertNotNull(t);
		assertEquals(SIZEX, t.getSizeX());
		assertEquals(SIZEY, t.getSizeY());
		assertEquals(SIZEX - 1, t.getPosX());
		assertEquals(SIZEY - 1, t.getPosY());
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainNegativeX() throws InvalidPositionException{
		new Terrain(-1, SIZEY, 0, 0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainNegativeY() throws InvalidPositionException{
		new Terrain(SIZEX, -1, 0, 0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainInitialPositionXTooLarge() throws InvalidPositionException{
		new Terrain(SIZEX, SIZEY, SIZEX, 0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainInitialPositionYTooLarge() throws InvalidPositionException{
		new Terrain(SIZEX, SIZEY, 0, SIZEY);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainNegativeInitialPositionX() throws InvalidPositionException{
		new Terrain(SIZEX, SIZEY, -1, 0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void createInvalidTerrainNegativeInitialPositionY() throws InvalidPositionException{
		new Terrain(SIZEX, SIZEY, 0, -1);
	}
	
	@Test
	public void moveValidPositionNorth() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, 1);
		t.move(RobotOrientation.NORTH);
		assertEquals(1, t.getPosX());
		assertEquals(2, t.getPosY());
	}
	
	@Test
	public void moveValidPositionWest() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, 1);
		t.move(RobotOrientation.WEST);
		assertEquals(0, t.getPosX());
		assertEquals(1, t.getPosY());
	}
	
	@Test
	public void moveValidPositionEast() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, 1);
		t.move(RobotOrientation.EAST);
		assertEquals(2, t.getPosX());
		assertEquals(1, t.getPosY());
	}
	
	@Test
	public void moveValidPositionSouth() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, 1);
		t.move(RobotOrientation.SOUTH);
		assertEquals(1, t.getPosX());
		assertEquals(0, t.getPosY());
	}
	
	@Test(expected=InvalidPositionException.class)
	public void moveInvalidPositionNorth() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, SIZEY - 1);
		t.move(RobotOrientation.NORTH);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void moveInvalidPositionWest() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 0, 1);
		t.move(RobotOrientation.WEST);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void moveInvalidPositionEast() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, SIZEX - 1, 1);
		t.move(RobotOrientation.EAST);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void moveInvalidPositionSouth() throws InvalidPositionException{
		Terrain t  = new Terrain(SIZEX, SIZEY, 1, 0);
		t.move(RobotOrientation.SOUTH);
	}
}
