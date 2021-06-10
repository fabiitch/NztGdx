package com.nzt.gdx.debug.hud.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.actors.HudDebugActor;
import com.nzt.gdx.debug.hud.core.HudDebugLabel;

import java.util.Collection;
import java.util.Map;

public class HudDebugUtils {
    private final static float standartRight = 100;

    private HudDebugUtils() {

    }

    public static void replaceLabels(int positionOnStage, int atPosition, Stage stage,
                                     Map<String, HudDebugActor> mapActors) {
        Collection<HudDebugActor> allActors = mapActors.values();
        for (HudDebugActor hudLabel : allActors) {
            if (hudLabel.positionOnStage == positionOnStage && hudLabel.position > atPosition) {
                hudLabel.position--;
                setDebugLabelPosition(stage, hudLabel);
            }
        }
    }

    public static void setDebugLabelPosition(Stage stage, HudDebugActor hudDebugActor) {
        Actor actor = hudDebugActor.actor;
        switch (hudDebugActor.positionOnStage) {
            case HudDebugPosition.TOP_LEFT:
                hudDebugActor.setPosition(1, stage.getViewport().getWorldHeight() - actor.getHeight() * hudDebugActor.position - 1);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                hudDebugActor.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 20,
                        stage.getViewport().getWorldHeight() - actor.getHeight() * hudDebugActor.position - 1);
                break;
            case HudDebugPosition.TOP_RIGHT:
                float witdhMax = Math.max(actor.getWidth(), standartRight);
                hudDebugActor.setPosition(stage.getViewport().getWorldWidth() - witdhMax - 10,
                        stage.getViewport().getWorldHeight() - actor.getHeight() * hudDebugActor.position - 1);
                break;
            case HudDebugPosition.BOT_LEFT:
                hudDebugActor.setPosition(4, actor.getHeight() * (hudDebugActor.position - 1) + 1);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                float x = Math.max(actor.getWidth() + 2, standartRight);
                hudDebugActor.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 20,
                        actor.getHeight() * (hudDebugActor.position - 1) + 1);
                break;
            case HudDebugPosition.BOT_RIGHT:
                x = Math.max(actor.getWidth() + 2, standartRight);
                hudDebugActor.setPosition(stage.getViewport().getWorldWidth() - x, actor.getHeight() * (hudDebugActor.position - 1) + 1);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                hudDebugActor.setPosition(1, stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6
                        - actor.getHeight() * hudDebugActor.position - 1 - Gdx.graphics.getSafeInsetTop());
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                x = Math.max(actor.getWidth() + 2, standartRight);
                hudDebugActor.setPosition(stage.getViewport().getWorldWidth() - x,
                        stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6
                                - actor.getHeight() * hudDebugActor.position - 1 - Gdx.graphics.getSafeInsetTop());
                break;
            default:
                break;
        }
    }

}
