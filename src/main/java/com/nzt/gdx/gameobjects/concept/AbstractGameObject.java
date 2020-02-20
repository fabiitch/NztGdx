package com.nzt.gdx.gameobjects.concept;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.nzt.gdx.gameobjects.effects.AbstractGameObjectEffect;

public abstract class AbstractGameObject implements Disposable {
	public String name;
	public GameObjectType gameObjectType;

	public Array<AbstractGameObjectEffect> effectsArray;

	public AbstractGameObject(String name) {
		this.effectsArray = new Array<AbstractGameObjectEffect>();
		this.name = name;
		this.gameObjectType = GameObjectType.getGameObjectType(this);
		System.out.println("gameObjectType =" + gameObjectType);
	}

	public AbstractGameObject(String name, GameObjectType gameObjectType) {
		this.name = name;
		this.gameObjectType = gameObjectType;
	}

	public void update(float dt, Array<AbstractGameObject> gameObjectsArray) {
		for (AbstractGameObjectEffect effect : effectsArray) {
			effect.apply(this, gameObjectsArray);
		}
		effectsArray.clear();
		this.update(dt);
	}

	protected abstract void update(float dt);

		@Override
		public void dispose() {
			this.gameObjectType = null;
			this.name = null;
			this.effectsArray = null;
		}

	}
