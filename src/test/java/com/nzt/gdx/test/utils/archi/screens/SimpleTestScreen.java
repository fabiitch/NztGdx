package com.nzt.gdx.test.utils.archi.screens;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.utils.Strings;

public abstract class SimpleTestScreen extends SimpleScreen<AbstractMain> {

    private final static String FPS = "  FPS : ";
    private final String className;

    public SimpleTestScreen(AbstractMain main) {
        super(main);
        if (this.getClass().getSimpleName().startsWith("ST"))
            className = this.getClass().getSimpleName().substring(2);
        else
            className = this.getClass().getSimpleName();
    }

    @Override
    public void setTitle(float dt) {
        String title = Strings.getBuilder().append(className).append(FPS).append(Gdx.graphics.getFramesPerSecond()).toString();
        Gdx.graphics.setTitle(title);
    }
}
