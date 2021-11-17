package com.nzt.gdx.test.api.debug.hud;

import com.nzt.gdx.debug.hud.HudDebugPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HudDebugPositionTest {


    @Test
    public void isLeftTest() {
        Assertions.assertEquals(true, HudDebugPosition.isLeft(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isLeft(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isLeft(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(true, HudDebugPosition.isLeft(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isLeft(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isLeft(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(true, HudDebugPosition.isLeft(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isLeft(HudDebugPosition.RIGHT_MIDDLE));
    }

    @Test
    public void isRightTest() {
        Assertions.assertEquals(false, HudDebugPosition.isRight(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isRight(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isRight(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isRight(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isRight(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isRight(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isRight(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isRight(HudDebugPosition.RIGHT_MIDDLE));
    }

    @Test
    public void isTopTest() {
        Assertions.assertEquals(true, HudDebugPosition.isTop(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(true, HudDebugPosition.isTop(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isTop(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isTop(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isTop(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isTop(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isTop(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isTop(HudDebugPosition.RIGHT_MIDDLE));
    }

    @Test
    public void isBotTest() {
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.RIGHT_MIDDLE));
    }

    @Test
    public void isMiddleHorizontal() {
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.RIGHT_MIDDLE));
    }

    @Test
    public void isMiddleVertical() {
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.TOP_RIGHT));

        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.BOT_LEFT));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.BOT_MIDDLE));
        Assertions.assertEquals(false, HudDebugPosition.isBot(HudDebugPosition.BOT_RIGHT));

        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.LEFT_MIDDLE));
        Assertions.assertEquals(true, HudDebugPosition.isBot(HudDebugPosition.RIGHT_MIDDLE));
    }
}
