package com.nzt.gdx.test.st.list;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.nzt.gdx.test.utils.archi.mains.junit.JunitTesterMain;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRectangleMove {
    public static JunitTesterMain main;

    @BeforeEach()
    public void startTest() {
        System.out.println("===== Start Test ===" + " " + this.getClass().getSimpleName());
    }

    @BeforeAll
    public static void init() throws Exception {
        main = new JunitTesterMain();
        main.createRenderObjects();
        HeadlessApplication app = new HeadlessApplication(main);
        Gdx.app = app;

    }

    @Test
    public void rectMove() {
        RectangleMoveST tt = new RectangleMoveST(main);
        tt.renderLoop60FPS();
    }
}
