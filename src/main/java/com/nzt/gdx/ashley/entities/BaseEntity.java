package com.nzt.gdx.ashley.entities;

import com.badlogic.ashley.core.Entity;

public abstract class BaseEntity {

	public String name;
	public Entity entity;

	public BaseEntity(String name, Entity e) {
		this.name = name;
		this.entity = e;
	}

	public abstract void contact(BaseEntity e);
//	public void contact(BaseEntity entity) {
//		System.out.println(name +" base contact with :" + entity.getClass());
//	}


}
