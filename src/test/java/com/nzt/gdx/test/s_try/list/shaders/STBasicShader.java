package com.nzt.gdx.test.s_try.list.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "shaders")
public class STBasicShader extends ScreenTry {

    private final Sprite sprite;
    private final Texture texture;

    public STBasicShader(FastTesterMain main) {
        super(main, true);

        texture = new Texture("badlogic.jpg");
        sprite = new Sprite(texture);

        sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);

        main.logManager.nzGlProfiler.active();
        main.logManager.nzGlProfiler.initHudDebug(HudDebugPosition.TOP_RIGHT, Color.WHITE);
    }

    @Override
    public String getTestExplication() {
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
