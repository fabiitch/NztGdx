package com.nzt.gdx.test.trials.st.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "shaders")
public class STBasicShader extends TestScreen {

	private Sprite sprite;
	private Texture texture;

	public STBasicShader(FastTesterMain main) {
		super(main);

		texture = new Texture("badlogic.jpg");
		sprite = new Sprite(texture);

		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);

		main.logManager.nzGlProfiler.active();
		main.logManager.nzGlProfiler.initHudDebug(HudDebugPosition.TOP_RIGHT, Color.WHITE);
	}

	@Override
	public String getExplication() {
		return "Shader discover";
	}

	@Override
	public void renderTestScreen(float dt) {
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		spriteBatch.end();
		main.logManager.nzGlProfiler.updateHudDebug();

	}

	@Override
	public void disposeTestScreen() {
		main.logManager.nzGlProfiler.desactive();
		texture.dispose();

	}
}
