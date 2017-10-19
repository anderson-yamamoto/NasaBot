package com.atto.nasa.util;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;

public interface TerrainFormatter {
	public String format(Terrain t, RobotOrientation i);
}
