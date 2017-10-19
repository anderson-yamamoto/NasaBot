package com.atto.nasa.util;

import org.springframework.stereotype.Service;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;

@Service
public class SimpleTerrainFormatter implements TerrainFormatter {

	public String format(Terrain t, RobotOrientation i) {
		return String.format("(%d,%d,%s)", t.getPosX(), t.getPosY(),i);
	}
}
