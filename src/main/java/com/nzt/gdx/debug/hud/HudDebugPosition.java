package com.nzt.gdx.debug.hud;

/**
 * Mapping for position on HudDebug
 */
public class HudDebugPosition {

    public static final int TOP_LEFT = 1;
    public static final int TOP_MIDDLE = 2;
    public static final int TOP_RIGHT = 3;

    public static final int BOT_LEFT = 4;
    public static final int BOT_MIDDLE = 5;
    public static final int BOT_RIGHT = 6;

    public static final int LEFT_MIDDLE = 7;
    public static final int RIGHT_MIDDLE = 8;


    public static boolean isLeft(int positionOnStage) {
        return positionOnStage == TOP_LEFT || positionOnStage == BOT_LEFT || positionOnStage == LEFT_MIDDLE;
    }

    public static boolean isRight(int positionOnStage) {
        return positionOnStage == TOP_RIGHT || positionOnStage == BOT_RIGHT || positionOnStage == RIGHT_MIDDLE;
    }

    public static boolean isTop(int positionOnStage) {
        return positionOnStage == TOP_LEFT || positionOnStage == TOP_MIDDLE || positionOnStage == TOP_RIGHT;
    }

    public static boolean isBot(int positionOnStage) {
        return positionOnStage == BOT_LEFT || positionOnStage == BOT_MIDDLE || positionOnStage == BOT_RIGHT;
    }

    public static boolean isMiddleHorizontal(int positionOnStage) {
        return positionOnStage == TOP_MIDDLE || positionOnStage == BOT_MIDDLE;
    }

    public static boolean isMiddleVertical(int positionOnStage) {
        return positionOnStage == LEFT_MIDDLE || positionOnStage == RIGHT_MIDDLE;
    }
}
