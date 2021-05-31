package com.nzt.gdx.ashley.components.properties;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class TypeComponent extends PoolableComponent {

	public static ComponentMapper<TypeComponent> mapper = ComponentMapper.getFor(TypeComponent.class);
	
	public short mask;
	public String name;

	@Override
	public void reset() {
		mask = 0;
		name = null;
	}

	@Override
	public String toString() {
		return "TypeComponent [mask=" + mask + ", name=" + name + "]";
	}

}
