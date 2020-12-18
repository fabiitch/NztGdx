package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class ActiveBodyEvent extends B2DAbstractEvent {

	public boolean active;

	public ActiveBodyEvent() {
		super(B2DEventsEnum.Active);
	}

	@Override
	public void doReset() {
		active = false;
	}

	@Override
	public void apply(Body body) {
		body.setActive(active);
	}

}
