package com.nzt.gdx.stage;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class StagePlacementUtils {

    public static void placeCenter(Actor actor, Vector2 pos) {
        actor.setPosition(pos.x - actor.getWidth() / 2, pos.y - actor.getWidth() / 2);
    }

    public static void placeCenter(Actor actor, float x, float y) {
        actor.setPosition(x - actor.getWidth() / 2, y - actor.getWidth() / 2);
    }
}
