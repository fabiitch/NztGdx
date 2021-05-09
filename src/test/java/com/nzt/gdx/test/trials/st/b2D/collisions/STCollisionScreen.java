package com.nzt.gdx.test.trials.st.b2D.collisions;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nzt.gdx.ashley.components.renders.SpriteComponent;
import com.nzt.gdx.ashley.systems.render.SpriteRenderSystem;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.test.trials.st.b2D.B2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseB2DSystemScreen;

abstract class STCollisionScreen extends BaseB2DSystemScreen {
    protected final Texture badLogicTexture;
    protected FixtureDefWrapper fixture1, fixture2, fixture3, fixture4;

    public STCollisionScreen(FastTesterMain main) {
        super(main);
        badLogicTexture = new Texture("badlogic.jpg");
        SpriteRenderSystem spriteRenderSystem = new SpriteRenderSystem(camera, spriteBatch);
        engine.addSystem(spriteRenderSystem);

        fixture1 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
        fixture2 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
        fixture3 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
        fixture4 = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
                .setDensity(1).setToPPM(false);
        setFilters();
        // categoryBits
        // maskBits
        // groupIndex
        HudDebug.addTopLeft("fixture1=normal", fixture1.filterToString());
        HudDebug.addTopLeft("fixture2=RED", fixture2.filterToString());
        HudDebug.addTopLeft("fixture3=BLUE", fixture3.filterToString());
        HudDebug.addTopLeft("fixture4=GREEN", fixture4.filterToString());

        createBody(50, fixture1);
        createBody(25, fixture1);
        createBody(10, fixture1);

        createBody(50, fixture2);
        createBody(25, fixture2);
        createBody(10, fixture2);

        createBody(50, fixture3);
        createBody(25, fixture3);
        createBody(10, fixture3);

        createBody(50, fixture4);
        createBody(25, fixture4);
        createBody(10, fixture4);
        createWallScreen();
    }

    protected abstract void setFilters();

    protected void createBody(float size, FixtureDefWrapper fixtureDefWrapper) {
        size /= PPM;
        float randomW = MathUtils.random(-B2DTestConstants.WIDTH_PPM / 2, B2DTestConstants.WIDTH_PPM / 2);
        float randomH = MathUtils.random(-B2DTestConstants.HEIGHT_PPM / 2, B2DTestConstants.HEIGHT_PPM / 2);
        Body circleBody = bodyFactory.createCircleBody(new Vector2(randomW, randomH), size, fixtureDefWrapper);
        Entity entity = addEntityBody(circleBody);
        entity.add(entityFactory.mvtFactory.position());
        SpriteComponent spriteComponent = entityFactory.rendersFactory.sprite(badLogicTexture, size * 2);
        entity.add(spriteComponent);

        if (fixtureDefWrapper == fixture2) {
            spriteComponent.sprite.setColor(Color.RED);
        } else if (fixtureDefWrapper == fixture3) {
            spriteComponent.sprite.setColor(Color.BLUE);
        } else if (fixtureDefWrapper == fixture4) {
            spriteComponent.sprite.setColor(Color.GREEN);
        }
    }

    @Override
    public void doDispose() {
        badLogicTexture.dispose();
    }
}
