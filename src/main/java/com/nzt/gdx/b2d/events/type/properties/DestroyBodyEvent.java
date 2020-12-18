package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class DestroyBodyEvent extends B2DAbstractEvent {

	public DestroyBodyEvent() {
		super(B2DEventsEnum.Destroy);
	}

	@Override
	public void apply(Body body) {
		body = null;
	}

	@Override
	public void doReset() {

	}

}
