package com.nzt.gdx.ashley.entities;

import com.badlogic.ashley.core.Entity;

public abstract class BaseEntity {

	public String name;
	public Entity entity;

	public BaseEntity(String name, Entity e) {
		this.name = name;
		this.entity = e;
	}

	public <T extends BaseEntity> void contact(T entity) {
		System.out.println("base contact with :" + entity.getClass());
	}

}
