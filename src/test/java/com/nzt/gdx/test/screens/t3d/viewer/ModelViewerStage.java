package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.nzt.gdx.scene2D.nz.NzStage;

public class ModelViewerStage extends NzStage {

    private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

    private SelectBox<ModelItem> selectBox;
    ModelViewerHelper helper;

    public ModelViewerStage(ModelViewerHelper helper) {
        this.helper = helper;
        setDebugAll(true);
        initComboModels();
        initCameraButton();
    }

    private void initCameraButton() {
        TextButton resetCamera = new TextButton("reset", skin);
        getPositionner(resetCamera, true).setPositionByPercent(30, 95);
        addActor(resetCamera);
        resetCamera.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                helper.resetCamera();
            }
        });

        TextButton cameraType = new TextButton("Ortho", skin);
        getPositionner(cameraType, true).setPositionByPercent(40, 95);
        addActor(cameraType);
        cameraType.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean isPerspective = helper.changeCameraType();
                if (isPerspective)
                    cameraType.setText("Ortho");
                else
                    cameraType.setText("Perspective");
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
}
