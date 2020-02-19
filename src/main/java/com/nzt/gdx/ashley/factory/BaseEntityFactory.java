package com.nzt.gdx.ashley.factory;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.PositionComponent;
import com.nzt.gdx.ashley.components.TransformersComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.components.render.ModelComponent;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

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
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		nextEntity.add(positionComponent);
		return nextEntity;
	}

	protected Entity createTransformEntity(float x, float y, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		positionComponent.position.x = x;
		positionComponent.position.y = y;
		positionComponent.angle = angle;
		nextEntity.add(positionComponent);
		return nextEntity;
	}

	protected Entity createTransformEntity(Vector2 position, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		positionComponent.position.x = position.x;
		positionComponent.position.y = position.y;
		positionComponent.angle = angle;
		nextEntity.add(positionComponent);
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

	protected Component modelInstance(ModelInstance modelInstance) {
		ModelComponent modelComponent = new ModelComponent(modelInstance);
		return modelComponent;
	}

	protected Component transformers() {
		TransformersComponent transformerComponent = engine.createComponent(TransformersComponent.class);
		nextEntity.add(transformerComponent);
		return transformerComponent;
	}
}
