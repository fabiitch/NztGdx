package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.logger.LoggerBlock;
import com.nzt.gdx.logger.LoggerUtils;

public class B2DDebug {

    private static World world;

    public static void init(World world) {
        B2DDebug.world = world;
    }

    public static void displayHud() {
        HudDebug.addTopRight("Body count", world.getBodyCount(), Color.RED);
        HudDebug.addTopRight("Contact count", world.getContactCount(), Color.RED);
        HudDebug.addTopRight("Fixture count", world.getFixtureCount(), Color.RED);
        HudDebug.addTopRight("Joint count", world.getJointCount(), Color.RED);
        HudDebug.addTopRight("Proxy count", world.getProxyCount(), Color.RED);
        HudDebug.addTopRight("World VelocityThreshold", world.getVelocityThreshold(), Color.RED);
    }

    public static void updateHud() {
        HudDebug.update("Body count", world.getBodyCount());
        HudDebug.update("Contact count", world.getContactCount());
        HudDebug.update("Fixture count", world.getFixtureCount());
        HudDebug.update("Joint count", world.getJointCount());
        HudDebug.update("Proxy count", world.getProxyCount());
        HudDebug.update("World VelocityThreshold", world.getVelocityThreshold());
    }

    public static void debugInfo() {
        if (world != null) {
            LoggerUtils.logSeparator("Box2D Debug");
            Gdx.app.log("Body count", world.getBodyCount() + "");
            Gdx.app.log("Contact count", world.getContactCount() + "");
            Gdx.app.log("Fixture count", world.getFixtureCount() + "");
            Gdx.app.log("Joint count", world.getJointCount() + "");
            Gdx.app.log("Proxy count", world.getProxyCount() + "");
            Gdx.app.log("World VelocityThreshold", World.getVelocityThreshold() + "");
            LoggerUtils.logSeparator("Box2D Debug End");
        } else {
            Gdx.app.log("Box2D Debug", "No World Created");
        }
    }

    public static void debugContact(String eventName, Contact contact) {

        LoggerBlock.startBlockDebug("Contact Debug - " + eventName);
        Gdx.app.debug("getChildIndexA", "" + contact.getChildIndexA());
        Gdx.app.debug("getChildIndexB", "" + contact.getChildIndexB());

        Gdx.app.debug("getFriction", "" + contact.getFriction());
        Gdx.app.debug("getRestitution", "" + contact.getRestitution());
        Gdx.app.debug("getTangentSpeed", "" + contact.getTangentSpeed());
        Gdx.app.debug("isTouching", "" + contact.isTouching());

        Gdx.app.debug("getWorldManifold().getNormal()", "" + contact.getWorldManifold().getNormal());
        int numberOfContactPoints = contact.getWorldManifold().getNumberOfContactPoints();
        Gdx.app.debug("getWorldManifold().getNumberOfContactPoints()", "" + numberOfContactPoints);
        for (int i = 0, n = numberOfContactPoints; i < n; i++) {
            Gdx.app.debug("contact point " + (i + 1), "" + contact.getWorldManifold().getPoints()[i]);
        }
        LoggerBlock.endBlockDebug("Contact Debug");
    }
}
