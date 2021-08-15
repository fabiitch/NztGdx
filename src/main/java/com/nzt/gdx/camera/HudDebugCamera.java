package com.nzt.gdx.camera;


import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;

public class HudDebugCamera {
    public final static String KEY_CAM_HUD_DEBUG = "CameraDebug_";

    public Camera camera;
    public int positionOnStage;
    public Color color;

    private final String keyCamPos, keyCamDir, keyCamUp;

    public HudDebugCamera(Camera camera, int positionOnStage, Color color) {
        this.camera = camera;
        this.positionOnStage = positionOnStage;
        this.color = color;
        this.keyCamPos = KEY_CAM_HUD_DEBUG + "POS";
        this.keyCamDir = KEY_CAM_HUD_DEBUG + "DIR";
        this.keyCamUp = KEY_CAM_HUD_DEBUG + "UP";
        addToHud();
    }

    public HudDebugCamera(Camera camera, int positionOnStage) {
        this(camera, positionOnStage, Color.WHITE);
    }

    public HudDebugCamera(Camera camera) {
        this(camera, HudDebugPosition.TOP_LEFT, Color.WHITE);
    }

    public void addToHud() {
        HudDebug.add(keyCamPos, "CamPos", camera.position, positionOnStage, color);
        HudDebug.add(keyCamDir, "CamDir", camera.direction, positionOnStage, color);
        HudDebug.add(keyCamUp, "CamUp", camera.up, positionOnStage, color);
    }

    public void removeFromHud() {
        HudDebug.removeGroup(KEY_CAM_HUD_DEBUG);
    }

    public void update() {
        HudDebug.update(keyCamPos, "CamPos", camera.position);
        HudDebug.update(keyCamDir, "CamDir", camera.direction);
        HudDebug.update(keyCamUp, "CamUp", camera.up);
    }
}
