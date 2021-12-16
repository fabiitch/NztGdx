package com.nzt.gdx.test.utils.archi.mains.mains;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.screen.BaseScreen;
import org.mockito.Mockito;

public class HeadlessTesterMain extends FastTesterMain {
    public HeadlessTesterMain(Class screenClass) {
        super(screenClass);
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
