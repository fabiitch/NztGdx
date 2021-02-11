package com.nzt.gdx.graphics.renderables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * progress bar with ShapeRenderer (rectangle bar) it use 2 rectangle, one as
 * border(ShapeType.Filled) and one inside(ShapeType.Line)
 * 
 * @author fabiitch
 */
public class SimpleNzProgressBar implements ShapeRenderable {
	private Rectangle rect;
	public float percent;
	public Color borderColor;
	public Color insideColor;
	public boolean horizontal;

	public SimpleNzProgressBar(boolean vertical, float x, float y, float witdh, float height, Color insideColor,
							   Color borderColor, float percent) {
		super();
		this.rect = new Rectangle(x, y, witdh, height);
		this.insideColor = insideColor;
		this.borderColor = borderColor;
		this.horizontal = !vertical;
		this.percent = percent;
	}

	public SimpleNzProgressBar(float x, float y, float witdh, float height, Color insideColor, Color borderColor,
							   float percent) {
		this(false, x, y, witdh, height, insideColor, borderColor, percent);
	}

	public SimpleNzProgressBar(float x, float y, float witdh, float height, Color insideColor, Color borderColor) {
		this(false, x, y, witdh, height, insideColor, borderColor, 0);
	}

	public SimpleNzProgressBar(Rectangle rect, Color insideColor, Color borderColor, float percent) {
		super();
		this.rect = rect;
		this.insideColor = insideColor;
		this.borderColor = borderColor;
		this.horizontal = true;
	}

	public SimpleNzProgressBar(Rectangle rect, Color insideColor, Color borderColor) {
		this(rect, insideColor, borderColor, 0);
	}

	public SimpleNzProgressBar(Rectangle rect) {
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

	@Override
	public void render(ShapeRenderer shapeRenderer) {
		shapeRenderer.set(ShapeType.Filled);
		shapeRenderer.setColor(insideColor);
		if (horizontal) {
			shapeRenderer.rect(rect.x, rect.y, percent * rect.width, rect.height);
		} else {
			shapeRenderer.rect(rect.x, rect.y, rect.width, percent * rect.height);
		}
		shapeRenderer.set(ShapeType.Line);
		shapeRenderer.setColor(borderColor);
		shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
	}
}