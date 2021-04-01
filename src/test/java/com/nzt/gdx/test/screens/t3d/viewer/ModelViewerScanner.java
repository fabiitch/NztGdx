package com.nzt.gdx.test.screens.t3d.viewer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.badlogic.gdx.utils.Array;

/**
 * Scan models in ressource/assets
 *
 */
public class ModelViewerScanner {

	public static Array<ModelItem> scan3DFilesInRessources() {

		Array<ModelItem> array = new Array<ModelItem>();
		try {
			ClassLoader classLoader = ModelViewerScanner.class.getClassLoader();
			File modelsFolder = new File(classLoader.getResource("models").toURI());
			Path modelsFolderPath = Paths.get(modelsFolder.toURI());
			Stream<Path> walk = Files.walk(modelsFolderPath).filter(p -> is3DFile(p.toString()));
			walk.forEach(path -> {
				array.add(new ModelItem(path.getFileName().toString(), modelsFolderPath.relativize(path).toString()));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	private static boolean is3DFile(String s) {
		return s.toLowerCase().endsWith(".g3db") || s.toLowerCase().endsWith(".g3dj");
	}

}
