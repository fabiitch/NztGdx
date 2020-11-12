package com.nzt.gdx.b2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.nzt.gdx.logger.Logger;

public class B2DUtils {

    public static void debugContact(String eventName, Contact contact) {
        Logger.startBlockDebug("Contact Debug - " + eventName);
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
        Logger.endBlockDebug("Contact Debug");
    }
}
