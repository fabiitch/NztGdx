package com.nzt.gdx.b2d.events;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool.Poolable;

public interface B2DEvent extends Poolable {

    void apply(World world, Body body);
}
