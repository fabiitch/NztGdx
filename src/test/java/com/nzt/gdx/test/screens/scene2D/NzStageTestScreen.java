package com.nzt.gdx.test.screens.scene2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.tester.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

@TestScreen(groupName = {"scene2D"})
public class NzStageTestScreen extends SimpleTestScreen {

    public static void main(String args[]) {
        StarterTestConfig.startLwjgl(new FastTesterMain(NzStageTestScreen.class), 500, 400);
    }

    private NzStage nzStage;
    private Image img1;

    public NzStageTestScreen(FastTesterMain main) {
        super(main);
        nzStage = new NzStage();
        Texture txt = new Texture("badlogic.jpg");
//
        img1 = new Image(txt);
        nzStage.addActor(img1);
        nzStage.setDebugAll(true);

        createInputListener(img1, "img1");
        Gdx.input.setInputProcessor(nzStage);

        nzStage.getPositionner(img1, true).setSizeByPercent(50, 50).setPositionByPercent(50, 50);

    }

    @Override
    protected void renderScreen(float dt) {
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
}
