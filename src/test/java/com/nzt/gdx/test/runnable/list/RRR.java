package com.nzt.gdx.test.runnable.list;

import com.nzt.gdx.test.utils.archi.mains.StarterTestConfig;
import com.nzt.gdx.test.utils.archi.mains.mains.SingleScreenTestMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class RRR {
    @Test
    public void moveTest() {
        try {

        StarterTestConfig.startLwjgl3(new SingleScreenTestMain(RectangleMoveTest.class),800,500);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        fail("tttt");
    }
}
