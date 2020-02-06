package com.nzt.gdx.input.utils;

import com.badlogic.gdx.Gdx;

public abstract class NzInputUtils {

	public static int yTo2DCoords(int y) {
		return Gdx.graphics.getHeight() - 1 - y;
	}
}