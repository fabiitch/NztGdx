package com.nzt.gdx.scene2D;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class StagePlacementUtils {

	public static void placeCenter(Actor actor, Vector2 pos) {
		actor.setPosition(pos.x - actor.getWidth() / 2, pos.y - actor.getHeight() / 2);
	}

	public static void placeCenter(Actor actor, float x, float y) {
		actor.setPosition(x - actor.getWidth() / 2, y - actor.getHeight() / 2);
	}

	public static void placeCenterX(Actor actor, float x) {
		actor.setX(x - actor.getWidth() / 2);
	}

	public static void placeCenterY(Actor actor, float y) {
		actor.setY(y - actor.getHeight() / 2);
	}
}
