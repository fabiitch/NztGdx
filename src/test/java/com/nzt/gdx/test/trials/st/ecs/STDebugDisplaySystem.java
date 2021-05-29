package com.nzt.gdx.test.trials.st.ecs;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.ashley.systems.debug.DebugDisplaySystem;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.test.trials.st.b2D.B2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseB2DSystemScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "ecs")
public class STDebugDisplaySystem extends BaseB2DSystemScreen {
    public STDebugDisplaySystem(FastTesterMain main) {
        super(main);
        this.world.setGravity(new Vector2(0, -1));
        createWallScreen();
        init();
        DebugDisplaySystem debugDisplaySystem = new DebugDisplaySystem(main.sb, camera, 1 / B2DTestConstants.PPM);
        engine.addSystem(debugDisplaySystem);
    }


    private void init() {
        float randomW = MathUtils.random(-B2DTestConstants.WIDTH_PPM / 2, B2DTestConstants.WIDTH_PPM / 2);
        float randomH = MathUtils.random(-B2DTestConstants.HEIGHT_PPM / 2, B2DTestConstants.HEIGHT_PPM / 2);
        FixtureDefWrapper fixtureDefWrapper = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false).setDensity(1).setToPPM(false);
        for (int i = 0; i < 100; i++) {
            float size = MathUtils.random(5 / B2DTestConstants.PPM, 50 / B2DTestConstants.PPM);
            Body circleBody = bodyFactory.createCircleBody(new Vector2(randomW, randomH), size, fixtureDefWrapper);
            Entity entity = addEntityBody(circleBody);
            entity.add(entityFactory.mvtFactory.position());
            short mask;
            String name;
            if (i % 2 == 0) {
                mask = 12;
                name = "t1";
            } else {
                mask = 12;
                name = "t2";
            }
            entity.add(entityFactory.propertiesFactory.type(mask, name));
            entity.add(entityFactory.propertiesFactory.debug(i, name));
        }
    }
}
