package com.nzt.gdx.test.utils.archi.mains.junit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractLogManager;
import com.nzt.gdx.screen.manager.AbstractScreenManager;
import com.nzt.gdx.screen.manager.ScreenManager;
import org.mockito.Mockito;

public class JunitTesterMain extends AbstractMain {
    @Override
    public void create() {
        this.assetsManager = createAssetsManager();
        this.logManager = createLogManager();
        this.screenManager = createScreenManager();
    }

    @Override
    public void doCreate() {

    }

    @Override
    public ScreenManager createScreenManager() {
        return new JunitScreenManager();
    }

    @Override
    public AbstractAssetsManager createAssetsManager() {
        return null;
    }

    @Override
    public AbstractLogManager createLogManager() {
        return new JunitLogManager();
    }

    @Override
    public void doExit() {

    }

    protected BaseScreen returnScreenToLaunch() {
        return null;
    }

    @Override
    public void createRenderObjects() {
        this.sb = Mockito.mock(SpriteBatch.class);
        this.nzShapeRenderer = Mockito.mock(NzShapeRenderer.class);
        this.modelBatch = Mockito.mock(ModelBatch.class);
        Gdx.gl = Mockito.mock(GL20.class);
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl30 = Mockito.mock(GL30.class);
    }

}
