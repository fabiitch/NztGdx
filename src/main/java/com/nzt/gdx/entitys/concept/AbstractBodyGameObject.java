package com.nzt.gdx.entitys.concept;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.b2d.Box2DEvent;

public abstract class AbstractBodyGameObject extends AbstractGameObject {
	public Body body;
	public Array<Box2DEvent> box2DEventArray;

	public AbstractBodyGameObject(String name, Body body) {
		super(name);
		this.box2DEventArray = new Array<Box2DEvent>();
		this.body = body;
		this.body.setUserData(new UserDataWrapper(this));
	}

	public AbstractBodyGameObject(String name, Body body, GameObjectType gameObjectType) {
		super(name, gameObjectType);
		this.body = body;
		this.body.setUserData(new UserDataWrapper(this));
	}

	public void doAllBox2DEvent(World world, Array<AbstractBodyGameObject> arrayBodyGO) {
		for (Box2DEvent event : box2DEventArray) {
			event.apply(world, this.body, arrayBodyGO);
		}
		box2DEventArray.clear();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
