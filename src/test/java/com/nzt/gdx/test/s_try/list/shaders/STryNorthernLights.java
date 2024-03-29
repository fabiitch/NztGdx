package com.nzt.gdx.test.s_try.list.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * https://github.com/yellowstonegames/SquidLib-Demos/blob/master/NorthernLights/core/src/main/java/com/squidpony/demo/NorthernLights.java
 */
@TestScreen(group = "shaders")
public class STryNorthernLights extends ScreenTry {
    private SpriteBatch batch;
    private Texture pixel;
    private ShaderProgram shader;

    private long startTime;
    private float seed;
    private int width, height;

    public STryNorthernLights(FastTesterMain main) {
        super(main, true);
        batch = new SpriteBatch();

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.drawPixel(0, 0, 0xFFFFFFFF);
        pixel = new Texture(pixmap);
        startTime = TimeUtils.millis();
        ShaderProgram.pedantic = false;
        shader = new ShaderProgram("shaders/northern-lights/melter_vertex.glsl", "shaders/northern-lights/melter_fragment_no_dither.glsl");
//		shader = new ShaderProgram(Gdx.files.internal("elves_vertex.glsl"), Gdx.files.internal("elves_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("thule_vertex.glsl"), Gdx.files.internal("thule_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("foam_vertex.glsl"), Gdx.files.internal("warble_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("foam_vertex.glsl"), Gdx.files.internal("foam_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("northern_vertex.glsl"), Gdx.files.internal("scrambler_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("northern_vertex.glsl"), Gdx.files.internal("northern_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("northern_vertex.glsl"), Gdx.files.internal("cuatro_fragment_no_dither.glsl"));
//		shader = new ShaderProgram(Gdx.files.internal("northern_vertex.glsl"), Gdx.files.internal("standoff_fragment_no_dither.glsl"));
        if (!shader.isCompiled()) {
            Gdx.app.error("Shader", "error compiling shader:\n" + shader.getLog());
            Gdx.app.exit();
            return;
        }
        batch.setShader(shader);

        long state = TimeUtils.nanoTime() + startTime;//-1L;//-987654321234567890L;//-1234567890L;
        // Sarong's DiverRNG.randomize()
        seed = ((((state = (state ^ (state << 41 | state >>> 23) ^ (state << 17 | state >>> 47) ^ 0xD1B54A32D192ED03L) * 0xAEF17502108EF2D9L) ^ state >>> 43 ^ state >>> 31 ^ state >>> 23) * 0xDB4F0B9175AE2165L) >>> 42) * 0x1.5bf0a8p-16f;
        startTime -= (state ^ state >>> 11) & 0xFFFFL;
        //startTime -= 0x1000000;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public String getTestExplication() {
        return "test shader from https://github.com/yellowstonegames/SquidLib-Demos/blob/master/NorthernLights/core/src/main/java/com/squidpony/demo/NorthernLights.java";
    }

    @Override
    public void renderTestScreen(float dt) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && UIUtils.alt()) {
            if (Gdx.graphics.isFullscreen())
                Gdx.graphics.setWindowedMode(480, 320);
            else {
                Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
            }
        }
        Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond() + " FPS");
        final float ftm = TimeUtils.timeSinceMillis(startTime) * (0x1p-10f);
        batch.begin();
        shader.setUniformf("u_seed", seed);
        shader.setUniformf("u_time", ftm);
        batch.draw(pixel, 0, 0, width, height);
        batch.end();
    }

    @Override
    public void doResize(int width, int height) {
        this.width = width;
        this.height = height;
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }

    @Override
    public void disposeTestScreen() {
        batch.dispose();
        shader.dispose();
        pixel.dispose();
    }
}
