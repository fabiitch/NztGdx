package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;

public class RemoveEntityComponent extends PoolableComponent {

    public static ComponentMapper<RemoveEntityComponent> mapper = ComponentMapper.getFor(RemoveEntityComponent.class);

    @Override
    public void reset() {

    }
    public static RemoveEntityComponent getNew() {
        return Pools.obtain(RemoveEntityComponent.class);
    }
}
