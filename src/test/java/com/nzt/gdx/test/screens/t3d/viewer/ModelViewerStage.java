package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.scene2D.nz.NzStage;

public class ModelViewerStage extends NzStage {

    private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

    private SelectBox<ModelItem> selectBox;
    private ModelViewerHelper helper;
    private Label labelCamera;
    private ST3DModelViewer viewer;

    public ModelViewerStage(ST3DModelViewer viewer, ModelViewerHelper helper) {
        this.viewer = viewer;
        this.helper = helper;
        setDebugAll(true);
        initComboModels();
        initCameraButton();
        createLabels();
    }

    private boolean isOrthoCam = false;
    private boolean isB2DCam = false;

    private void createLabels() {
        this.labelCamera = new Label("Cam" + DebugDisplayUtils.printVector3(viewer.camera.position), skin);
        getPositionner(labelCamera, true).setPositionByPercent(88, 98);
        addActor(labelCamera);
    }

    public void update() {
        labelCamera.setText("Cam" + DebugDisplayUtils.printVector3(viewer.camera.position));
    }

    private void initCameraButton() {
        TextButton resetCameraButton = new TextButton("reset", skin);
        getPositionner(resetCameraButton, true).setPositionByPercent(30, 95);
        addActor(resetCameraButton);
        resetCameraButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                helper.resetCamera(isB2DCam);
            }
        });

        TextButton cameraTypeButton = new TextButton("To Ortho", skin);
        getPositionner(cameraTypeButton, true).setPositionByPercent(40, 95);
        addActor(cameraTypeButton);
        cameraTypeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                isOrthoCam = !isOrthoCam;
                helper.changeCameraType(isOrthoCam, isB2DCam);
                if (isOrthoCam)
                    cameraTypeButton.setText("To Perspective");
                else
                    cameraTypeButton.setText("To Ortho");
            }
        });

        TextButton b2DCamera = new TextButton("to B2D", skin);
        getPositionner(b2DCamera, true).setPositionByPercent(50, 95);
        addActor(b2DCamera);
        b2DCamera.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                isB2DCam = !isB2DCam;
                helper.changeCameraType(isOrthoCam, isB2DCam);
                if (isB2DCam)
                    b2DCamera.setText("To Normal");
                else
                    b2DCamera.setText("to B2D");

            }
        });
    }

    private void initComboModels() {
        selectBox = new SelectBox<>(skin);
        selectBox.setItems(ModelViewerScanner.scan3DFilesInRessources());
        getPositionner(selectBox, true).setPositionByPercent(5, 95).setWidthPercent(20);
        selectBox.ascendantsVisible();
        addActor(selectBox);
        selectBox.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (selectBox.getSelected() != null)
                    helper.changeModel(selectBox.getSelected().path);

            }
        });
    }

    public void dispose() {
        super.dispose();
        this.skin.dispose();

    }
}
