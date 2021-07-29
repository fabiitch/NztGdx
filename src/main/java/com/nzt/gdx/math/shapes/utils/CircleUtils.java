package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.vectors.V2;

public class CircleUtils {

    private final static Vector2 tmp = new Vector2(); //TODO group sa
    private final static Vector2 tmp2 = new Vector2(); //TODO g

    private CircleUtils() {
    }

    public static Vector2 getCenter(Circle circle, Vector2 center) {
        return center.set(circle.x, circle.y);
    }

    public static Vector2 getTangent(Circle circle, Vector2 posOnCircle, Vector2 result) {
        getCenter(circle, tmp);
        return V2.directionTo(tmp, posOnCircle, result).rotate90(0);
    }

    public static Vector2 getTangentDeg(Circle circle, float angleDeg, Vector2 result) {
        return getTangentRad(circle, MathUtils.degreesToRadians * angleDeg, result);
    }

    //tested by STCircleTangent
    public static Vector2 getTangentRad(Circle circle, float angleRad, Vector2 result) {
        posWithAngleRad(circle, angleRad, tmp);
        getCenter(circle, tmp2);
        return V2.directionTo(tmp2, tmp, result).rotate90(0);
    }


    public static Vector2 dirFromCenter(Circle circle, Vector2 posOnCircle, Vector2 normalResult) {
        getCenter(circle, tmp);
        V2.directionTo(tmp, posOnCircle, normalResult);
        return normalResult;
    }

    public static Vector2 dirToCenter(Circle circle, Vector2 posOnCircle, Vector2 normalResult) {
        getCenter(circle, tmp);
        V2.directionTo(posOnCircle, tmp, normalResult);
        return normalResult;
    }

    public static Vector2 dirFromCenter(Circle circle, float angleDeg, Vector2 normalResult) {
        getCenter(circle, tmp);
        V2.directionTo(tmp, posWithAngleDeg(circle, angleDeg, tmp2), normalResult);
        return normalResult;
    }

    public static Vector2 dirToCenter(Circle circle, float angleDeg, Vector2 normalResult) {
        getCenter(circle, tmp);
        V2.directionTo(posWithAngleDeg(circle, angleDeg, tmp2), tmp, normalResult);
        return normalResult;
    }

    public static Vector2 posWithAngleDeg(Circle cirle, float angleDeg, Vector2 returnV) {
        return posWithAngleRad(cirle.x, cirle.y, cirle.radius, MathUtils.degreesToRadians * angleDeg, returnV);
    }

    public static Vector2 posWithAngleRad(Circle cirle, float angleRadian, Vector2 returnV) {
        return posWithAngleRad(cirle.x, cirle.y, cirle.radius, angleRadian, returnV);
    }

    public static Vector2 posWithAngleRad(float xP, float yP, float radius, float angleRadian, Vector2 returnV) {
        returnV.x = xP + radius * MathUtils.cos(angleRadian);
        returnV.y = yP + radius * MathUtils.sin(angleRadian);
        return returnV;
    }

    public static Vector2 posWithAngleRad(Vector2 positionStart, float rayon, float angleRadian, Vector2 returnV) {
        return posWithAngleRad(positionStart.x, positionStart.y, rayon, angleRadian, returnV);
    }

    public static Vector3 posWithAngleRad(Vector3 positionStart, float rayon, float angleRadian, Vector3 returnV) {
        returnV.x = positionStart.x + rayon * MathUtils.cos(angleRadian);
        returnV.y = positionStart.y + rayon * MathUtils.sin(angleRadian);
        return returnV;
    }

    public static Vector2 getReflexion(Circle cirle, Vector2 dir, Vector2 posOnCircle, Vector2 reflexionDir) {
        Vector2 normal = dirFromCenter(cirle, posOnCircle, tmp);

//        float angleDiff = normal.angleDeg()
//        reflexionDir.set(1,0)
return normal;
    }

//    public static float getAngleReflexionRad(Circle circle, float angleRad) {
//        Vector2 tangent = getTangentRad(circle, angleRad, tmp);
//        tmp2.setAngleRad(angleRad);
//        return AngleUtils.angleReflexionRad(tangent, tmp2);
//    }


    //tangent point extérieure :
    //  https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/geometry/PointCircleTangent.java
}
