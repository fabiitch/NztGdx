package com.nzt.gdx.math.shapes.builders;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class PolygonBuilder {

    private PolygonBuilder() {

    }

    public static Polygon rectangle(float width, float height, boolean setCenterRect) {
        float vertices[];
        if (setCenterRect) {
            vertices = new float[]{-width / 2, -height / 2, width / 2, -height / 2, width / 2, height / 2, -width / 2, height / 2};
        } else {
            vertices = new float[]{0, 0, width, 0, width, height, 0, height};
        }
        return new Polygon(vertices);
    }

    public static Polygon polygon(Vector2... verticesV) {
        float[] vertices = new float[verticesV.length * 2];
        for (int i = 0; i < verticesV.length; i++) {
            vertices[i * 2] = verticesV[i].x;
            vertices[i * 2 + 1] = verticesV[i].y;
        }
        return new Polygon(vertices);
    }

    public static Polygon square(float witdh, boolean setCenterRect) {
        return rectangle(witdh, witdh, setCenterRect);
    }
}
