package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class AngularDampingBodyEvent extends B2DAbstractEvent {

	public float angularDamping;

	public AngularDampingBodyEvent() {
		super(B2DEventsEnum.AngularDamping);
	}

	@Override
	public void doReset() {
		this.angularDamping = 0f;
	}

	@Override
	public void apply(Body body) {
		body.setAngularDamping(angularDamping);
	}

}
