package com.nzt.gdx.test.trials.st.b2D;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.b2d.events.type.fixture.impl.SensorFixtureEvent;
import com.nzt.gdx.b2d.factories.B2DFixtureEventFactory;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseB2DSystemScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

import java.util.concurrent.Callable;

@TestScreen(group = "box2D")
public class STFixtureEvent extends BaseB2DSystemScreen {
    Body circleBody;
    Entity entity;

    public STFixtureEvent(FastTesterMain main) {
        super(main);
        FixtureDefWrapper fixtureDefWrapper = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
        circleBody = bodyFactory.createCircleBody(Vector2.Zero, 2, fixtureDefWrapper);

        entity = addEntityBody(circleBody);

        HudDebug.addTopLeft("Fixture isSensor", circleBody.getFixtureList().get(0).isSensor());
        addFunctionToCall(200, fireEvent());
        createWallScreen();
    }

    @Override
    public void renderScreen(float dt) {
        super.renderScreen(dt);
        HudDebug.update("Fixture isSensor", circleBody.getFixtureList().get(0).isSensor());
    }

    private Callable<Boolean> fireEvent() {
        return new Callable<Boolean>() {
            public Boolean call() {
                SensorFixtureEvent sensorFixtureEvent = B2DFixtureEventFactory.sensor(-1, true);
                entity.getComponent(B2DBodyComponent.class).addBox2DEvent(sensorFixtureEvent);
                HudDebug.changeColor("Fixture isSensor", Color.BLUE);
                return true;
            }
        };
    }
}
