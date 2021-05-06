package com.nzt.gdx.ashley.components.renders;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.base.components.PoolableComponent;
import com.nzt.gdx.graphics.renderables.ShapeRenderable;

public class ShapeRenderableArrayComponent extends PoolableComponent {

    public static ComponentMapper<ShapeRenderableArrayComponent> mapper = ComponentMapper.getFor(ShapeRenderableArrayComponent.class);

    public Array<ShapeRenderable> renderableArray;

    public ShapeRenderableArrayComponent() {
        super();
        renderableArray = new Array<>();
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
