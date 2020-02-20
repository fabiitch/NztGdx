package com.nzt.gdx.gameobjects.concept;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.b2D.events.B2DEvent;

public abstract class AbstractBodyGameObject extends AbstractGameObject {
	public Body body;
	public Array<B2DEvent> box2DEventArray;

	public AbstractBodyGameObject(String name, Body body) {
		super(name);
		this.box2DEventArray = new Array<B2DEvent>();
		this.body = body;
		this.body.setUserData(new UserDataWrapper(this));
	}

	public AbstractBodyGameObject(String name, Body body, GameObjectType gameObjectType) {
		super(name, gameObjectType);
		this.body = body;
		this.body.setUserData(new UserDataWrapper(this));
	}

	public void doAllBox2DEvent(World world, Array<AbstractBodyGameObject> arrayBodyGO) {
		for (B2DEvent event : box2DEventArray) {
//			event.apply(world, this.body, arrayBodyGO);
		}
		box2DEventArray.clear();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
