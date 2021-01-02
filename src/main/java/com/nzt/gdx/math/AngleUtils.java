package com.nzt.gdx.math;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;

public class AngleUtils {

    public static float angleReflexion(Segment2D segment, Vector2 dir) {
        Vector2 normal = segment.getNormale();
        return normal.angleDeg() - (dir.angleDeg() - normal.angleDeg());
    }

    public static float angleIncidence(float angleReflexion) {
        return 180 + angleReflexion;
    }

    public static float angleIncidence(Segment2D segment, Vector2 dir) {
        return 180 + angleReflexion(segment, dir);
    }
}
