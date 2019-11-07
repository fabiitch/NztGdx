package com.nzt.gdx.entitys.effects;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.entitys.concept.AbstractGameObject;

public interface AbstractGameObjectEffect {
	public void apply(AbstractGameObject gameObject, Array<AbstractGameObject> gameObjectsArray);
}
