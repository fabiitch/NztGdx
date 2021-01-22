package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.render.ShapeArrayComponent;

//TODO reprendre ou suppr
public class RenderShapeSystem extends IteratingSystem {

	private ShapeRenderer shapeRenderer;
	private Array<Entity> queue;
	private ComponentMapper<ShapeArrayComponent> shapeArrayMapper = ShapeArrayComponent.mapper;

	public RenderShapeSystem(ShapeRenderer shapeRenderer) {
		this(shapeRenderer, NztSystemsOrder.RENDER);
	}

	public RenderShapeSystem(ShapeRenderer shapeRenderer, int order) {
		super(Family.one(ShapeArrayComponent.class).get(), order);
		this.shapeRenderer = shapeRenderer;
		this.queue = new Array<Entity>();
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		shapeRenderer.begin();
		shapeRenderer.end();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		ShapeArrayComponent shapeComponent = shapeArrayMapper.get(entity);
		shapeComponent.render(shapeRenderer);
	}

	public void dispose() {
		this.queue.clear();
		this.queue = null;
	}

}
