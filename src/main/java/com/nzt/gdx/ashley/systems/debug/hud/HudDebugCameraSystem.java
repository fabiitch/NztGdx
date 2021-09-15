package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.camera.HudDebugCamera;
import com.nzt.gdx.debug.hud.HudDebugPosition;

public class HudDebugCameraSystem extends EntitySystem {
    private final HudDebugCamera hudDebugCamera;

    public HudDebugCameraSystem(Camera camera, int positionOnStage, Color color) {
        this.hudDebugCamera = new HudDebugCamera(camera, positionOnStage, color);
    }

    public HudDebugCameraSystem(Camera camera, int positionOnStage) {
        this(camera, positionOnStage, Color.WHITE);
    }

    public HudDebugCameraSystem(Camera camera) {
        this(camera, HudDebugPosition.TOP_LEFT, Color.WHITE);
    }

    public void update(float deltaTime) {
        hudDebugCamera.update();
    }

}
