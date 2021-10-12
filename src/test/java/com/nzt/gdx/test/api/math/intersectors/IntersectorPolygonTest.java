package com.nzt.gdx.test.api.math.intersectors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.FloatArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntersectorPolygonTest {

    @Test
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
        System.out.println("b1="+ b1 +" | b2="+b2+" | b3=" +b3);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }
}
