package com.nzt.gdx.test.javat;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReferenceModificationTest {


    @Test
    public void reassigneRefTest() {
        Vector2 ref1 = new Vector2(0, 0);
        Vector2 refKepp = ref1;
        ref1 = new Vector2(100, 100);

        Assertions.assertEquals(0, refKepp.x);
    }

    @Test
    public void createRefInMethodTest() {
        Vector2 t1 = null;
        initNullVector(t1);
        Assertions.assertNull(t1);
    }

    private void initNullVector(Vector2 init) {
        init = new Vector2(100,100);
    }
}