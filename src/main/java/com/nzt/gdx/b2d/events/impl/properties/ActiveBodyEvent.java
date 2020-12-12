package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class ActiveBodyEvent implements B2DEvent {

	public boolean active;

	@Override
	public void reset() {
		active = false;
	}

	@Override
	public void apply(Body body) {
		body.setActive(active);
	}

}
