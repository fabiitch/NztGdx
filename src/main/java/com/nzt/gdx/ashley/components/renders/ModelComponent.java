package com.nzt.gdx.ashley.components.renders;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.components.abstracts.BaseComponent;

public class ModelComponent extends BaseComponent {

	public static ComponentMapper<ModelComponent> mapper = ComponentMapper.getFor(ModelComponent.class);

	public ModelInstance modelInstance;
	public boolean visible = true;

	public ModelComponent(ModelInstance modelInstance) {
		super();
		this.modelInstance = modelInstance;
	}

}
