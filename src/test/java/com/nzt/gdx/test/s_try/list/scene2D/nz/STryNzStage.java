package com.nzt.gdx.test.s_try.list.scene2D.nz;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "scene2D")
public class STryNzStage extends SimpleTestScreen {
    private final NzStage nzStage;
    private final Image img1;
    private final Texture texture;

    public STryNzStage(FastTesterMain main) {
        super(main);
        nzStage = new NzStage();
        texture = new Texture("badlogic.jpg");
//
        img1 = new Image(texture);
        nzStage.addActor(img1);
        nzStage.setDebugAll(true);

        createInputListener(img1, "img1");
        nzStage.getPositionner(img1, true).setSizeByPercent(50, 50).setPositionByPercent(50, 50);
    }

    @Override
    public void renderScreen(float dt) {
        nzStage.act();
        nzStage.draw();
    }

    @Override
    public void doResize(int width, int height) {
        nzStage.resize(width, height);
//		img1.setPosition(0, 0);
    }

    private void createInputListener(Actor actor, final String sout) {
        InputListener listener = new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("touchec :" + sout);
                return true;
            }
        };
        actor.addListener(listener);
    }

    @Override
    public void doDispose() {
        nzStage.dispose();
        texture.dispose();
    }
}
