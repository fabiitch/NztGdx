package com.nzt.gdx.ashley.entities;

import com.badlogic.ashley.core.Entity;

public abstract class BaseGameObject {

	public String name;
	public Entity entity;

	public BaseGameObject(String name, Entity entity) {
		this.name = name;
		this.entity = entity;
	}
}