package com.nzt.gdx.ashley.factory;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.PositionComponent;
import com.nzt.gdx.ashley.components.TransformersComponent;
import com.nzt.gdx.ashley.components.TypeComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.components.render.ModelComponent;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

//TODO a voir si bien fait la factory commesa
public class BaseEntityFactory {
	protected PooledEngine engine;
	private Entity nextEntity; // TODO bof lui en private

	public BaseEntityFactory(PooledEngine engine) {
		this.engine = engine;
	}

	public Entity build() {
		return nextEntity;
	}

	protected <T extends Component> T createComponent(Class<T> componentType) {
		return this.engine.createComponent(componentType);
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

	protected Entity createTransformEntity(float x, float y, float z, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		nextEntity.add(position(x, y, z, angle));
		return nextEntity;
	}

	protected Entity createTransformEntity(float x, float y, float angle) {
		nextEntity = this.engine.createEntity();
		engine.addEntity(nextEntity);
		nextEntity.add(position(x, y, 0, angle));
		return nextEntity;
	}

	protected PositionComponent position(float x, float y, float z, float angle) {
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		positionComponent.position.x = x;
		positionComponent.position.y = y;
		positionComponent.position.z = z;
		positionComponent.angle = angle;
		return positionComponent;
	}

	protected TypeComponent type(short mask, String name) {
		TypeComponent typeComponent = engine.createComponent(TypeComponent.class);
		typeComponent.mask = mask;
		typeComponent.name = name;
		return typeComponent;
	}

	protected SpriteComponent sprite(Texture texture, float width, float height) {
		SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
		return spriteComponent;
	}

	protected Component sprite(Texture texture, float rayon) {
		return sprite(texture, rayon, rayon);
	}

	protected B2DBodyComponent b2D(Body body) {
		B2DBodyComponent box2dBodyComponent = engine.createComponent(B2DBodyComponent.class);
		box2dBodyComponent.body = body;
		return box2dBodyComponent;
	}

	protected ShapeArrayComponent shapeArray(ShapeRenderable shapeRenderable) {
		ShapeArrayComponent shapeArrayComponent = engine.createComponent(ShapeArrayComponent.class);
		shapeArrayComponent.addShape(shapeRenderable);
		nextEntity.add(shapeArrayComponent);
		return shapeArrayComponent;
	}

	protected ModelComponent modelInstance(ModelInstance modelInstance) {
		ModelComponent modelComponent = new ModelComponent(modelInstance);
		return modelComponent;
	}

	protected TransformersComponent transformers() {
		TransformersComponent transformerComponent = engine.createComponent(TransformersComponent.class);
		nextEntity.add(transformerComponent);
		return transformerComponent;
	}
}
