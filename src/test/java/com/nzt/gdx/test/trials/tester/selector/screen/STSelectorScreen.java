package com.nzt.gdx.test.trials.tester.selector.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.scene2D.StagePlacementUtils;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

import java.lang.reflect.Constructor;

/*
 * test screen selector
 * add ur screen in screensClasses
 */
public class STSelectorScreen extends SimpleScreen<ScreenSelectorTestMain> {

	private final NzStage stage;
	private final Skin skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));

	public STSelectorScreen(ScreenSelectorTestMain main, CaseST rootCaseTest) {
		super(main);
		stage = new NzStage();
		Gdx.input.setInputProcessor(stage);
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		table.row().size(stage.getHeight() / 8);
		int i = 0;
		if (rootCaseTest.isGroup) {
			main.lastGroupCase = rootCaseTest.parent;
			Label nameLabel = new Label(STScanner.getNameOfGroupAndParent(rootCaseTest), skin);
			StagePlacementUtils.placeCenterX(nameLabel, Gdx.graphics.getWidth() / 2);
			StagePlacementUtils.placeCenterY(nameLabel, Gdx.graphics.getHeight() - 50);
			stage.addActor(nameLabel);
		}

		for (CaseST caseTest : rootCaseTest.childs) {
			TextButton textButton = new TextButton(caseTest.getDisplayedName(), skin);
			table.add(textButton).width(stage.getWidth() / 4);
			if (caseTest.isGroup) {
				textButton.setColor(Color.RED);
			}
			createInputListener(textButton, caseTest);
			i++;
			if (i % 4 == 0) {
				table.row().size(stage.getHeight() / 8);
			}
		}
	}

	private void createInputListener(Actor actor, final CaseST caseTest) {
		InputListener listener = new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				try {
					main.lastGroupCase = caseTest.parent;
					if (caseTest.isGroup) {
						STSelectorScreen groupScreen = new STSelectorScreen(main, caseTest);
						main.screenManager.setScreen((AbstractScreen) groupScreen);
					} else {
						Constructor cons = caseTest.classTest.getConstructor(FastTesterMain.class);
						Object newInstance = cons.newInstance(main);
						main.screenManager.setScreen((AbstractScreen<AbstractMain>) newInstance);
					}

				} catch (Exception e) {
					if (caseTest.isGroup)
						System.out.println("Cant instance selector group for " + caseTest.name);
					else
						System.out.println("Cant instance class for " + caseTest.classTest.getSimpleName());
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

	@Override
	public void doDispose() {
		stage.dispose();
		skin.dispose();
	}

}
