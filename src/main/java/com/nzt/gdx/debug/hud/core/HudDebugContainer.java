package com.nzt.gdx.debug.hud.core;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.actors.HudDebugActor;
import com.nzt.gdx.debug.hud.utils.HudDebugPreInitItem;
import com.nzt.gdx.debug.hud.utils.HudDebugUtils;

import java.util.HashMap;
import java.util.Map;

//TODO padding on android
class HudDebugContainer {

    private final Stage stage;

    private int indexAtPos[] = new int[8];
    private final Map<String, HudDebugActor> mapActors;

    public HudDebugContainer(Stage stage) {
        this.stage = stage;
        this.mapActors = new HashMap<>();
    }

    public HudDebugActor get(String key) {
        return mapActors.get(key);
    }

    public void remove(String key) {
        HudDebugActor labelStage = mapActors.get(key);
        if (labelStage != null) {
            int positionOnStage = labelStage.positionOnStage;
            int positionLabel = labelStage.position;
            mapActors.remove(key);
            labelStage.remove();

            indexAtPos[positionOnStage]--;
            HudDebugUtils.replaceLabels(positionOnStage, positionLabel, stage, mapActors);
        }
    }

    public boolean exist(String label) {
        return mapActors.get(label) != null;
    }

    public void clear() {
        indexAtPos = new int[8];
        for (HudDebugActor hudDebugLabel : mapActors.values()) {
            hudDebugLabel.remove();
        }
        mapActors.clear();
    }

    public void addActor(String key, HudDebugActor hudDebugActor) {
        indexAtPos[hudDebugActor.positionOnStage]++;
        stage.addActor(hudDebugActor.actor);
        mapActors.put(key, hudDebugActor);
        HudDebugUtils.setDebugLabelPosition(stage, hudDebugActor);
    }

    public void addActor(String key, int positionOnStage, Actor actor) {
        indexAtPos[positionOnStage]++;
        stage.addActor(actor);
        HudDebugActor hudDebugActor = new HudDebugActor(positionOnStage, indexAtPos[positionOnStage], actor);
        mapActors.put(key, hudDebugActor);
        HudDebugUtils.setDebugLabelPosition(stage, hudDebugActor);
    }

    public void addItem(HudDebugPreInitItem item) {
        this.addActor(item.key, item.positionOnStage, item.actor);
    }
}
