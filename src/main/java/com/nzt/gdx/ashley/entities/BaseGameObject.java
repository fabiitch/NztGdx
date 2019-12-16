package com.nzt.gdx.ashley.entities;

import com.badlogic.ashley.core.Entity;

/**
 * Base entity of all, contains ref for {@link Entity} and name of entity
 * @author fabiitch
 *
 */
public abstract class BaseGameObject {

	public Entity entity;
	public String name;

	public BaseGameObject(String name, Entity entity) {
		this.name = name;
		this.entity = entity;
	}
}
