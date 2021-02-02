package com.nzt.gdx.debug;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.logger.LoggerTagBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

public class B2DDebug {

    private static World world;

    public static void init(World world) {
        B2DDebug.world = world;
    }

    public static void displayHud() {
        B2DDebug.displayHud(HudDebugPosition.topRight);
    }

    public static void displayHud(int position) {
        HudDebug.addItem(position, "Body count", world.getBodyCount(), Color.RED);
        HudDebug.addItem(position, "Contact count", world.getContactCount(), Color.RED);
        HudDebug.addItem(position, "Fixture count", world.getFixtureCount(), Color.RED);
        HudDebug.addItem(position, "Joint count", world.getJointCount(), Color.RED);
        HudDebug.addItem(position, "Proxy count", world.getProxyCount(), Color.RED);
        HudDebug.addItem(position, "World VelocityThreshold", World.getVelocityThreshold(), Color.RED);
    }

    public static void updateHud() {
        HudDebug.update("Body count", world.getBodyCount());
        HudDebug.update("Contact count", world.getContactCount());
        HudDebug.update("Fixture count", world.getFixtureCount());
        HudDebug.update("Joint count", world.getJointCount());
        HudDebug.update("Proxy count", world.getProxyCount());
        HudDebug.update("World VelocityThreshold", World.getVelocityThreshold());
    }

    public static void logInfomation(int logLevel) {
        if (world != null) {
            LoggerTagBlockUtils.startBlock(logLevel, LogTagsBase.B2D_INFO, "Box2D World Recap");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Body count", world.getBodyCount() + "");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Contact count", world.getContactCount() + "");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Fixture count", world.getFixtureCount() + "");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Joint count", world.getJointCount() + "");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Proxy count", world.getProxyCount() + "");
            TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "World VelocityThreshold", World.getVelocityThreshold() + "");
            LoggerTagBlockUtils.endBlock(logLevel, LogTagsBase.B2D_INFO, "Box2D World Recap");
        } else {
            TagLogger.debug(LogTagsBase.B2D_CONTACT,"Box2D Debug", "No World Created");
        }
    }

    public static void debugContact(String eventName, Contact contact) {
        LoggerTagBlockUtils.startBlockDebug(LogTagsBase.B2D_CONTACT, "Contact Debug");
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getChildIndexA", "" + contact.getChildIndexA());
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getChildIndexB", "" + contact.getChildIndexB());

        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getFriction", "" + contact.getFriction());
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getRestitution", "" + contact.getRestitution());
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getTangentSpeed", "" + contact.getTangentSpeed());
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"isTouching", "" + contact.isTouching());

        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getWorldManifold().getNormal()", "" + contact.getWorldManifold().getNormal());
        int numberOfContactPoints = contact.getWorldManifold().getNumberOfContactPoints();
        TagLogger.debug(LogTagsBase.B2D_CONTACT,"getWorldManifold().getNumberOfContactPoints()", "" + numberOfContactPoints);
        for (int i = 0, n = numberOfContactPoints; i < n; i++) {
            TagLogger.debug(LogTagsBase.B2D_CONTACT,"contact point " + (i + 1), "" + contact.getWorldManifold().getPoints()[i]);
        }
        LoggerTagBlockUtils.endBlockDebug(LogTagsBase.B2D_INFO, "Contact Debug");
    }
}
