package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.base.PoolableComponent;

public class TypeComponent extends PoolableComponent {

	public static ComponentMapper<TypeComponent> mapper = ComponentMapper.getFor(TypeComponent.class);
	
	public short mask;
	public String name;

	@Override
	public void reset() {
		mask = 0;
		name = null;
	}

}
