package com.atto.nasa.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;
import com.atto.nasa.domain.exception.InvalidPositionException;
import com.atto.nasa.util.SimpleTerrainFormatter;

public class SimpleTerrainFormatterTest {
	private SimpleTerrainFormatter formatter = new SimpleTerrainFormatter();

	@Test
	public void validateFormatting() throws InvalidPositionException {
		assertEquals("(1, 2, W)", formatter.format(new Terrain(3, 3, 1, 2), RobotOrientation.W));
		assertEquals("(0, 2000, N)", formatter.format(new Terrain(3, 3000, 0, 2000), RobotOrientation.N));
		assertEquals("(123456, 2, S)", formatter.format(new Terrain(123457, 3, 123456, 2), RobotOrientation.S));
		assertEquals("(0, 0, E)", formatter.format(new Terrain(3, 3, 0, 0), RobotOrientation.E));
	}
}
