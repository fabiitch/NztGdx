package com.nzt.gdx.box2D.events;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool.Poolable;

public interface Box2DEvent extends Poolable {

	public void apply(World world, Body body);
}
