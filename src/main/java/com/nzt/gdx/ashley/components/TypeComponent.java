package com.nzt.gdx.ashley.components;

import com.nzt.gdx.ashley.components.base.PoolableComponent;

public class TypeComponent extends PoolableComponent {

	public short mask;
	public String name;

	@Override
	public void reset() {
		mask = 0;
		name = null;
	}

}
