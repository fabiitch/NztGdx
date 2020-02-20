package com.nzt.gdx.gameobjects.effects.impl;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.gameobjects.concept.AbstractGameObject;
import com.nzt.gdx.gameobjects.effects.AbstractGameObjectEffect;

public class DestroyGameObjectEffect implements AbstractGameObjectEffect{

	@Override
	public void apply(AbstractGameObject gameObject, Array<AbstractGameObject> gameObjectsArray) {
		gameObjectsArray.removeValue(gameObject, true);
		gameObject.dispose();
		gameObject = null;
	}

}
