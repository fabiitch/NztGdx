package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.base.PoolableComponent;

public class RemoveEntityComponent extends PoolableComponent {
	
	public static ComponentMapper<RemoveEntityComponent> mapper = ComponentMapper.getFor(RemoveEntityComponent.class);
	
    @Override
    public void reset() {

    }
}
