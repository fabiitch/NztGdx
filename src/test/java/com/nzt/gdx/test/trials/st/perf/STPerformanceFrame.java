package com.nzt.gdx.test.trials.st.perf;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.ashley.base.factories.BaseEntityFactory;
import com.nzt.gdx.ashley.systems.mvt.Velocity2DSystem;
import com.nzt.gdx.ashley.systems.render.ShapeRenderSystem;
import com.nzt.gdx.ashley.systems.render.SpriteRenderSystem;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "utils.perf")
public class STPerformanceFrame extends TestScreen {
    Engine engine;
    BaseEntityFactory factory;
    Texture texture = new Texture("badlogic.jpg");

    Camera camera;
    HudDebugPerformanceFrame perf;

    public STPerformanceFrame(FastTesterMain main) {
        super(main);
        engine = new Engine();
        factory = new BaseEntityFactory(engine);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        engine.addSystem(new SpriteRenderSystem(camera, main.sb));
        for (int i = 0; i < 10; i++) {
            Sprite sprite = new Sprite(texture);
            sprite.setBounds(i * 50, 0, 50, 50);
            factory.createEntity().add(factory.rendersFactory.sprite(sprite));
        }

        engine.addSystem(new ShapeRenderSystem(main.nzShapeRenderer));
        engine.addSystem(new Velocity2DSystem());

        perf = new HudDebugPerformanceFrame(HudDebugPosition.TOP_LEFT, Color.CYAN);
    }

    @Override
    public String getTestExplication() {
        return "Performance frame Test";
    }

    @Override
    public void renderTestScreen(float dt) {
        camera.update();
        engine.update(dt);
        perf.update(dt);
    }

    @Override
    public void disposeTestScreen() {
        texture.dispose();
    }

}
