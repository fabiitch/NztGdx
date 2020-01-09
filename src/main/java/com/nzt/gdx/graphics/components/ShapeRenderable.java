package com.nzt.gdx.graphics.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface ShapeRenderable extends Component  {

	void render(ShapeRenderer shapeRenderer);
}
