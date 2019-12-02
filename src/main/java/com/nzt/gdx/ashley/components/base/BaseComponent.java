package com.nzt.gdx.ashley.components.base;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

public abstract class BaseComponent implements Component {

	public BaseComponent(Entity e) {
		e.add(this);
	}

}
