package com.nzt.gdx.test.trials.st.t3d.b2d;

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
import com.nzt.gdx.test.trials.st.B2dTestConstants;
import com.nzt.gdx.test.trials.st.t3d.BaseST3D;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "3D.B2D")
public class ST3DB2dWarg extends BaseST3D {

    public String modelPath = "models/warg.g3db";
    public Model wardModel;
    public ModelInstance wargInstance;
    public Environment environment;

    public ST3DB2dWarg(FastTesterMain main) {
        super(main);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
        wargInstance = new ModelInstance(wardModel);
        for (Animation anim : wargInstance.animations) {
            System.out.println(anim.id);
        }
    }

    @Override
    public void createCamera() {
        this.camera = new OrthographicCamera(B2dTestConstants.WIDTH_PPM, B2dTestConstants.HEIGHT_PPM);
        this.camera.position.set(10, 10, 10);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    @Override
    public String getTestExplication() {
        return "Display Ward model in B2D size camera";
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
