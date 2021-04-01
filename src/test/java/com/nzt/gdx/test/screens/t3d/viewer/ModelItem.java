package com.nzt.gdx.test.screens.t3d.viewer;

public class ModelItem {

	public String name;
	public String path;

	public ModelItem(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	@Override
	public String toString() {
		return path;
	}

}
