package com.nzt.gdx.ashley.components.physx;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.base.BaseComponent;
import com.nzt.gdx.ashley.systems.PhysicsDebugSystem;
import com.nzt.gdx.ashley.systems.PhysicsSystem;

/**
 * Box2D body component used by system : {@link PhysicsSystem} and
 * {@link PhysicsDebugSystem}
 * 
 * @author fabiitch
 *
 */
public class Box2DBodyComponent extends BaseComponent {

	public Body body;

	public Box2DBodyComponent() {
		super();
	}

}
