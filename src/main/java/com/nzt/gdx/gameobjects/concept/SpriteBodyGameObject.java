package com.nzt.gdx.gameobjects.concept;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;


public abstract class SpriteBodyGameObject extends AbstractBodyGameObject {
	public Sprite sprite;
	protected boolean isVisible = true;
	protected float animationSpeed;
	protected Animation<TextureRegion> animation;

	/**
	 * Sprite from rectangle
	 * 
	 * @param name
	 * @param texture
	 * @param body
	 * @param rect
	 */
	public SpriteBodyGameObject(String name, Body body, Rectangle rect, Texture texture) {
		super(name, body);
		sprite = new Sprite(texture);
		sprite.setSize(rect.getWidth(), rect.getHeight());
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				rect.getWidth(), rect.getHeight());
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

	}

	/**
	 * Sprite circle
	 * 
	 * @param name
	 * @param body
	 * @param texture
	 * @param sizeCircle
	 */
	public SpriteBodyGameObject(String name, Body body, float sizeCircle, Texture texture) {
		super(name, body);
		sizeCircle = sizeCircle * 2;
		sprite = new Sprite(texture);
		sprite.setSize(sizeCircle, sizeCircle);
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				sizeCircle, sizeCircle);
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));
	}

	/**
	 * Sprite from size
	 * 
	 * @param name
	 * @param body
	 * @param texture
	 * @param width
	 * @param height
	 */
	public SpriteBodyGameObject(String name, Body body, float width, float height, Texture texture) {
		super(name, body);
		sprite = new Sprite(texture);
		sprite.setSize(width, height);
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				width, height);
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

	}

	/**
	 * AnimatedSprite from rectangle
	 * 
	 * @param name
	 * @param body
	 * @param rect
	 * @param textureAtlas
	 */
	public SpriteBodyGameObject(String name, Body body, Rectangle rect, TextureAtlas textureAtlas) {
		super(name, body);
		animation = new Animation<TextureRegion>(animationSpeed, textureAtlas.getRegions(), PlayMode.LOOP);
		sprite = new AnimatedSprite(animation);
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				rect.getWidth(), rect.getHeight());
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

	}

	/**
	 * AnimatedRectangle from size
	 * 
	 * @param name
	 * @param body
	 * @param width
	 * @param height
	 * @param textureAtlas
	 * @param animationSpeed
	 */
	public SpriteBodyGameObject(String name, Body body, float animationSpeed, float width, float height,
			TextureAtlas textureAtlas) {
		super(name, body);
		animation = new Animation<TextureRegion>(animationSpeed, textureAtlas.getRegions(), PlayMode.LOOP);
		sprite = new AnimatedSprite(animation);
		sprite.setSize(width, height);
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				width, height);
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

	}

	/**
	 * AnimatedSprite from circle
	 * 
	 * @param name
	 * @param body
	 * @param width
	 * @param height
	 * @param textureAtlas
	 * @param animationSpeed
	 */
	public SpriteBodyGameObject(String name, Body body, float animationSpeed, float sizeCircle,
			TextureAtlas textureAtlas) {
		super(name, body);
		animation = new Animation<TextureRegion>(animationSpeed, textureAtlas.getRegions(), PlayMode.LOOP);
		sprite = new AnimatedSprite(animation);
		sprite.setSize(sizeCircle, sizeCircle);
		sprite.setBounds(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2,
				sizeCircle, sizeCircle);
		sprite.setOriginCenter();
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));
	}

	@Override
	public void update(float dt) {
		sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

	}

	public void render(SpriteBatch batch) {
		if (isVisible) {
			this.sprite.draw(batch);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		isVisible = false;
		this.sprite = null;
	}

}
