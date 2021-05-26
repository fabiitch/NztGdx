package com.nzt.gdx.debug.perf;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.BaseScreen;

/**
 * Simple static class to Use PerformanceContainer
 */
public class PerformanceFrame {

    private static PerformanceFrame instance = new PerformanceFrame();
    private final PerformanceContainer container;

    public static boolean enabled = true;

    public static long timeLastFrame;
    public static long timeFrameAverage;

    private static long nanoStartFrame;

    private PerformanceFrame() {
        this.container = new PerformanceContainer();
    }

    public static void setScreen(AbstractScreen screen) {
        if (enabled)
            instance.container.changeScreen(screen);
    }

    public static void startFrame() {
        if (enabled)
            nanoStartFrame = System.nanoTime();
    }

    public static Array<PerformanceAction> getActions() {
        return instance.container.getActions();
    }

    public static void endFrame() {
        if (enabled) {
            long stopTime = System.nanoTime();
            timeLastFrame = stopTime - nanoStartFrame;
            instance.container.endFrame(timeLastFrame);
        }
    }

    public static void keepOnlySystem(Class systemClass) {
        if (enabled)
            instance.container.keepOnly(systemClass.getSimpleName());
    }

    public static void keepOnly(String action) {
        if (enabled)
            instance.container.keepOnly(action);
    }

    public static void remove(String action) {
        if (enabled)
            instance.container.remove(action);
    }

    public static void add(String action) {
        if (enabled)
            instance.container.add(action);
    }

    public static void startAction(String action) {
        if (enabled)
            instance.container.startAction(action);
    }

    public static void endAction(String action) {
        if (enabled)
            instance.container.endAction(action);
    }

    public static void removeScreen(AbstractScreen screen) {
        instance.container.resetScreen(screen);
    }

    public static void resetAll() {
        instance.container.resetAll();
    }

    public static void addSystem(EntitySystem system) {
        add(system.getClass().getSimpleName());
    }

    public static void removeSystem(EntitySystem system) {
        remove(system.getClass().getSimpleName());
    }

    public static void startSystem(EntitySystem system) {
        startAction(system.getClass().getSimpleName());
    }

    public static void endSystem(EntitySystem system) {
        endAction(system.getClass().getSimpleName());
    }

}
