package com.nzt.gdx.test.s_try.list.t3d;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class CameraInputControllerFR extends CameraInputController {

    public CameraInputControllerFR(Camera camera) {
        super(camera);
        this.rotateRightKey = Input.Keys.Q;
        this.forwardKey = Input.Keys.Z;
    }
}
