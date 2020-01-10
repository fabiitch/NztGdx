package com.nzt.gdx.b2D.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.b2D.events.B2DEvent;
import com.nzt.gdx.b2D.events.B2DEventsEnum;
import com.nzt.gdx.b2D.events.impl.ActiveBodyEvent;
import com.nzt.gdx.b2D.events.impl.BodyTypeEvent;
import com.nzt.gdx.b2D.events.impl.DestroyBodyEvent;
import com.nzt.gdx.b2D.events.impl.LinearVelocityEvent;
import com.nzt.gdx.b2D.events.impl.TransformBodyEvent;

public class B2DEventFactory {

	@SuppressWarnings("unchecked")
	public static <E extends B2DEvent> E getEvent(B2DEventsEnum eventType) {
		B2DEvent event;
		switch (eventType) {
		case Active:
			event = Pools.obtain(ActiveBodyEvent.class);
			break;
		case BodyType:
			event = Pools.obtain(BodyTypeEvent.class);
			break;
		case Destroy:
			event = Pools.obtain(DestroyBodyEvent.class);
			break;
		case Transform:
			event = Pools.obtain(TransformBodyEvent.class);
			break;
		case LinearVelocity:
			event = Pools.obtain(LinearVelocityEvent.class);
			break;
		default:
			event = null;
			Gdx.app.error("Box2DEvent", eventType + "not impl");
			break;
		}
		return (E) event;
	}

	public static BodyTypeEvent getBodyTypeEvent(BodyType bodyType) {
		BodyTypeEvent event = getEvent(B2DEventsEnum.BodyType);
		event.bodyType = bodyType;
		return event;
	}

	public static ActiveBodyEvent getActiveBodyEvent(boolean active) {
		ActiveBodyEvent event = getEvent(B2DEventsEnum.Active);
		event.active = active;
		return event;
	}

	public static DestroyBodyEvent getDestroyEvent() {
		return getEvent(B2DEventsEnum.Destroy);
	}

	public static TransformBodyEvent getTransformBody(Vector2 position, float roation) {
		TransformBodyEvent event = getEvent(B2DEventsEnum.Transform);
		event.positionTo = position;
		return event;
	}

	public static TransformBodyEvent getTransformBody(float x, float y, float roation) {
		TransformBodyEvent event = getEvent(B2DEventsEnum.Transform);
		event.positionTo = new Vector2(x, y);
		return event;
	}

	public static LinearVelocityEvent getLinearVelocity(Vector2 velocity) {
		LinearVelocityEvent event = getEvent(B2DEventsEnum.LinearVelocity);
		event.velocity = velocity;
		return event;
	}

	public static LinearVelocityEvent getLinearVelocity(float velX, float velY) {
		LinearVelocityEvent event = getEvent(B2DEventsEnum.LinearVelocity);
		event.velocity = new Vector2(velX, velY);
		return event;
	}
}