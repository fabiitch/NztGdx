package com.nzt.gdx.b2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.nzt.gdx.logger.Logger;

public class B2DUtils {

    public static void debugContact(Contact contact) {
        Logger.startBlockLog("Contact Debug");
        Gdx.app.log("getChildIndexA", "" + contact.getChildIndexA());
        Gdx.app.log("getChildIndexB", "" + contact.getChildIndexB());

        Gdx.app.log("getFriction", "" + contact.getFriction());
        Gdx.app.log("getRestitution", "" + contact.getRestitution());
        Gdx.app.log("getTangentSpeed", "" + contact.getTangentSpeed());
        Gdx.app.log("isTouching", "" + contact.isTouching());

        Gdx.app.log("getWorldManifold().getNormal()", "" + contact.getWorldManifold().getNormal());
        int numberOfContactPoints = contact.getWorldManifold().getNumberOfContactPoints();
        Gdx.app.log("getWorldManifold().getNumberOfContactPoints()", "" + numberOfContactPoints);
        for (int i = 0, n = numberOfContactPoints; i < n; i++) {
            Gdx.app.log("contact point " + (i + 1), "" + contact.getWorldManifold().getPoints()[i]);
        }
        Logger.endBlockLog("Contact Debug");
    }
}
