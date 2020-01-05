package com.nzt.gdx.ashley;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.TransformComponent;
import com.nzt.gdx.ashley.components.physx.Box2DBodyComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;

public class BaseEntityFactory {
	protected PooledEngine engine;

	public BaseEntityFactory(PooledEngine engine) {
		this.engine = engine;
	}

	public Entity createSimpleEntity() {
		Entity entity = this.engine.createEntity();
		TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
		entity.add(transformComponent);
		
		engine.addEntity(entity);
		return entity;
	}

	public Entity createSpriteEntity(Texture texture, float width, float height) {
		Entity entity = this.createSimpleEntity();
		SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
		entity.add(spriteComponent);
		return entity;
	}

	public Entity createSpriteEntity(Texture texture, float rayon) {
		return createSpriteEntity(texture, rayon, rayon);
	}

	public Entity createBodySpriteEntity(Body body, Texture texture, float width, float height) {
		Entity entity = this.createSpriteEntity(texture, width, height);
		Box2DBodyComponent box2dBodyComponent = engine.createComponent(Box2DBodyComponent.class);
		box2dBodyComponent.body = body;
		entity.add(box2dBodyComponent);
		return entity;
	}

	public Entity createBodySpriteEntity(Body body, Texture texture, float width) {
		return createBodySpriteEntity(body, texture, width, width);
	}

}
