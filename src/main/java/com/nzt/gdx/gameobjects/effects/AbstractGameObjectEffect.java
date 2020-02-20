package com.nzt.gdx.gameobjects.effects;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.gameobjects.concept.AbstractGameObject;

public interface AbstractGameObjectEffect {
	public void apply(AbstractGameObject gameObject, Array<AbstractGameObject> gameObjectsArray);
}
