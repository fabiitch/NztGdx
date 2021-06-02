package com.nzt.gdx.ashley.components.properties;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class ActiveComponent extends PoolableComponent {
	public static final ComponentMapper<ActiveComponent> mapper = ComponentMapper.getFor(ActiveComponent.class);

	@Override
	public void reset() {
		
	}

}
