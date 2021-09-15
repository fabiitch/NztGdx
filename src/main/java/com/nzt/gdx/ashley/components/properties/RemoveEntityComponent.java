package com.nzt.gdx.ashley.components.properties;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class RemoveEntityComponent extends PoolableComponent {
    public static final ComponentMapper<RemoveEntityComponent> mapper = ComponentMapper.getFor(RemoveEntityComponent.class);

    @Override
    public void reset() {

    }

    public static RemoveEntityComponent getNew() {
        return Pools.obtain(RemoveEntityComponent.class);
    }
}
