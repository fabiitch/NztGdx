package com.nzt.gdx.math.shape.rectangles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class RectangleUtils {

    public static void centerScreenX(Rectangle rect) {
        rect.setX(Gdx.graphics.getWidth() / 2 - rect.getWidth() / 2);
    }

    public static void centerScreenY(Rectangle rect) {
        rect.setX(Gdx.graphics.getHeight() / 2 - rect.getHeight() / 2);
    }

    public static Rectangle allToPPM(Rectangle rect, float PPM) {
        sizeToPPM(rect, PPM);
        posToPPM(rect, PPM);
        return rect;
    }

    public static Rectangle sizeToPPM(Rectangle rect, float PPM) {
        rect.setWidth(rect.getWidth() / PPM);
        rect.setHeight(rect.getHeight() / PPM);
        return rect;
    }

    public static Rectangle posToPPM(Rectangle rect, float PPM) {
        rect.setX(rect.getX() / PPM);
        rect.setY(rect.getY() / PPM);
        return rect;
    }
}
