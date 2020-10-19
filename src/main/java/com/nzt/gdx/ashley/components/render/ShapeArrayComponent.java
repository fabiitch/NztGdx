package com.nzt.gdx.ashley.components.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

public class ShapeArrayComponent extends PoolableComponent {

	public static ComponentMapper<ShapeArrayComponent> mapper = ComponentMapper.getFor(ShapeArrayComponent.class);
	
	public Array<ShapeRenderable> renderableArray;

	public ShapeArrayComponent() {
		super();
		renderableArray = new Array<ShapeRenderable>();
	}

	public void addShape(ShapeRenderable shapeRenderable) {
		renderableArray.add(shapeRenderable);
	}

	public void render(ShapeRenderer shapeRenderer) {
		for (int i = 0, n = renderableArray.size; i < n; i++) {
			renderableArray.get(i).render(shapeRenderer);
		}
	}

	@Override
	public void reset() {
		renderableArray.clear();
	}

}
