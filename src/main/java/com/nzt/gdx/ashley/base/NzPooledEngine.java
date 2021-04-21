package com.nzt.gdx.ashley.base;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.utils.ImmutableArray;


//Bon a revoir
public class NzPooledEngine extends PooledEngine {

	public NzPooledEngine() {
		super();
	}

	public NzPooledEngine(int entityPoolInitialSize, int entityPoolMaxSize, int componentPoolInitialSize,
			int componentPoolMaxSize) {
		super(entityPoolInitialSize, entityPoolMaxSize, componentPoolInitialSize, componentPoolMaxSize);
	}

	@Override
	public void addSystem(EntitySystem system) {
		NzEntitySystem nzSystem = new NzEntitySystem(system) {

		};
		super.addSystem(nzSystem);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EntitySystem> T getSystem(Class<T> systemType) {
		for (EntitySystem entitySystem : getSystems()) {
			NzEntitySystem nzSystem = (NzEntitySystem) entitySystem;
			if (nzSystem.system.getClass() == systemType)
				return (T) nzSystem.system;

		}
		return null;
	}
}
