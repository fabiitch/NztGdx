package com.nzt.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class GdxUtils {

    private GdxUtils() {

    }

    public static long getHeapMb() {
        return Gdx.app.getJavaHeap() / (1024L * 1024L);
    }

    public static long getNativeHeapMb() {
        return Gdx.app.getNativeHeap() / (1024L * 1024L);
    }
    public static boolean isDesktop() {
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }

    public static boolean isHeadless() {
        return Gdx.app.getType() == Application.ApplicationType.HeadlessDesktop;
    }

    public static boolean isWeb() {
        return Gdx.app.getType() == Application.ApplicationType.WebGL;
    }

    public static boolean isMobile() {
        return isAndroid() || isIos();
    }

    public static boolean isAndroid() {
        return Gdx.app.getType() == Application.ApplicationType.Android;
    }

    public static boolean isIos() {
        return Gdx.app.getType() == Application.ApplicationType.iOS;
    }

    public static Vector2 getScreenCenter(Vector2 pos) {
        return pos.set(getScreenCenterX(), getScreenCenterY());
    }

    public static float getScreenCenterX() {
        return Gdx.graphics.getWidth() / 2;
    }

    public static float getScreenCenterY() {
        return Gdx.graphics.getHeight() / 2;
    }
}
