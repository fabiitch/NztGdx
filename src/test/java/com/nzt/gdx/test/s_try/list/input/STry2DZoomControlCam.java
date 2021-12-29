package com.nzt.gdx.test.s_try.list.input;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.input.camera.Cam2DController;
import com.nzt.gdx.input.camera.Cam2DZoomController;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;

public class STry2DZoomControlCam extends BaseSTry2DControlCam {

    private final Cam2DController cam2DController;

    public STry2DZoomControlCam(FastTesterMain main) {
        super(main);
        this.cam2DController = new Cam2DZoomController(camera);
        Gdx.input.setInputProcessor(cam2DController);
    }

    @Override
    public String getTestExplication() {
        return "Camera control en 2D with Zoom   T / G for zoom";
    }

    @Override
    public void renderTestScreen(float dt) {
        cam2DController.update(dt);
        super.renderTestScreen(dt);
    }

}
