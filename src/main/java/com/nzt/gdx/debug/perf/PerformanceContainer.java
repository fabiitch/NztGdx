package com.nzt.gdx.debug.perf;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.BaseScreen;

class PerformanceContainer {
    private HashMap<String, HashMap<String, PerformanceAction>> mapByScreen;
    private HashMap<String, PerformanceAction> currentMap;
    private Array<PerformanceAction> currentArrayOrdered;

    public Array<PerformanceAction> getActions() {
        currentArrayOrdered.sort();
        return currentArrayOrdered;
    }

    public PerformanceContainer() {
        this.mapByScreen = new HashMap<>();
        this.currentArrayOrdered = new Array<>();
    }

    public void changeScreen(AbstractScreen screen) {
        currentArrayOrdered.clear();
        HashMap<String, PerformanceAction> mapForScreen = mapByScreen.get(screen.getClass().getSimpleName());
        if (mapForScreen == null) {
            mapForScreen = new HashMap<>();
            mapByScreen.put(screen.getClass().getSimpleName(), mapForScreen);
        } else {
            for (PerformanceAction value : mapForScreen.values()) {
                currentArrayOrdered.add(value);
            }
        }
        this.currentMap = mapForScreen;
    }

    public void add(String action) {
        PerformanceAction perfAction = currentMap.get(action);
        if (perfAction == null) {
            perfAction = new PerformanceAction(action);
            currentMap.put(action, perfAction);
            currentArrayOrdered.add(perfAction);
        }
    }

    public void remove(String action) {
        PerformanceAction perfAction = currentMap.get(action);
        if (perfAction != null) {
            currentMap.remove(action);
            currentArrayOrdered.removeValue(perfAction, true);
            perfAction = null;
        }
    }

    public void startAction(String action) {
        currentMap.get(action).start();
    }

    public void endAction(String action) {
        currentMap.get(action).end();
    }

    public void endFrame(long frameTime) {
        for (PerformanceAction count : currentMap.values()) {
            count.endFrame(frameTime);
        }
    }

    public void resetAll() {
        currentMap.clear();
        currentArrayOrdered.clear();
        mapByScreen.clear();
    }

    public void resetScreen(AbstractScreen screen) {
        HashMap<String, PerformanceAction> mapForScreen = mapByScreen.get(screen.getClass().getSimpleName());
        if (mapForScreen != null)
            mapForScreen.clear();
        mapByScreen.remove(screen);

    }
}
