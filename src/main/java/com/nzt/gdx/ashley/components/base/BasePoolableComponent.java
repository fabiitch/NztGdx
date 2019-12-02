package com.nzt.gdx.ashley.components.base;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class BasePoolableComponent extends BaseComponent implements Poolable {

	public BasePoolableComponent(Entity e) {
		super(e);
	}

}
