package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;

public class RenderShapeSystem extends IteratingSystem {

	private ShapeRenderer shapeRenderer;
	private Array<Entity> queue;
	private ComponentMapper<ShapeArrayComponent> shapeArrayMapper = ShapeArrayComponent.mapper;

	public RenderShapeSystem(ShapeRenderer shapeRenderer) {
		super(Family.one(ShapeArrayComponent.class).get());
		this.shapeRenderer = shapeRenderer;
		this.queue = new Array<Entity>();
	}

	@Override
	public void update(float deltaTime) {
		shapeRenderer.begin();
		super.update(deltaTime);
		shapeRenderer.end();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		ShapeArrayComponent shapeComponent = shapeArrayMapper.get(entity);
		shapeComponent.render(shapeRenderer);
	}

}
