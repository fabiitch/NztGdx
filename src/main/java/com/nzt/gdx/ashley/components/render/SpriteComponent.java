package com.nzt.gdx.ashley.components.render;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzt.gdx.ashley.components.base.BaseComponent;
import com.nzt.gdx.ashley.systems.Rendering2DSystem;

/**
 * Base component for sprite used by {@link Rendering2DSystem}
 * @author fabiitch
 *
 */
public class SpriteComponent extends BaseComponent {

	public Sprite sprite;

	public SpriteComponent(Texture texture) {
		super();
		this.sprite = new Sprite(texture);
		sprite.setOriginCenter();
	}

	public SpriteComponent(Texture texture, float width, float height) {
		this(texture);
		sprite.setSize(width, height);
		sprite.setOriginCenter();
	}

	public SpriteComponent(Texture texture, float size) {
		this(texture);
		sprite.setSize(size * 2, size * 2);
		sprite.setOriginCenter();
	}
}
