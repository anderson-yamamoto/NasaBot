package com.atto.nasa.util;

import org.springframework.stereotype.Service;

import com.atto.nasa.domain.RobotOrientation;
import com.atto.nasa.domain.Terrain;

@Service
public class SimpleTerrainFormatter implements TerrainFormatter {

	private static final String SEPARATOR = ",";

	public String format(Terrain t, RobotOrientation i) {
		return new StringBuilder(10).append("(").append(t.getPosX()).append(SEPARATOR).append(t.getPosY())
				.append(SEPARATOR).append(i.name()).append(")").toString();
	}
}
