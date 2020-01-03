package com.nzt.gdx.ashley.components.physx;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.components.base.BaseComponent;
import com.nzt.gdx.ashley.systems.PhysicsDebugSystem;
import com.nzt.gdx.ashley.systems.PhysicsSystem;
import com.nzt.gdx.box2D.events.Box2DEvent;

/**
 * Box2D body component used by system : {@link PhysicsSystem} and
 * {@link PhysicsDebugSystem}
 * 
 * @author fabiitch
 *
 */
public class Box2DBodyComponent extends BaseComponent {

	public Body body;
	public Array<Box2DEvent> eventArray;

	public Box2DBodyComponent() {
		super();
		eventArray = new Array<Box2DEvent>();
	}

	public void addBox2DEvent(Box2DEvent event) {
		eventArray.add(event);
	}

	public void processAllEvents(World world) {
		for (Box2DEvent event : eventArray) {
			event.apply(world, body);
		}
		Pools.freeAll(eventArray);
		eventArray.clear();
	}
}
