package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * ST for test Add and remove On HudDebug
 */
@TestScreenList(group = "scene2D.hud debug")
public class STHudDebugAddRemove extends TestScreen {

    private int topR, topM, topL, botR, botM, botL, rightM, leftM = 0;

    public STHudDebugAddRemove(FastTesterMain main) {
        super(main);

        glProfiler.desactive();
        glProfiler.removeHudDebug();
        // TOP LEFT
        TextButton topRAdd = new TextButton("+", skin);
        topRAdd.setColor(Color.RED);
        topRAdd.setZIndex(5);
        nzStage.getPositionner(topRAdd, true).setPositionByPercent(2, 95);
        addListener(topRAdd, HudDebugPosition.TOP_LEFT, true);

        TextButton topRRemove = new TextButton("-", skin);
        nzStage.getPositionner(topRRemove, true).setPositionByPercent(4, 95);
        addListener(topRRemove, HudDebugPosition.TOP_LEFT, false);

        nzStage.addActors(topRAdd, topRRemove);

        // TOP_Middle
        TextButton topMAdd = new TextButton("+", skin);
        nzStage.getPositionner(topMAdd, true).setPositionByPercent(50, 95);
        addListener(topMAdd, HudDebugPosition.TOP_MIDDLE, true);

        TextButton topMRemove = new TextButton("-", skin);
        nzStage.getPositionner(topMRemove, true).setPositionByPercent(52, 95);
        addListener(topMRemove, HudDebugPosition.TOP_MIDDLE, false);

        nzStage.addActors(topMAdd, topMRemove);

        // TOP_LEFT
        TextButton topLAdd = new TextButton("+", skin);
        nzStage.getPositionner(topLAdd, true).setPositionByPercent(95, 95);
        addListener(topLAdd, HudDebugPosition.TOP_RIGHT, true);

        TextButton topLRemove = new TextButton("-", skin);
        nzStage.getPositionner(topLRemove, true).setPositionByPercent(97, 95);
        addListener(topLRemove, HudDebugPosition.TOP_RIGHT, false);
        nzStage.addActors(topLAdd, topLRemove);

        // BOT_LEFT
        TextButton botLAdd = new TextButton("+", skin);
        nzStage.getPositionner(botLAdd, true).setPositionByPercent(2, 5);
        addListener(botLAdd, HudDebugPosition.BOT_LEFT, true);

        TextButton botLRemove = new TextButton("-", skin);
        nzStage.getPositionner(botLRemove, true).setPositionByPercent(4, 5);
        addListener(botLRemove, HudDebugPosition.BOT_LEFT, false);
        nzStage.addActors(botLAdd, botLRemove);

        // BOT_MIDDLE
        TextButton botMAdd = new TextButton("+", skin);
        nzStage.getPositionner(botMAdd, true).setPositionByPercent(50, 5);
        addListener(botMAdd, HudDebugPosition.BOT_MIDDLE, true);

        TextButton botMRemove = new TextButton("-", skin);
        nzStage.getPositionner(botMRemove, true).setPositionByPercent(52, 5);
        addListener(botMRemove, HudDebugPosition.BOT_MIDDLE, false);
        nzStage.addActors(botMAdd, botMRemove);

        // BOT_RIGHT
        TextButton botRAdd = new TextButton("+", skin);
        nzStage.getPositionner(botRAdd, true).setPositionByPercent(95, 5);
        addListener(botRAdd, HudDebugPosition.BOT_RIGHT, true);

        TextButton botRRemove = new TextButton("-", skin);
        nzStage.getPositionner(botRRemove, true).setPositionByPercent(97, 5);
        addListener(botRRemove, HudDebugPosition.BOT_RIGHT, false);
        nzStage.addActors(botRAdd, botRRemove);

        // LEFT_MIDDLE
        TextButton leftMAdd = new TextButton("+", skin);
        nzStage.getPositionner(leftMAdd, true).setPositionByPercent(2, 50);
        addListener(leftMAdd, HudDebugPosition.LEFT_MIDDLE, true);

        TextButton leftMRemove = new TextButton("-", skin);
        nzStage.getPositionner(leftMRemove, true).setPositionByPercent(4, 50);
        addListener(leftMRemove, HudDebugPosition.LEFT_MIDDLE, false);
        nzStage.addActors(leftMAdd, leftMRemove);

        // RIGHT_MIDDLE
        TextButton rightMAdd = new TextButton("+", skin);
        nzStage.getPositionner(rightMAdd, true).setPositionByPercent(95, 50);
        addListener(rightMAdd, HudDebugPosition.RIGHT_MIDDLE, true);

        TextButton rightMRemove = new TextButton("-", skin);
        nzStage.getPositionner(rightMRemove, true).setPositionByPercent(97, 50);
        addListener(rightMRemove, HudDebugPosition.RIGHT_MIDDLE, false);
        nzStage.addActors(rightMAdd, rightMRemove);


        Gdx.input.setInputProcessor(nzStage);
        addOneOfAll();
    }

