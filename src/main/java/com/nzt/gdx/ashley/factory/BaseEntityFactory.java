package com.nzt.gdx.ashley.factory;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.TransformComponent;
import com.nzt.gdx.ashley.components.TransformersComponent;
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

	protected Entity createSimpleEntity() {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		return nextEntity;
	}

	protected Entity createTransformEntity() {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
		nextEntity.add(transformComponent);
		return nextEntity;
	}

	protected Entity createTransformEntity(float x, float y, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
		transformComponent.position.x = x;
		transformComponent.position.y = y;
		transformComponent.angle = angle;
		nextEntity.add(transformComponent);
		return nextEntity;
	}

	protected Entity createTransformEntity(Vector2 position, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
		transformComponent.position.x = position.x;
		transformComponent.position.y = position.y;
		transformComponent.angle = angle;
		nextEntity.add(transformComponent);
		return nextEntity;
	}

	protected Component sprite(Texture texture, float width, float height) {
		SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
		return spriteComponent;
	}

	protected Component sprite(Texture texture, float rayon) {
		return sprite(texture, rayon, rayon);
	}

	protected Component b2D(Body body) {
		B2DBodyComponent box2dBodyComponent = engine.createComponent(B2DBodyComponent.class);
		box2dBodyComponent.body = body;
		return box2dBodyComponent;
	}

	protected Component shapeArray(ShapeRenderable shapeRenderable) {
		ShapeArrayComponent shapeArrayComponent = engine.createComponent(ShapeArrayComponent.class);
		shapeArrayComponent.addShape(shapeRenderable);
		nextEntity.add(shapeArrayComponent);
		return shapeArrayComponent;
	}

	protected Component transformers() {
		TransformersComponent transformerComponent = engine.createComponent(TransformersComponent.class);
		nextEntity.add(transformerComponent);
		return transformerComponent;
	}
}
