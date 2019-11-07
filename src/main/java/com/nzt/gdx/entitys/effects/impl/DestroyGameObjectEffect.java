package com.nzt.gdx.entitys.effects.impl;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.entitys.concept.AbstractGameObject;
import com.nzt.gdx.entitys.effects.AbstractGameObjectEffect;

public class DestroyGameObjectEffect implements AbstractGameObjectEffect{

	@Override
	public void apply(AbstractGameObject gameObject, Array<AbstractGameObject> gameObjectsArray) {
		gameObjectsArray.removeValue(gameObject, true);
		gameObject.dispose();
		gameObject = null;
	}

}
