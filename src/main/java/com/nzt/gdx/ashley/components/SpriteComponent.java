package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent implements Component {

	public Sprite sprite;

	public SpriteComponent(Texture texture) {
		this.sprite = new Sprite(texture);
		sprite.setSize(100, 100);
	}

}
