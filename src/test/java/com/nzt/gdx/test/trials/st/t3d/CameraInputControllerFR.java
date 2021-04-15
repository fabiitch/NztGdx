package com.nzt.gdx.test.trials.st.t3d;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class CameraInputControllerFR extends CameraInputController {
    protected CameraInputControllerFR(CameraGestureListener gestureListener, Camera camera) {
        super(gestureListener, camera);
        this.mapInput();
    }

    public CameraInputControllerFR(Camera camera) {
        super(camera);
        this.mapInput();
    }

    private void mapInput() {
        this.rotateRightKey = Input.Keys.Q;
        this.forwardKey = Input.Keys.Z;
    }
}
