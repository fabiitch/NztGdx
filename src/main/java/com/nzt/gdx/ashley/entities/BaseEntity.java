package com.nzt.gdx.ashley.entities;

import com.badlogic.ashley.core.Entity;

public abstract class BaseEntity {

	public String name;
	public Entity entity;

	public BaseEntity(String name, Entity entity) {
		this.name = name;
		this.entity = entity;
	}
}
