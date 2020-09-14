package com.nzt.gdx.ashley.components.physx;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.components.base.BaseComponent;
import com.nzt.gdx.ashley.systems.B2DSystem;
import com.nzt.gdx.ashley.systems.render.B2DDebugSystem;
import com.nzt.gdx.b2D.events.B2DEvent;

/**
 * Box2D body component used by system : {@link B2DSystem} and
 * {@link B2DDebugSystem}
 * 
 * @author fabiitch
 *
 */
public class B2DBodyComponent extends BaseComponent {

	//TODO mettre la position en var pour eviter l'appel a la native
	public Body body;
	public Array<B2DEvent> eventArray;

	public B2DBodyComponent() {
		super();
		eventArray = new Array<B2DEvent>();
	}

	public void addBox2DEvent(B2DEvent... events) {
		eventArray.addAll(events);
	}

	public void addBox2DEvent(B2DEvent event) {
		eventArray.add(event);
	}

	public void processAllEvents(World world) {
		for (B2DEvent event : eventArray) {
			event.apply(world, body);
		}
		Pools.freeAll(eventArray);
		eventArray.clear();
	}
}
