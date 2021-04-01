package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(groupName = "3D")
public class ST3DModelViewer extends SimpleTestScreen {
	Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

	public InputMultiplexer inputMultiplexer;
	public Camera camera;

	public CameraInputController camController;
	public Model model;
	public ModelInstance modelInstance;

	String modelPathStart = "models";

	private boolean loading = true;

	private NzStage nzStage;

	SelectBox<ModelItem> selectBox;

	public ST3DModelViewer(FastTesterMain main) {
		super(main);

		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(10f, 10f, 10f);
		this.camera.lookAt(0, 0, 0);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();

		camController = new CameraInputController(camera);
		Gdx.input.setInputProcessor(camController);
		nzStage = new NzStage();
		nzStage.setDebugAll(true);

		selectBox = new SelectBox<>(skin);
		selectBox.setItems(ModelViewerScanner.scan3DFilesInRessources());
		Array<ModelItem> items = selectBox.getItems();
		System.out.println(items);
		selectBox.setPosition(10, Gdx.graphics.getHeight() - 100);
		selectBox.ascendantsVisible();
		nzStage.addActor(selectBox);
		selectBox.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (selectBox.getSelected() != null)
					changeModel(selectBox.getSelected().path);

			}
		});

		this.inputMultiplexer = new InputMultiplexer(nzStage, camController);
		Gdx.input.setInputProcessor(inputMultiplexer);
		changeModel("warg.g3db");
	}

	public void changeModel(String modelPath) {
		loading = true;
		if (model != null)
			model.dispose();
		model = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/" + modelPath));
		System.out.println("==== new model loaded : " + modelPath);
		if (model.animations != null && model.animations.size > 0) {
			System.out.println("Animation list !");
			for (Animation anim : model.animations) {
				System.out.println("id=" + anim.id + "  duration=" + anim.duration);
			}
		}
		if (model.materials != null && model.materials.size > 0) {
			System.out.println("Materials list !");
			for (Material material : model.materials) {
				System.out.println("id=" + material.id + " mast" + material.getMask());
			}
		}
		System.out.println("====End load ======");
		modelInstance = new ModelInstance(model);
		loading = false;
	}

	@Override
	public void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	protected void renderScreen(float dt) {
		this.camera.update();
		camController.update();
		if (!loading) {
			modelBatch.begin(camera);
			modelBatch.render(modelInstance);
			modelBatch.end();
		}
		nzStage.act();
		nzStage.draw();

	}

	public void doDispose() {
		nzStage.dispose();
		if (model != null)
			model.dispose();
	}
}