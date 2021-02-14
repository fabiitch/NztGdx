package com.nzt.gdx.math.nzshape2d;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public interface NzShape2D extends Shape2D {

    void updatePosition(Vector2 position);

    void updatePosition(float x, float y);

    void render(NzShapeRenderer nzShapeRenderer);

    float getXMax();

    float getXMaxShape();

    float getXMin();

    float getXMinShape();

    float getYMax();

    float getYMaxShape();

    float getYMin();

    float getYMinShape();

}
