package com.nzt.gdx.test.trials.st.perf;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.ashley.base.factories.EntityFactory;
import com.nzt.gdx.ashley.systems.mvt.Velocity2DSystem;
import com.nzt.gdx.ashley.systems.render.ShapeRenderSystem;
import com.nzt.gdx.ashley.systems.render.SpriteRenderSystem;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "perf")
public class STPerformanceFrame extends TestScreenWithHudDebug {

	Engine engine;
	EntityFactory factory;
	Texture texture = new Texture("badlogic.jpg");

	Camera camera;

	HudDebugPerformanceFrame perf;

	public STPerformanceFrame(FastTesterMain main) {
		super(main);
		glProfiler.removeHudDebug();
		engine = new Engine();
		factory = new EntityFactory(engine);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		engine.addSystem(new SpriteRenderSystem(camera, main.sb));
		for (int i = 0; i < 10; i++) {
			Sprite sprite = new Sprite(texture);
			sprite.setBounds(i * 50, 0, 50, 50);
			factory.rendersFactory.sprite(sprite);
		}

		engine.addSystem(new ShapeRenderSystem(main.nzShapeRenderer));
		engine.addSystem(new Velocity2DSystem());

		perf = new HudDebugPerformanceFrame(HudDebugPosition.TOP_LEFT, Color.CYAN);
	}

	@Override
	public void renderAfterHud(float dt) {
		perf.update(dt);
	}

}
