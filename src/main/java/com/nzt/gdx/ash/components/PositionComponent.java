package com.nzt.gdx.ash.components;

import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ash.components.base.BasePoolableComponent;

public class PositionComponent extends BasePoolableComponent {
	public final Vector3 position = new Vector3();

	@Override
	public void reset() {
		position.set(0, 0, 0);

	}
}
