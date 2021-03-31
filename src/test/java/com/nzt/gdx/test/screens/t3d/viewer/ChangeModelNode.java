package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;

class ChangeModelNode extends Tree.Node<ChangeModelNode, String, Actor> {

    public boolean isGroup;
    public String path;


    public ChangeModelNode(String name, String path, boolean isGroup, Skin skin) {
        this.isGroup = isGroup;
        this.path = path;

        TextButton textButton = new TextButton(name, skin);
        setActor(textButton);
        this.setValue(isGroup + "-" + path);
    }
}
