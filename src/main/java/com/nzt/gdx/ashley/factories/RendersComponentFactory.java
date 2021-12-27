package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.components.physx.Shape2DComponent;
import com.nzt.gdx.ashley.components.renders.Model3DComponent;
import com.nzt.gdx.ashley.components.renders.SpriteComponent;
import com.nzt.gdx.ashley.components.renders.shape.ShapeRenderableComponent;

public class RendersComponentFactory extends BaseComponentFactory {

    public RendersComponentFactory(Engine engine) {
        super(engine);
    }

    public SpriteComponent sprite(Sprite sprite) {
        SpriteComponent spriteComponent = new SpriteComponent(sprite);
        return spriteComponent;
    }

    public SpriteComponent sprite(Texture texture, float width, float height) {
        SpriteComponent spriteComponent = new SpriteComponent(texture, width, height);
        return spriteComponent;
    }

    public SpriteComponent sprite(Texture texture, float rayon) {
        return sprite(texture, rayon, rayon);
    }


    public ShapeRenderableComponent shape(Shape2DComponent shape2DComponent, Color color) {
        ShapeRenderableComponent shapeRenderableComponent = new ShapeRenderableComponent(shape2DComponent, color);
        return shapeRenderableComponent;
    }

    public Model3DComponent modelInstance(ModelInstance modelInstance) {
        Model3DComponent modelComponent = engine.createComponent(Model3DComponent.class);
        modelComponent.modelInstance = modelInstance;
        return modelComponent;
    }

    public Model3DComponent modelInstance(ModelInstance modelInstance, Environment environment) {
        Model3DComponent modelComponent = engine.createComponent(Model3DComponent.class);
        modelComponent.modelInstance = modelInstance;
        modelComponent.environment = environment;
        return modelComponent;
    }
}
