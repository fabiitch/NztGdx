package com.nzt.gdx.math.nzshape2d;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class NzRectangle extends Rectangle implements NzShape2D {
    public NzRectangle() {
    }

    public NzRectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public NzRectangle(Rectangle rect) {
        super(rect);
    }

    @Override
    public void updatePosition(Vector2 position) {
        this.setPosition(position);
    }

    @Override
    public void updatePosition(float x, float y) {
        this.setPosition(x, y);
    }

    @Override
    public void render(NzShapeRenderer nzShapeRenderer) {
        nzShapeRenderer.rect(this);
    }
}
