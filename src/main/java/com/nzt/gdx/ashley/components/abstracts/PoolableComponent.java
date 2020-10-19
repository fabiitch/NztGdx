package com.nzt.gdx.ashley.components.abstracts;

import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * base Poolable component, {@link Poolable}
 * 
 * @author fabiitch
 *
 */
public abstract class PoolableComponent extends BaseComponent implements Poolable {

	public PoolableComponent() {
		super();
	}

}
