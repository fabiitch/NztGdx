package com.nzt.gdx.math.random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Randoms {

    private Randoms() {

    }

    public static Vector2 random(float maxX, float maxY) {
        return random(0, maxX, 0, maxY, new Vector2());
    }

    public static Vector2 random(float minX, float maxX, float minY, float maxY) {
        return random(minX, maxX, minY, maxY, new Vector2());
    }

    public static Vector2 random(float minX, float maxX, float minY, float maxY, Vector2 vector) {
        float randomX = MathUtils.random(minX, maxX);
        float randomY = MathUtils.random(minY, maxY);
        return vector.set(randomX, randomY);
    }

    public static Color newRandomColor() {
        float r = MathUtils.random();
        float g = MathUtils.random();
        float b = MathUtils.random();
        Color randomColor = new Color(r, g, b, 1);
        return randomColor;
    }

    public static Color toRandom(Color color) {
        float r = MathUtils.random();
        float g = MathUtils.random();
        float b = MathUtils.random();
        color.r = r;
        color.g = g;
        color.b = b;
        return color;
    }
}
