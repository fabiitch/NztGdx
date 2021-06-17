package com.nzt.gdx.math.shape.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CircleUtils {

    private CircleUtils() {
    }

    public static Vector2 positionOnACircleWithAngle(float xP, float yP, float rayon, float angleRadian, Vector2 returnV) {
        returnV.x = xP + rayon * MathUtils.cos(angleRadian);
        returnV.y = yP + rayon * MathUtils.sin(angleRadian);
        return returnV;
    }

    public static Vector2 positionOnACircleWithAngle(Vector2 positionStart, float rayon, float angleRadian, Vector2 returnV) {
        return positionOnACircleWithAngle(positionStart.x, positionStart.y, rayon, angleRadian, returnV);
    }

    public static Vector3 positionOnACircleWithAngle(Vector3 positionStart, float rayon, float angleRadian, Vector3 returnV) {
        returnV.x = positionStart.x + rayon * MathUtils.cos(angleRadian);
        returnV.y = positionStart.y + rayon * MathUtils.sin(angleRadian);
        return returnV;
    }
}
