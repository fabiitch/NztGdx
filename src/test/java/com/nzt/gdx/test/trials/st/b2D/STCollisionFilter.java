package com.nzt.gdx.test.trials.st.b2D;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseB2DSystemScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "box2D")
public class STCollisionFilter extends BaseB2DSystemScreen {
    public STCollisionFilter(FastTesterMain main) {
        super(main);
        FixtureDefWrapper fixture1 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);

        FixtureDefWrapper fixture2 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);

        bodyFactory.createCircleBody(b2DConverter.toPPM(10, 10), 50 / PPM, fixture1);

        bodyFactory.createCircleBody(Vector2.Zero, 20 / PPM, fixture1);
        createWallScreen();
    }
}
