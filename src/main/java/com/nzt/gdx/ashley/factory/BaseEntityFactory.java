package com.nzt.gdx.ashley.factory;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.TransformersComponent;
import com.nzt.gdx.ashley.components.TypeComponent;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.components.render.ModelComponent;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

//TODO a voir si bien fait la factory comme sa
public class BaseEntityFactory {
	protected Engine engine;
	protected Entity newEntity; // TODO bof lui en private

	public BaseEntityFactory(Engine engine) {
		this.engine = engine;
	}

	public Entity build() {
		return newEntity;
	}

	protected <T extends Component> T createComponent(Class<T> componentType) {
		return this.engine.createComponent(componentType);
	}

	protected Entity createSimpleEntity() {
		newEntity = this.engine.createEntity();
		engine.addEntity(newEntity);
		return newEntity;
	}

	protected Entity createTransformEntity() {
		newEntity = this.engine.createEntity();
		engine.addEntity(newEntity);
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		newEntity.add(positionComponent);
		return newEntity;
	}

	protected Entity createTransformAndVelEntity(float x, float y, float z, float angle) {
		newEntity = this.engine.createEntity();
		engine.addEntity(newEntity);
		newEntity.add(position(x, y, z, angle));
		newEntity.add(velocity());
		return newEntity;
	}

	protected Entity createTransformAndVelEntity(float x, float y, float angle) {
		newEntity = this.engine.createEntity();
		engine.addEntity(newEntity);
		newEntity.add(position(x, y, 0, angle));
		newEntity.add(velocity());
		return newEntity;
	}

	protected PositionComponent position(float x, float y, float z, float angle) {
		PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
		positionComponent.position.x = x;
		positionComponent.position.y = y;
		positionComponent.position.z = z;
		positionComponent.angleRadian = angle;
		return positionComponent;
	}

	protected Velocity2DComponent velocity() {
		Velocity2DComponent velocity = engine.createComponent(Velocity2DComponent.class);
		return velocity;
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
		newEntity.add(shapeArrayComponent);
		return shapeArrayComponent;
	}

	protected ModelComponent modelInstance(ModelInstance modelInstance) {
		ModelComponent modelComponent = new ModelComponent(modelInstance);
		return modelComponent;
	}

	protected TransformersComponent transformers() {
		TransformersComponent transformerComponent = engine.createComponent(TransformersComponent.class);
		newEntity.add(transformerComponent);
		return transformerComponent;
	}
}
