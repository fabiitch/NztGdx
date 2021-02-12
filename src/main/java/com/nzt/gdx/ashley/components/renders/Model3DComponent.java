package com.nzt.gdx.ashley.components.renders;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.components.abstracts.BaseComponent;

public class Model3DComponent extends BaseComponent {

	public static ComponentMapper<Model3DComponent> mapper = ComponentMapper.getFor(Model3DComponent.class);

	public ModelInstance modelInstance;
	public boolean visible = true;

	public Model3DComponent(ModelInstance modelInstance) {
		super();
		this.modelInstance = modelInstance;
	}

}
