package com.nzt.gdx.test.api.tester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;

public class GdxTestUtils {
    public static Rectangle screenAsRectangle(boolean centerAs0) {
        Rectangle rect = new Rectangle();
        if (centerAs0) {
            return rect.set(-Gdx.graphics.getWidth() / 2, -Gdx.graphics.getHeight() / 2,
                    Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        } else {
            return rect.set(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public static Rectangle screenAsRectangle(Camera camera, boolean centerAs0) {
        Rectangle rect = new Rectangle();
        if (centerAs0) {
            return   RectangleUtils.createFromCenter(0,0,camera.viewportWidth, camera.viewportHeight);
        } else {
            return rect.set(0, 0,  camera.viewportWidth, camera.viewportHeight);
        }
    }
}
