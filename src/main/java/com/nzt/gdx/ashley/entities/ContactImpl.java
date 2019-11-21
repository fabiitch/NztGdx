package com.nzt.gdx.ashley.entities;

public interface ContactImpl<B1 extends BaseEntity, B2 extends BaseEntity> {

	
	public void startContact(B1 entity1, B2 entity2);

	
}
