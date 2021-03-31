package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ModelViewerScanner {

    private Skin skin;
    private Tree<ChangeModelNode, String> treeModels;

    public ModelViewerScanner(Tree<ChangeModelNode, String> treeModels, Skin skin) {
        this.treeModels = treeModels;
        this.skin = skin;
        this.fillTreeFrom3DFiles();
    }


    public boolean is3DFile(String s) {
        return s.toLowerCase().endsWith(".g3db") || s.toLowerCase().endsWith(".g3dj");
    }

    public void addFile(Path path) {
        String[] filesPath = path.toString().split(File.pathSeparator);
        ChangeModelNode parent = null;
        for (String s : filesPath) {
            if (is3DFile(s)) {
                insertInTree(parent, path.toString(), s, false);
            } else {
                parent = findFolder(parent, s);
            }
        }
    }

    private ChangeModelNode findFolder(ChangeModelNode parent, String name) {
        ChangeModelNode toReturn = null;
        if (parent == null) {
            toReturn = treeModels.findNode(name);
            if (toReturn == null) {
                toReturn = insertInTree(null, name, "", true);
            }
        } else {
            parent.findNode(name);
            if (toReturn == null) {
                toReturn = insertInTree(parent, name, "", true);
            }
        }
        return toReturn;
    }

    private ChangeModelNode insertInTree(ChangeModelNode parent, String name, String path, boolean isGroup) {
        ChangeModelNode newNode = new ChangeModelNode(name, path, isGroup, skin);
        if (parent == null) {
            treeModels.add(newNode);
        } else {
            parent.add(newNode);
        }
        return newNode;
    }


    public void fillTreeFrom3DFiles() {
        try {
            ClassLoader classLoader = ModelViewerScanner.class.getClassLoader();
            File modelsFolder = new File(classLoader.getResource("models").toURI());
            Path modelsFolderPath = Paths.get(modelsFolder.toURI());
            Stream<Path> walk = Files.walk(modelsFolderPath);
            walk.forEach(path -> {
                addFile(path);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
