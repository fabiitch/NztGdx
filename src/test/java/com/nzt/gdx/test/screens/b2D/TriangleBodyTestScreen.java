package com.nzt.gdx.test.screens.b2D;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.input.impl.simple.SimpleMvtInputController;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.BaseB2DSystemScreen;

public class TriangleBodyTestScreen extends BaseB2DSystemScreen {
    Body polygonBody;
    Entity entity;

    public TriangleBodyTestScreen(FastTesterMain main) {
        super(main);
        FixtureDefWrapper fixtureDefWrapper = new FixtureDefWrapper(BodyDef.BodyType.KinematicBody).setSensor(false)
                .setDensity(1).setToPPM(false);

        Vector2 a = new Vector2(0, 0);
        Vector2 b = new Vector2(5, 0);
        Vector2 c = new Vector2(5, 5);
        polygonBody = bodyFactory.createPolygonBody(new Vector2[]{a, b, c}, fixtureDefWrapper);

        entity = addEntityBody(polygonBody);
        polygonBody.setAngularVelocity(1);
        SimpleMvtInputController inputController = new SimpleMvtInputController() {
            @Override
            public void up() {

            }

            @Override
            public void down() {

            }

            @Override
            public void left() {

            }

            @Override
            public void right() {

            }
        };
    }

}
