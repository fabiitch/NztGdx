package com.nzt.gdx.b2d;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.entitys.concept.AbstractBodyGameObject;

public interface Box2DEvent {

	public void apply(World world, Body body, Array<AbstractBodyGameObject> arrayBodyGO);
}
