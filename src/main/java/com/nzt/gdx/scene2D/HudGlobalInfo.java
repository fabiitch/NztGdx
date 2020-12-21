package com.nzt.gdx.scene2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class HudGlobalInfo {

    Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
    Label labelFPS;
    Label labelDelta;
    Label labelNativeHeap;
    Label labelJavaHeap;

    public HudGlobalInfo(Stage stage) {
        labelFPS = new Label("FPS : ", skin);
        labelFPS.setPosition(10, stage.getHeight() - stage.getHeight() / 10 - 50);
        stage.addActor(labelFPS);

        labelDelta = new Label("DT : ", skin);
        labelDelta.setPosition(10, labelFPS.getY() - labelFPS.getHeight());
        stage.addActor(labelDelta);

        labelNativeHeap = new Label("NativeHeap : 50", skin);
        labelNativeHeap.setPosition(10, labelDelta.getY() - labelDelta.getHeight());
        stage.addActor(labelNativeHeap);

        labelJavaHeap = new Label("JavaHeap : 50", skin);
        labelJavaHeap.setPosition(10, labelNativeHeap.getY() - labelNativeHeap.getHeight());
        stage.addActor(labelJavaHeap);
    }

    public void update(float dt) {
        labelFPS.setText("FPS : " + Gdx.graphics.getFramesPerSecond());
        labelDelta.setText("DT : " + dt);
        labelNativeHeap.setText("NativeHeap :" + Gdx.app.getNativeHeap());
        labelJavaHeap.setText("JavaHeap :" + Gdx.app.getJavaHeap());
    }
}
