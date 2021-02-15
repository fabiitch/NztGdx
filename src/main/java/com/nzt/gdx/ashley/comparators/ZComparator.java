package com.nzt.gdx.ashley.comparators;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;

public class ZComparator implements Comparator<Entity> {
	private ComponentMapper<PositionComponent> transformM = PositionComponent.mapper;

	public ZComparator() {
	}

	@Override
	public int compare(Entity entityA, Entity entityB) {
		float posZA = transformM.get(entityA).position.z;
		float posZB = transformM.get(entityB).position.z;
		return Float.compare(posZA, posZB);//BOF aussi
//		return (int) Math.signum(transformM.get(entityB).position.z - transformM.get(entityA).position.z); //TODO sure sa ya une native
	}
}