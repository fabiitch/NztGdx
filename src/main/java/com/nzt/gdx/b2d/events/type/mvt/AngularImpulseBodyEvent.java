package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class AngularImpulseBodyEvent extends B2DAbstractEvent {

	public float impulse;
	public boolean wake;

	public AngularImpulseBodyEvent() {
		super(B2DEventsEnum.AngularImpulse);
	}


	@Override
	public void doReset() {
		this.impulse = 0f;
		this.wake = false;
	}

	@Override
	public void apply(Body body) {
		body.applyAngularImpulse(impulse, wake);
	}

}
