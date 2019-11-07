package com.nzt.gdx.entitys.concept;

public class UserDataWrapper {
	
	public AbstractBodyGameObject bodyGameObject;
	public UserDataWrapper(AbstractBodyGameObject gameObject) {
		super();
		this.bodyGameObject = gameObject;
		System.out.println("go "+ this.bodyGameObject);
	}
}
