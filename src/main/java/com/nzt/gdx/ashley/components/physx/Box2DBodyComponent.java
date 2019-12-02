package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.base.BaseComponent;

public class Box2DBodyComponent extends BaseComponent {

	public Body body;

	public Box2DBodyComponent(Entity e, Body body) {
		super(e);
		this.body = body;
	}

}
