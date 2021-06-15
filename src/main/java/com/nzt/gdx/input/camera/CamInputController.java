package com.nzt.gdx.input.camera;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class CamInputController extends CameraInputController implements CamController {
    protected CamInputController(CameraGestureListener gestureListener, Camera camera) {
        super(gestureListener, camera);
    }

    public CamInputController(Camera camera) {
        super(camera);
    }

    @Override
    public void update(float dt) {
        update();
    }
}
