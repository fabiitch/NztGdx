package com.nzt.gdx.ashley.factories.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.components.renders.ModelComponent;
import com.nzt.gdx.ashley.components.renders.ShapeRenderableArrayComponent;
import com.nzt.gdx.ashley.components.renders.SpriteComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

public class RendersComponentFactory extends BaseComponentFactory {

    public RendersComponentFactory(Engine engine) {
        super(engine);
    }

    public SpriteComponent sprite(Texture texture, float width, float height) {
        SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
        return spriteComponent;
    }

    public Component sprite(Texture texture, float rayon) {
        return sprite(texture, rayon, rayon);
    }

    public ShapeRenderableArrayComponent shapeArray(ShapeRenderable shapeRenderable) {
        ShapeRenderableArrayComponent shapeArrayComponent = engine.createComponent(ShapeRenderableArrayComponent.class);
        shapeArrayComponent.addShape(shapeRenderable);
        return shapeArrayComponent;
    }

    public ModelComponent modelInstance(ModelInstance modelInstance) {
        ModelComponent modelComponent = new ModelComponent(modelInstance);
        return modelComponent;
    }
}
