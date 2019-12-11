package com.nzt.gdx.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * progress bar with ShapeRenderer (rectangle bar)
 */
public class ProgressBar_SR {
	private Rectangle rect;
	private float percent;

	private Color borderColor;
	private Color insideColor;

	public ProgressBar_SR(float x, float y, float witdh, float height, Color insideColor, Color borderColor) {
		super();
		rect = new Rectangle(x, y, witdh, height);
		this.insideColor = insideColor;
		this.borderColor = borderColor;
	}

	public ProgressBar_SR(Rectangle rect, Color insideColor, Color borderColor) {
		super();
		this.rect = rect;
		this.insideColor = insideColor;
		this.borderColor = borderColor;
	}

	public ProgressBar_SR(Rectangle rect) {
		this(rect, Color.RED, Color.BLUE);
	}

	/**
	 * @param percent : <1
	 * 
	 */
	public void updatePercent(float percent) {
		this.percent = percent;
	}

	public void updatePosition(Vector2 pos) {
		this.rect.setX(pos.x);
		this.rect.setY(pos.y);
	}

	public void updatePosition(float x, float y) {
		this.rect.x = x;
		this.rect.y = y;
	}

	public void updateSize(Vector2 pos) {
		this.rect.setSize(pos.x, pos.y);
	}

	public void updateSize(float witdh, float height) {
		this.rect.setSize(witdh, height);
	}

	public void render(ShapeRenderer shapeRenderer) {
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.setColor(insideColor);
		shapeRenderer.rect(rect.x, rect.y, percent * rect.width, rect.height);
		shapeRenderer.set(ShapeType.Line);
		shapeRenderer.setColor(borderColor);
		shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
	}
}