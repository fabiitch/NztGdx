package com.nzt.gdx.ashley.entities.visitor;

import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.entities.BaseEntity;


public abstract class VisitorBaseEntity extends BaseEntity implements VisitorContactImpl{
	public VisitorBaseEntity(String name, Entity e) {
		super(name, e);
	}
}
