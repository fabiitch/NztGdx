package com.nzt.gdx.debug;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.logger.LoggerTagBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

public class B2DDebugUtils {

	private B2DDebugUtils() {

	}

	public static void initHudDebug(World world) {
		B2DDebugUtils.initHudDebug(world, HudDebugPosition.TOP_RIGHT, Color.RED);
	}

	public static void initHudDebug(World world, int positionOnStage, Color color) {
		HudDebug.addItem("Body count", world.getBodyCount(), positionOnStage, color);
		HudDebug.addItem("Contact count", world.getContactCount(), positionOnStage, color);
		HudDebug.addItem("Fixture count", world.getFixtureCount(), positionOnStage, color);
		HudDebug.addItem("Joint count", world.getJointCount(), positionOnStage, color);
		HudDebug.addItem("Proxy count", world.getProxyCount(), positionOnStage, color);
		HudDebug.addItem("World VelocityThreshold", World.getVelocityThreshold(), positionOnStage, color);
	}

	public static void updateHudDebug(World world) {
		HudDebug.update("Body count", world.getBodyCount());
		HudDebug.update("Contact count", world.getContactCount());
		HudDebug.update("Fixture count", world.getFixtureCount());
		HudDebug.update("Joint count", world.getJointCount());
		HudDebug.update("Proxy count", world.getProxyCount());
		HudDebug.update("World VelocityThreshold", World.getVelocityThreshold());
	}

	public static void logInformation(World world, int logLevel) {
		if (world != null) {
			LoggerTagBlockUtils.startBlock(logLevel, LogTagsBase.B2D_INFO, "Box2D World Recap");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Body count", world.getBodyCount() + "");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Contact count", world.getContactCount() + "");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Fixture count", world.getFixtureCount() + "");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Joint count", world.getJointCount() + "");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "Proxy count", world.getProxyCount() + "");
			TagLogger.logWithLevel(logLevel, LogTagsBase.B2D_INFO, "World VelocityThreshold",
					World.getVelocityThreshold() + "");
			LoggerTagBlockUtils.endBlock(logLevel, LogTagsBase.B2D_INFO, "Box2D World Recap");
		} else {
			TagLogger.debug(LogTagsBase.B2D_CONTACT, "Box2D Debug", "No World Created");
		}
	}

	// TODO a voir si vraiment utile ...
	public static void debugContact(String eventName, Contact contact) {
		LoggerTagBlockUtils.startBlockDebug(LogTagsBase.B2D_CONTACT, "Contact Debug");
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getChildIndexA", "" + contact.getChildIndexA());
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getChildIndexB", "" + contact.getChildIndexB());

		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getFriction", "" + contact.getFriction());
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getRestitution", "" + contact.getRestitution());
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getTangentSpeed", "" + contact.getTangentSpeed());
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "isTouching", "" + contact.isTouching());

		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getWorldManifold().getNormal()",
				"" + contact.getWorldManifold().getNormal());
		int numberOfContactPoints = contact.getWorldManifold().getNumberOfContactPoints();
		TagLogger.debug(LogTagsBase.B2D_CONTACT, "getWorldManifold().getNumberOfContactPoints()",
				"" + numberOfContactPoints);
		for (int i = 0, n = numberOfContactPoints; i < n; i++) {
			TagLogger.debug(LogTagsBase.B2D_CONTACT, "contact point " + (i + 1),
					"" + contact.getWorldManifold().getPoints()[i]);
		}
		LoggerTagBlockUtils.endBlockDebug(LogTagsBase.B2D_INFO, "Contact Debug");
	}
}
