package com.nzt.gdx.b2d.events.type.fixture.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.nzt.gdx.b2d.events.B2DFixtureEventsEnum;
import com.nzt.gdx.b2d.events.type.fixture.BaseApplyToFixtureEvent;

public class ChangeUserDataFixtureEvent extends BaseApplyToFixtureEvent<ChangeUserDataFixtureEvent> {

    public Object userdata;

    public ChangeUserDataFixtureEvent(B2DFixtureEventsEnum fixtureEnum) {
        super(B2DFixtureEventsEnum.UserData);
    }

    @Override
    protected boolean canConcat(ChangeUserDataFixtureEvent event) {
        return true;
    }


    @Override
    protected void resetFixtureEvent() {
        userdata = null;
    }

    @Override
    public void applyOnFixture(Fixture fixture) {
        fixture.setUserData(userdata);
    }

}
