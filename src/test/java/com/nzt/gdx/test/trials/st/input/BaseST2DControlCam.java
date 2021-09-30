package com.nzt.gdx.test.trials.st.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.math.random.Randoms;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "inputs")
public abstract class BaseST2DControlCam extends TestScreen {

    protected Array<Sprite> spriteArray;
    protected final Texture texture;
    protected Camera camera;

    public BaseST2DControlCam(FastTesterMain main) {
        super(main);
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.texture = new Texture("badlogic.jpg");
        spriteArray = new Array<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Sprite sprite = new Sprite(texture);
                sprite.setPosition(i * sprite.getWidth(), j * sprite.getHeight());
                sprite.setColor(Randoms.newRandomColor());
                spriteArray.add(sprite);
            }
        }
        HudDebug.addTopLeft("Cam pos", Vector3.Zero);
    }

    @Override
    public void renderTestScreen(float dt) {
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        for (Sprite sprite : spriteArray)
            sprite.draw(spriteBatch);
        spriteBatch.end();
        HudDebug.update("Cam pos", camera.position);
    }

    @Override
    public void disposeTestScreen() {
        this.texture.dispose();
    }
}
