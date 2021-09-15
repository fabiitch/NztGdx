package com.nzt.gdx.input.camera;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

//TODO android zoom
public class Cam2DZoomController extends Cam2DController {

    public float zoomVelocity = 0.5f;

    public int ZOOM = Input.Keys.T;
    public int DEZOOM = Input.Keys.G;

    private final boolean isOrthoCam;
    private OrthographicCamera orthoCam;

    public Cam2DZoomController(Camera camera) {
        super(camera);
        isOrthoCam = camera instanceof OrthographicCamera;
        if (isOrthoCam)
            orthoCam = (OrthographicCamera) camera;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == UP || keycode == DOWN || keycode == STRAFE_LEFT || keycode == STRAFE_RIGHT || keycode == ZOOM || keycode == DEZOOM)
            keys.put(keycode, keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == UP || keycode == DOWN || keycode == STRAFE_LEFT || keycode == STRAFE_RIGHT || keycode == ZOOM || keycode == DEZOOM)
            keys.remove(keycode, 0);
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        if (isOrthoCam) {
            orthoCam.zoom += amountY * zoomVelocity;
        } else {
            camera.position.z += amountY * zoomVelocity;
        }
        return true;
    }

}
