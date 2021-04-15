package com.nzt.gdx.test.screens.b2D;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.b2d.events.type.fixture.impl.SensorFixtureEvent;
import com.nzt.gdx.b2d.factories.B2DFixtureEventFactory;
import com.nzt.gdx.test.tester.selector.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.systems.BaseB2DSystemScreen;

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

        addFunctionToCall(50, logFixture("before"));
        addFunctionToCall(100, fireEvent());
        addFunctionToCall(300, logFixture("after"));
    }

    private Callable<Boolean> fireEvent() {
        return new Callable<Boolean>() {
            public Boolean call() {
                SensorFixtureEvent sensorFixtureEvent = B2DFixtureEventFactory.sensor(-1, true);
                entity.getComponent(B2DBodyComponent.class).addBox2DEvent(sensorFixtureEvent);
                return true;
            }
        };
    }

    private Callable<Boolean> logFixture(String text) {
        return new Callable<Boolean>() {
            public Boolean call() {
                System.out.println(text + " isSensor =" + circleBody.getFixtureList().get(0).isSensor());
                return true;
            }
        };
    }

}
