package com.nzt.gdx.test.trials.st.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * https://github.com/vikrorcz/watershader
 */
@TestScreenList(group = "shaders")
public class STWaterShader extends TestScreen {
    private SpriteBatch batch;

    private ShaderProgram cloakShader;
    private ShaderProgram maskShader;

    private OrthographicCamera camera;
    private Viewport viewport;

    private FrameBuffer frameBuffer;
    private TextureRegion bufferRegion;

    private float dt;
    private float time;
    private float angle;

    private Texture backTexture;
    private Texture transparentTexture;
    private Texture maskTexture;

    private Sprite cloakSprite;
    private Sprite maskSprite;

    private Vector3 position;

    private int locationX;
    private int locationY;

    private final static String ASSET_PATH = "shaders/water/";

    public STWaterShader(FastTesterMain main) {
        super(main, true);

        batch = new SpriteBatch();

        /**
         * https://github.com/mattdesl/lwjgl-basics/wiki/ShaderLesson4
         * https://stackoverflow.com/questions/22447270/passing-several-textures-to-shader-in-libgdx
         *
         */
        cloakShader = new ShaderProgram(batch.getShader().getVertexShaderSource(), ASSET_PATH + "cloak.frag");
        if (!cloakShader.isCompiled()) {
            Gdx.app.error("cloakShader", "compilation failed:\n" + cloakShader.getLog());
        }

        maskShader = new ShaderProgram(ASSET_PATH + "mask.vert", ASSET_PATH + "mask.frag");
        if (!maskShader.isCompiled()) {
            Gdx.app.error("maskShader", "compilation failed:\n" + cloakShader.getLog());
        }
        ShaderProgram.pedantic = false;


        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f);
        viewport = new ExtendViewport(1920, 1080, camera);
        viewport.apply();

        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, 1920, 1080, false);
        bufferRegion = new TextureRegion(frameBuffer.getColorBufferTexture());


        //textures
        backTexture = new Texture(ASSET_PATH + "water.jpg");
        maskTexture = new Texture(ASSET_PATH + "mask.png");
        transparentTexture = new Texture(ASSET_PATH + "transparent.png");

        //sprites
        cloakSprite = new Sprite();
        maskSprite = new Sprite(transparentTexture);
    }

    @Override
    public String getTestExplication() {
        return "Water shader from https://github.com/vikrorcz/watershader'";
    }

    @Override
    public void renderTestScreen(float dt) {
        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.setBlendFunctionSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL20.GL_ONE);

        frameBuffer.begin();
        batch.begin();
        batch.draw(backTexture, 0, 0, 1920, 1080);
        batch.end();
        frameBuffer.end();


        batch.begin();
        batch.draw(backTexture, 0, 0, 1920, 1080);
        batch.end();

        position = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        locationX = (int) position.x;
        locationY = (int) position.y;


        dt += Gdx.graphics.getDeltaTime();
        time += dt;
        float angle = time * (2 * MathUtils.PI);
        if (angle > (2 * MathUtils.PI)) {
            angle -= (2 * MathUtils.PI);
        }
        //distorsion shader
        bufferRegion.setRegion(locationX - 100, locationY - 100, 200, 200);
        cloakSprite.setRegion(bufferRegion);
        cloakSprite.flip(false, true);
        cloakSprite.setSize(200, 200);
        cloakSprite.setPosition(locationX - 100, locationY - 100);
        batch.begin();
        batch.setShader(cloakShader);
        cloakShader.bind();
        cloakShader.setUniformf("u_time", -dt);
        cloakShader.setUniformf("u_amount", 10f);//20;
        cloakShader.setUniformf("u_speed", .5f);
        cloakSprite.draw(batch);
        batch.setShader(null);

        //mask shader
        maskSprite.setSize(200, 200);
        maskSprite.setPosition(locationX - 100, locationY - 100);
        batch.setShader(maskShader);
        maskShader.setUniformf("resolution", new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        maskShader.setUniformi("u_texture1", 1);
        maskShader.setUniformi("u_mask", 2);
        bufferRegion.getTexture().bind(1);
        maskTexture.bind(2);
        maskSprite.draw(batch);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        batch.setShader(null);
        batch.end();
    }

    @Override
    public void doResize(int width, int height) {
        viewport.update(width, height);
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void disposeTestScreen() {
        batch.dispose();
        backTexture.dispose();
        maskTexture.dispose();
        transparentTexture.dispose();
        maskSprite.getTexture().dispose();
        cloakSprite.getTexture().dispose();
        frameBuffer.dispose();
        bufferRegion.getTexture().dispose();
        cloakShader.dispose();
        maskShader.dispose();
    }
}
