package com.nzt.gdx.test.api.math.intersectors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.intersectors.IntersectorCirclePolygon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntersectorCirclePolygonTest {

    @Test
    public void testSegmentCircle() {
        Circle circle = new Circle(0, 0, 200);
        Vector2 a = new Vector2(-500, 0);
        Vector2 b = new Vector2(500, 0);
        Vector2 center = new Vector2(circle.x, circle.y);
        boolean intersect = Intersector.intersectSegmentCircle(a, b, center, circle.radius);
        assertTrue(intersect);
    }

    @Test
    public void simpleTest() {
        Circle circle = new Circle(0, 0, 200);

        Polygon polygon = new Polygon(new float[]{0, 300, 300, 0, -250, 0});
        boolean intersect = IntersectorCirclePolygon.circlePolygon(circle, polygon);
        assertTrue(intersect);
    }
}
