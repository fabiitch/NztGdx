package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.box2D.events.Box2DEvent;
import com.nzt.gdx.entitys.concept.AbstractBodyGameObject;
import com.badlogic.gdx.physics.box2d.World;

public class BodyTypeEvent implements Box2DEvent{
	
	public BodyType bodyType;
	
	public BodyTypeEvent(BodyType bodyType) {
		super();
		this.bodyType = bodyType;
	}

	@Override
	public void apply(World world, Body body, Array<AbstractBodyGameObject> arrayBodyGO) {
		body.setType(bodyType);
	}

}
