package com.nzt.gdx.ashley.components.render;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.components.base.BaseComponent;

public class ModelComponent extends BaseComponent {

	public ModelInstance modelInstance;
	public boolean visible = true;

	public ModelComponent(ModelInstance modelInstance) {
		super();
		this.modelInstance = modelInstance;
	}

}
