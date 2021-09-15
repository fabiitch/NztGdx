package com.nzt.gdx.ashley.base.components;

import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Base Poolable component, {@link Poolable}
 */
public abstract class PoolableComponent extends BaseComponent implements Poolable {

    public PoolableComponent() {
        super();
    }

}
