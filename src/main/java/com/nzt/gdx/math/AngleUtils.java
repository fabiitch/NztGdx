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
//        if (goSecond) {
//        float angleReflexion = AngleUtils.angleReflexion(closestSegmentIntersection, direction);
//        float angleIncidence = AngleUtils.angleIncidence(angleReflexion);
//        spriteIndicator2.setRotation(AngleUtils.angleIncidence(closestSegmentIntersection, direction));
//        if (IntersectWall(intersectionPointWithWall, posMaxEndIndicator, intersectionPointWithWall, closestSegmentIntersection)) {
//            spriteIndicator2.setSize(spriteIndicator1.getWidth() - intersectionPointWithWall.dst(intersectionPointWithWall), spriteIndicator2.getHeight());
//        } else {
//            spriteIndicator1.setSize(maxRangeShow - spriteIndicator1.getWidth(), spriteIndicator1.getHeight());
//        }
//        this.directionRotate.setAngleDeg(angleIncidence).rotate90(1).scl(spriteIndicator2.getHeight() / 2);
//        posSprite.set(intersectionPointWithWall).add(directionRotate);
//        spriteIndicator2.setPosition(posSprite.x, posSprite.y);
//    }
}
