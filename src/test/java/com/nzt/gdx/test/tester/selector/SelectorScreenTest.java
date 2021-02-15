package com.nzt.gdx.test.tester.selector;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.screens.Vector2TestScreen;
import com.nzt.gdx.test.screens.b2D.FixtureEventTestScreen;
import com.nzt.gdx.test.screens.b2D.TriangleBodyTestScreen;
import com.nzt.gdx.test.screens.scene2D.HudDebugDisplayScreen;
import com.nzt.gdx.test.screens.scene2D.NzStageTestScreen;
import com.nzt.gdx.test.screens.t3d.B2D3DTestScreen;
import com.nzt.gdx.test.screens.t3d.Basic3DTestScreen;
import com.nzt.gdx.test.screens.t3d.OrthoCam3DTest;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;

/*
 * test screen selector
 * add ur screen in screensClasses
 */
public class SelectorScreenTest extends SimpleScreen<AbstractMain> {

	private Class[] screensClasses = new Class[] { FixtureEventTestScreen.class, TriangleBodyTestScreen.class,
			B2D3DTestScreen.class, Basic3DTestScreen.class, OrthoCam3DTest.class, NzStageTestScreen.class,
			HudDebugDisplayScreen.class, Vector2TestScreen.class };

	private NzStage stage;
	Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

	public SelectorScreenTest(AbstractMain main) {
		super(main);
		stage = new NzStage();
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		table.row().size(stage.getHeight() / 8);
		int i = 0;
		for (Class screen : screensClasses) {
			TextButton textButton = new TextButton(screen.getSimpleName(), skin);
//			textButton.setWidth(stage.getWidth() / 4);
			table.add(textButton).width(stage.getWidth() / 4);
			createInputListener(textButton, screen);
			i++;
			if (i % 4 == 0) {
				table.row().size(stage.getHeight() / 8);
			}
		}
	}

	private void createInputListener(Actor actor, final Class screenClass) {
		InputListener listener = new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				try {
					Constructor cons = screenClass.getConstructor(FastTesterMain.class);
					Object newInstance = cons.newInstance(main);
					main.screenManager.setScreen((BaseScreen<AbstractMain>) newInstance);
					Gdx.input.setInputProcessor(null);
				} catch (Exception e) {
					System.out.println("Cant instance class " + screenClass);
					e.printStackTrace();
				}
				return true;
			}
		};
		actor.addListener(listener);
	}

	@Override
	protected void renderScreen(float dt) {
		stage.act();
		stage.draw();
	}

}
