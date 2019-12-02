package com.nzt.gdx.ashley.components.render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.ashley.components.base.BaseComponent;

public class SpriteComponent extends BaseComponent {

	public Sprite sprite;

	public SpriteComponent(Entity e, Texture texture) {
		super(e);
		this.sprite = new Sprite(texture);
		sprite.setOriginCenter();
	}

	public SpriteComponent(Entity e, Texture texture, float width, float height) {
		this(e, texture);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
	}

	public SpriteComponent(Entity e, Texture texture, float size) {
		this(e, texture);
		sprite.setSize(size * 2, size * 2);
		sprite.setOriginCenter();
	}
}
