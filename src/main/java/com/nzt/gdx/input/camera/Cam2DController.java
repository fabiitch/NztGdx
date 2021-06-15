package com.nzt.gdx.input.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntIntMap;

public class Cam2DController extends InputAdapter implements CamController {

    public Camera camera;
    public float degreesPerPixel = 0.5f;
    public float velocity = 150;

    public boolean autoUpdate = true;

    public int UP = Input.Keys.W;
    public int DOWN = Input.Keys.S;
    public int STRAFE_LEFT = Input.Keys.A;
    public int STRAFE_RIGHT = Input.Keys.D;

    protected final IntIntMap keys = new IntIntMap();
    protected final Vector3 tmp = new Vector3();

    public Cam2DController(Camera camera) {
        this.camera = camera;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == UP || keycode == DOWN || keycode == STRAFE_LEFT || keycode == STRAFE_RIGHT)
            keys.put(keycode, keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == UP || keycode == DOWN || keycode == STRAFE_LEFT || keycode == STRAFE_RIGHT)
            keys.remove(keycode, 0);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float deltaX = -Gdx.input.getDeltaX() * degreesPerPixel;
        float deltaY = Gdx.input.getDeltaY() * degreesPerPixel;
        camera.position.add(deltaX, deltaY, 0);
        return true;
    }

    public void update(float deltaTime) {
        if (keys.containsKey(STRAFE_LEFT)) {
            tmp.set(camera.direction).crs(camera.up).nor().scl(-deltaTime * velocity);
            camera.position.add(tmp);
        }
        if (keys.containsKey(STRAFE_RIGHT)) {
            tmp.set(camera.direction).crs(camera.up).nor().scl(deltaTime * velocity);
            camera.position.add(tmp);
        }
        if (keys.containsKey(UP)) {
            tmp.set(camera.up).nor().scl(deltaTime * velocity);
            camera.position.add(tmp);
        }
        if (keys.containsKey(DOWN)) {
            tmp.set(camera.up).nor().scl(-deltaTime * velocity);
            camera.position.add(tmp);
        }
        if (autoUpdate)
            camera.update(true);
    }
}
