package com.nzt.gdx.screen.manager;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.loading.BaseLoadingScreen;
import com.nzt.gdx.screen.loading.SimpleProgressBarScreen;

/**
 * Abstract screen manager, extends it.
 */
public abstract class AbstractScreenManager<M extends AbstractMain> {
    protected M main;

    public AbstractScreen<M> currentScreen;
    protected BaseLoadingScreen<M> loadingScreen;
    public AbstractAssetsManager assetsManager;

    public float minTimeLoadingDisplay;
    public boolean keepLoadingScreenAlive;

    protected abstract void afterSplashScreen();

    public AbstractScreenManager(float minTimeLoadingDisplay, boolean keepLoadingScreenAlive) {
        this.minTimeLoadingDisplay = minTimeLoadingDisplay;
        this.keepLoadingScreenAlive = keepLoadingScreenAlive;
    }

    public AbstractScreenManager() {
        this(0.2f, true);
    }

    public abstract BaseLoadingScreen<M> createLoadingScreen();

    public void startApplication(M main) {
        this.main = main;
        this.assetsManager = main.assetsManager;
        doStartApplication();
        loadingScreen = createLoadingScreen();
        if (loadingScreen == null) {
            loadingScreen = new SimpleProgressBarScreen<M>(this.main, this.minTimeLoadingDisplay, assetsManager);
        }
        IntAfterLoading afterloading = new IntAfterLoading() {
            @Override
            public void doAfterLoading() {
                afterSplashScreen();
            }
        };
        this.loadingScreen.setAfterLoading(afterloading);
        setScreen(loadingScreen);
    }

    protected abstract void doStartApplication();

    public void setLoadingScreen(BaseLoadingScreen<M> newLoadingScreen) {
        this.loadingScreen = newLoadingScreen;
    }

    public void setScreenWithLoadingTransition(final AbstractScreen<M> screen, float minTimeDisplay) {
        setScreenWithLoadingTransition(screen);
        loadingScreen.setMinDisplayTime(minTimeDisplay);
    }

    public void setScreenWithLoadingTransition(final AbstractScreen<M> screen) {
        if (loadingScreen == null)
            loadingScreen = createLoadingScreen();
        loadingScreen.resetProgress();
        IntAfterLoading afterloading = new IntAfterLoading() {
            @Override
            public void doAfterLoading() {
                setScreen(screen);
            }
        };
        this.loadingScreen.setAfterLoading(afterloading);
        setScreen(loadingScreen);
    }

    public void setScreen(AbstractScreen<M> screen) {
        this.setScreen(screen, false);
    }

    public void setScreen(AbstractScreen<M> screen, boolean keepScreenAlive) {
        if (currentScreen != null) {
            currentScreen.hide();
            if (!keepScreenAlive || !(keepLoadingScreenAlive && currentScreen == loadingScreen)) {
                PerformanceFrame.removeScreen(currentScreen);
                currentScreen.dispose();
                currentScreen = null;
            }
            main.sb.flush();
            main.nzShapeRenderer.flush();
            main.modelBatch.flush();
        }
        currentScreen = screen;
        main.logManager.nzGlProfiler.setScreen(currentScreen);
        PerformanceFrame.setScreen(screen);
        currentScreen.show();
        currentScreen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    // ===================== screen implements
    public void pause() {
        if (currentScreen != null) {
            currentScreen.pause();
            doPause();
        }
    }

    protected abstract void doPause();

    public void resume() {
        if (currentScreen != null) {
            currentScreen.resume();
            doResume();
        }
    }

    protected abstract void doResume();

    public void resize(int width, int height) {
        if (currentScreen != null) {
            currentScreen.resize(width, height);
            doResize(width, height);
        }
    }

    protected abstract void doResize(int width, int height);

    public void dispose() {
        if (currentScreen != null) {
            currentScreen.dispose();
            doDispose();
        }
        main.exit();
    }

    public void render(float dt) {
        if (currentScreen != null) {
            currentScreen.render(dt);
            doRender(dt);
        }
    }

    protected abstract void doDispose();

    protected abstract void doRender(float dt);

    public interface IntAfterLoading {
        void doAfterLoading();
    }

}
