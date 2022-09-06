package com.nzt.gdx.test.s_try.list.t3d.b2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.nzt.gdx.test.s_try.list.B2dTestConstants;
import com.nzt.gdx.test.s_try.list.t3d.BaseSTry3D;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "3D.B2D")
public class STry3DB2dBasic extends BaseSTry3D {
    public Model model;
    public ModelInstance instance;
    public Environment environment;

    public STry3DB2dBasic(FastTesterMain main) {
        super(main);
    }

    @Override
    public void createCamera() {
        camera = new PerspectiveCamera(67, B2dTestConstants.WIDTH_PPM, B2dTestConstants.HEIGHT_PPM);
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    @Override
    public String getTestExplication() {
        return "Simple 3D test from xoppa blog";
    }

    @Override
    public void doShow() {
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                Usage.Position | Usage.Normal);
        instance = new ModelInstance(model);

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
    }

    @Override
    public void render3D(float dt) {
        camController.update();
        modelBatch.render(instance, environment);
    }

    @Override
    public void dispose3D() {
        model.dispose();
    }
}
