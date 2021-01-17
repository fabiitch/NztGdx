package com.nzt.gdx.scene2D;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nzt.gdx.math.Percentage;

/**
 * {@link com.badlogic.gdx.scenes.scene2d.Stage} extended with percent placement
 * for scale with size of screen
 */
public class NzStage extends Stage {

    public NzStage() {
        super(new ScreenViewport());
    }

    public void resize(int width, int height) {
        this.getViewport().update(width, height);
//        resizeAllActors()
    }
    public void setSizeByPercent(Actor actor, float percentWitdh, float percentHeight) {
        setWidthPercent(actor,percentWitdh);
//        setHeightPercent();
    }

    public void setWidthPercent(Actor actor, float percentWitdh) {
        actor.setWidth(Percentage.getValue(percentWitdh, this.getWidth()));
    }

    public void setHeightPercent(Actor actor, float percentHeight) {
        actor.setWidth(Percentage.getValue(percentHeight, this.getWidth()));
    }
}
