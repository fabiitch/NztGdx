package com.nzt.gdx.screens.b2D;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.tester.screen.BaseB2DSystemScreen;

public class TriangleBodyTestScreen extends BaseB2DSystemScreen{

	public TriangleBodyTestScreen(AbstractMain main) {
		super(main);
        FixtureDefWrapper fixtureDefWrapper = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
	}

}
