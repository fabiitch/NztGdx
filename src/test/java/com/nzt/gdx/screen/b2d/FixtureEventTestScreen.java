package com.nzt.gdx.screen.b2d;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.b2d.events.type.fixture.impl.ChangeFixtureEvent;
import com.nzt.gdx.b2d.events.type.fixture.impl.SensorFixtureEvent;
import com.nzt.gdx.b2d.factory.B2DEventFactory;
import com.nzt.gdx.b2d.factory.B2DFixtureEventFactory;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.tester.screen.BaseB2DScreen;

import java.util.concurrent.Callable;

public class FixtureEventTestScreen extends BaseB2DScreen {
    Body circleBody;
    Entity entity;

    public FixtureEventTestScreen(AbstractMain main) {
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
