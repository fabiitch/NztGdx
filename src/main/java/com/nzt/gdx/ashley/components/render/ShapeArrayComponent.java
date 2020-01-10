package com.nzt.gdx.ashley.components.render;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.base.PoolableComponent;
import com.nzt.gdx.graphics.components.ShapeRenderable;

public class ShapeArrayComponent extends PoolableComponent {

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
