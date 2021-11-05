package com.nzt.gdx.input.impl.simple;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.math.vectors.V3;

//TODO a voir si on met pas ds test
public abstract class SimpleClickInputHandler extends MouseInputHandler {

    public final static int LEFT_CLICK = 0;
    public final static int RIGHT_CLICK = 1;
    public final static int WHEEL_CLICK = 2;

    public SimpleClickInputHandler() {
        super();
    }

    public Vector3 getClickPos(Camera camera, int screenX, int screenY, Vector3 clickPos) {
        return camera.unproject(clickPos.set(screenX, screenY, 0));
    }

    public Vector2 getClickPos(Camera camera, int screenX, int screenY, Vector2 clickPos) {
        return V2.set(clickPos, camera.unproject(V3.tmp(screenX, screenY)));
    }

    public Vector2 getClickPos(Camera camera, int screenX, int screenY) {
        return V2.set(new Vector2(), camera.unproject(V3.tmp(screenX, screenY)));
    }


    public Vector2 getClickPos(int screenX, int screenY, Vector2 clickPos) {
        return clickPos.set(screenX, Gdx.graphics.getHeight() - screenY);
    }

    public Vector2 getClickPos(int screenX, int screenY) {
        return new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
    }

    public SimpleClickInputHandler(InputLoggerConfig loggerConfig) {
        super(loggerConfig);
    }

    public abstract boolean click(int screenX, int screenY, int pointer, int button);

    public  boolean endClick(int screenX, int screenY, int pointer, int button){
        return false;
    }

    @Override
    public boolean doTouchDown(int screenX, int screenY, int pointer, int button) {
        return click(screenX, screenY, pointer, button);
    }

    @Override
    public boolean doTouchUp(int screenX, int screenY, int pointer, int button) {
        return endClick(screenX, screenY, pointer, button);
    }
}
