package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.PhysXComponent;
import com.nzt.gdx.math.nzshape2d.NzCircle;
import com.nzt.gdx.math.nzshape2d.NzRectangle;

public class PhyXIntersector {


    public void intersect(PhysXComponent physXComponent1, Vector2 velocity1, PhysXComponent physXComponent2) {
        int shapeType1 = physXComponent1.nzShapeType;
        int shapeType2 = physXComponent2.nzShapeType;

        if (shapeType1 == NzShape2DTypes.RECTANGLE && shapeType2 == NzShape2DTypes.RECTANGLE) {
            rects((NzRectangle) physXComponent1.nzShape, velocity1, (NzRectangle) physXComponent1.nzShape);
        } //
        else if (shapeType1 == NzShape2DTypes.RECTANGLE && shapeType2 == NzShape2DTypes.CIRCLE) {
            rectCircle((NzRectangle) physXComponent1.nzShape, velocity1, (NzCircle) physXComponent1.nzShape);
        }   //
        else if (shapeType1 == NzShape2DTypes.CIRCLE && shapeType2 == NzShape2DTypes.RECTANGLE) {
            circleRect((NzCircle) physXComponent1.nzShape, velocity1, (NzRectangle) physXComponent1.nzShape);
        } //
        else if (shapeType1 == NzShape2DTypes.CIRCLE && shapeType2 == NzShape2DTypes.CIRCLE) {
            circles((NzCircle) physXComponent1.nzShape, velocity1, (NzCircle) physXComponent1.nzShape);
        }

    }

    private static Vector2 tmp = new Vector2();

    public void rects(NzRectangle rect1, Vector2 velocity1, NzRectangle rect2) {
        boolean moveToRight = velocity1.x > 0;
        boolean moveToTop = velocity1.y > 0;
        Vector2 newPos = rect1.getPosition(tmp).add(velocity1);
    }

    public void rectCircle(NzRectangle rect, Vector2 velocity1, NzCircle circle) {

    }

    public void circles(NzCircle circle1, Vector2 velocity1, NzCircle circle2) {

    }

    public void circleRect(NzCircle circle, Vector2 velocity1, NzRectangle rect) {
        boolean moveToRight = velocity1.x > 0;
        boolean moveToTop = velocity1.y > 0;
        Vector2 newPos = circle.getPosition(tmp).add(velocity1);
        if (Intersector.overlaps(circle, rect)) {

        }
    }

}
