package com.nzt.gdx.ashley.comparators;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;

import java.util.Comparator;

public class ZComparator implements Comparator<Entity> {
    private final ComponentMapper<PositionComponent> transformM = PositionComponent.mapper;

    public ZComparator() {
    }

    @Override
    public int compare(Entity entityA, Entity entityB) {
        float posZA = transformM.get(entityA).position.z;
        float posZB = transformM.get(entityB).position.z;
        return Float.compare(posZA, posZB);//BOF aussi
//		return (int) Math.signum(transformM.get(entityB).order.z - transformM.get(entityA).order.z); //TODO sure sa ya une native
    }
}
