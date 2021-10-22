package com.nzt.gdx.test.api.math.intersectors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import com.nzt.gdx.math.shapes.builders.PolygonBuilder;
import com.nzt.gdx.math.shapes.utils.PolygonUtils;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class IntersectorGdxTest {

    @Test
    @Disabled
    public void intersect2Rect() {

        float[] vertices1 = new float[]{-50, 0,
                50, 0,
                50, 50,
                -50, 50};
        float[] vertices2 = new float[]{-10, -100,
                10, -100,
                10, 100,
                -10, 100};
        Polygon poly1 = new Polygon(vertices1);
        Polygon poly2 = new Polygon(vertices2);

        boolean b1 = Intersector.intersectPolygons(poly1, poly2, null);

        boolean b2 = Intersector.intersectPolygons(new FloatArray(poly1.getTransformedVertices()), new FloatArray(poly2.getTransformedVertices()));

        boolean b3 = Intersector.intersectPolygonEdges(new FloatArray(poly1.getTransformedVertices()), new FloatArray(poly2.getTransformedVertices()));

        //result : b1=false | b2=true | b3=true
        System.out.println("b1=" + b1 + " | b2=" + b2 + " | b3=" + b3);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }


    /**
     * goal check if intersectLinePolygon is for line or segment
     * OK its for SEGMENT
     */
    @Test
    public void intersectLinePolygon() {

        Rectangle rect = new Rectangle(0, 0, 100, 100);

        boolean b1 = Intersector.intersectLinePolygon(new Vector2(-50, 50), new Vector2(500, 50), PolygonBuilder.rectangle(rect, false));
        Assertions.assertTrue(b1);

        boolean b2 = Intersector.intersectLinePolygon(new Vector2(-500, 50), new Vector2(-50, 50), PolygonBuilder.rectangle(rect, false));
        Assertions.assertFalse(b2);
    }
}
