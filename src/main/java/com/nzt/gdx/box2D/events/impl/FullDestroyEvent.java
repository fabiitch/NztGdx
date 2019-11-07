package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.box2D.events.Box2DEvent;
import com.nzt.gdx.entitys.concept.AbstractBodyGameObject;
import com.nzt.gdx.entitys.concept.UserDataWrapper;
import com.nzt.gdx.entitys.effects.impl.DestroyGameObjectEffect;

public class FullDestroyEvent implements Box2DEvent {

	@Override
	public void apply(World world, Body body, Array<AbstractBodyGameObject> arrayBodyGO) {

		UserDataWrapper userData = (UserDataWrapper) body.getUserData();
		arrayBodyGO.removeValue(userData.bodyGameObject, true);
		world.destroyBody(body);
		body = null;
		
		userData.bodyGameObject.effectsArray.add(new DestroyGameObjectEffect());
	}

}
