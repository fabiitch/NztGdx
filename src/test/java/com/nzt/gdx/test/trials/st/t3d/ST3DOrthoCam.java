package com.nzt.gdx.test.trials.st.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "3D")
public class ST3DOrthoCam extends BaseST3D {
    public Model wardModel;
    public ModelInstance wargInstance;
    public Environment environment;

    public ST3DOrthoCam(FastTesterMain main) {
        super(main);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/warg.g3db"));
        wargInstance = new ModelInstance(wardModel);
        for (Animation anim : wargInstance.animations) {
            System.out.println(anim.id);
        }
    }

    @Override
    public void createCamera() {
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(10, 10, 10);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

    }

    @Override
    public String getExplication() {
        return "3D ortho cam";
    }

    @Override
    public void render3D(float dt) {
        camController.update();
        modelBatch.render(wargInstance);
    }

    @Override
    public void dispose3D() {
        wardModel.dispose();
    }
}
