package com.nzt.gdx.ashley.comparators;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;

public class ZComparator implements Comparator<Entity> {
	private ComponentMapper<PositionComponent> transformM;

	public ZComparator() {
		transformM = ComponentMapper.getFor(PositionComponent.class);
	}

	@Override
	public int compare(Entity entityA, Entity entityB) {
		return (int) Math.signum(transformM.get(entityB).position.z - transformM.get(entityA).position.z);
	}
}