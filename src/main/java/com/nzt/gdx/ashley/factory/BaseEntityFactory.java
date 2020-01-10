package com.nzt.gdx.ashley.factory;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.TransformComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;
import com.nzt.gdx.graphics.components.ShapeRenderable;

//TODO a voir si bien fait la factory commesa
public class BaseEntityFactory {
	protected PooledEngine engine;
	private Entity nextEntity;

	public BaseEntityFactory(PooledEngine engine) {
		this.engine = engine;
	}

	public Entity build() {
		return nextEntity;
	}

	public BaseEntityFactory createSimpleEntity() {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		return this;
	}

	public BaseEntityFactory createTransformEntity() {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
		nextEntity.add(transformComponent);
		return this;
	}

	public BaseEntityFactory addSprite(Texture texture, float width, float height) {
		SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
		nextEntity.add(spriteComponent);
		return this;
	}

	public BaseEntityFactory addSprite(Texture texture, float rayon) {
		return addSprite(texture, rayon, rayon);
	}

	public BaseEntityFactory addB2D(Body body) {
		B2DBodyComponent box2dBodyComponent = engine.createComponent(B2DBodyComponent.class);
		box2dBodyComponent.body = body;
		nextEntity.add(box2dBodyComponent);
		return this;
	}

	public BaseEntityFactory addShape(ShapeRenderable shapeRenderable) {
		ShapeArrayComponent shapeArrayComponent = engine.createComponent(ShapeArrayComponent.class);
		shapeArrayComponent.addShape(shapeRenderable);
		nextEntity.add(shapeArrayComponent);
		return this;
	}
}
