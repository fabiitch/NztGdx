package com.nzt.gdx.input.camera;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;

public class FirstPersonCamController extends FirstPersonCameraController implements CamController {
    public FirstPersonCamController(Camera camera) {
        super(camera);
    }
}
