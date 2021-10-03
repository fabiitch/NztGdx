package com.nzt.gdx.test.javat;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectReferenceTest {

    public Vector2 refCheck;

    @Test
    public void test() {
        ObjectReferenceTest test = new ObjectReferenceTest();
        test.refCheck = new Vector2(0, 0);

         Vector2 refKepp = test.refCheck;

        test.refCheck = new Vector2(100, 100);

        Assertions.assertEquals(0, refKepp.x);
    }
}
