package com.nzt.gdx.box2D.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.box2D.events.Box2DEvent;
import com.nzt.gdx.box2D.events.Box2DEventsEnum;
import com.nzt.gdx.box2D.events.impl.BodyTypeEvent;
import com.nzt.gdx.box2D.events.impl.DestroyBodyEvent;
import com.nzt.gdx.box2D.events.impl.TransformBodyEvent;

public class Box2DEventFactory {

	@SuppressWarnings("unchecked")
	public static <E extends Box2DEvent> E getEvent(Box2DEventsEnum eventType) {
		Box2DEvent event;
		switch (eventType) {
		case TYPE:
			event = Pools.obtain(BodyTypeEvent.class);
			break;
		case DESTROY:
			event = Pools.obtain(DestroyBodyEvent.class);
			break;
		case TRANSFORM:
			event = Pools.obtain(TransformBodyEvent.class);
			break;
		default:
			event = null;
			Gdx.app.error("Box2DEvent", eventType + "not impl");
			break;
		}
		return (E) event;
	}

	public static BodyTypeEvent getBodyTypeEvent(BodyType bodyType) {
		BodyTypeEvent event = getEvent(Box2DEventsEnum.TYPE);
		event.bodyType = bodyType;
		return event;
	}

	public static DestroyBodyEvent getDestroyEvent() {
		return getEvent(Box2DEventsEnum.DESTROY);
	}
}
