package com.nzt.gdx.test.trials.st.perf.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "perf.memory")
public class STAllocationTrackingTestScreen extends SimpleTestScreen {

    private final long memoryStart;
    private final long memoryStartMb;
    final BitmapFont font;
    final String MEMORY_GROW;

    public STAllocationTrackingTestScreen(FastTesterMain main) {
        super(main);
        PerformanceFrame.enabled = false;
        nzGLProfiler.desactive();
        font = new BitmapFont();
        MEMORY_GROW = "Memory Grow";
        this.memoryStart = Gdx.app.getJavaHeap();
        this.memoryStartMb = GdxUtils.getHeapMb();
    }

    @Override
    protected void doDispose() {
        font.dispose();
    }

    @Override
    protected void renderScreen(float dt) {
        if (Gdx.app.getJavaHeap() > memoryStart) {
            spriteBatch.begin();
            font.draw(spriteBatch, MEMORY_GROW + "   " + (Gdx.app.getJavaHeap() - memoryStart),
                    GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY());

            font.draw(spriteBatch, MEMORY_GROW + "   " + (GdxUtils.getHeapMb() - memoryStartMb),
                    GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY()/2);
            spriteBatch.end();
        }

    }
}