    @Override
    public String getTestExplication() {
        return "Placement sur HudDebug aprés remove";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }

    private void addOneOfAll() {
        topL++;
        HudDebug.addTopLeft("TOP_LEFT" + topL, "", Color.YELLOW);

        topM++;
        HudDebug.addTopMiddle("TOP_MIDDLE" + topM, "", Color.GOLD);

        topR++;
        HudDebug.addTopRight("TOP_RIGHT" + topR, "", Color.OLIVE);

        botL++;
        HudDebug.addBotLeft("BOT_LEFT" + botL, "", Color.FOREST);

        botM++;
        HudDebug.addBotMiddle("BOT_MIDDLE" + botM, "", Color.CYAN);

        botR++;
        HudDebug.addBotRight("BOT_RIGHT" + botR, "", Color.PINK);

        leftM++;
        HudDebug.addMiddleLeft("LEFT_MIDDLE" + leftM, "", Color.PURPLE);

        rightM++;
        HudDebug.addMiddleRight("RIGHT_MIDDLE" + rightM, "", Color.RED);
    }

    private void addListener(TextButton button, int positionOnstage, boolean add) {
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                switch (positionOnstage) {
                    case HudDebugPosition.TOP_LEFT:
                        if (add) {
                            topL++;
                            HudDebug.addTopLeft("TOP_LEFT" + topL, "", Color.YELLOW);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("TOP_LEFT" + topL);
                                topL--;
                            }
                        }
                        break;
                    case HudDebugPosition.TOP_MIDDLE:
                        if (add) {
                            topM++;
                            HudDebug.addTopMiddle("TOP_MIDDLE" + topM, "", Color.GOLD);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("TOP_MIDDLE" + topM);
                                topM--;
                            }
                        }
                        break;
                    case HudDebugPosition.TOP_RIGHT:
                        if (add) {
                            topR++;
                            HudDebug.addTopRight("TOP_RIGHT" + topR, "", Color.OLIVE);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("TOP_RIGHT" + topR);
                                topR--;
                            }
                        }
                        break;
                    case HudDebugPosition.BOT_LEFT:
                        if (add) {
                            botL++;
                            HudDebug.addBotLeft("BOT_LEFT" + botL, "", Color.FOREST);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("BOT_LEFT" + botL);
                                botL--;
                            }
                        }
                        break;
                    case HudDebugPosition.BOT_MIDDLE:
                        if (add) {
                            botM++;
                            HudDebug.addBotMiddle("BOT_MIDDLE" + botM, "", Color.CYAN);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("BOT_MIDDLE" + botM);
                                botM--;
                            }
                        }
                        break;
                    case HudDebugPosition.BOT_RIGHT:
                        if (add) {
                            botR++;
                            HudDebug.addBotRight("BOT_RIGHT" + botR, "", Color.PINK);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("BOT_RIGHT" + botR);
                                botR--;
                            }
                        }
                        break;

                    case HudDebugPosition.LEFT_MIDDLE:
                        if (add) {
                            leftM++;
                            HudDebug.addMiddleLeft("LEFT_MIDDLE" + leftM, "", Color.PURPLE);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("LEFT_MIDDLE" + leftM);
                                leftM--;
                            }
                        }
                        break;
                    case HudDebugPosition.RIGHT_MIDDLE:
                        if (add) {
                            rightM++;
                            HudDebug.addMiddleRight("RIGHT_MIDDLE" + rightM, "", Color.RED);
                        } else {
                            if (topL > 0) {
                                HudDebug.remove("RIGHT_MIDDLE" + rightM);
                                rightM--;
                            }
                        }
                        break;

                    default:
                        break;
                }
            }
        });
    }

}
