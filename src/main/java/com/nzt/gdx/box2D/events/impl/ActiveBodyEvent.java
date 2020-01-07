package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.DestructionListener;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.B2DEvent;

public class ActiveBodyEvent implements B2DEvent {

	public boolean active;

	@Override
	public void reset() {
		active = false;
	}

	@Override
	public void apply(World world, Body body) {
		body.setActive(active);
		world.setDestructionListener(new DestructionListener() {
		});
	}

}
