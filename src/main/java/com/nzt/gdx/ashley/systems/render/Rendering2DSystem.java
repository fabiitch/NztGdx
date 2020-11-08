package com.nzt.gdx.ashley.systems.render;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.comparators.ZComparator;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.render.SpriteComponent;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.count.TagCountLogger;

/**
 * used for rendering with SB
 * 
 * @author fabiitch
 *
 */
public class Rendering2DSystem extends SortedIteratingSystem {

	private SpriteBatch batch; // a reference to our spritebatch
	private Camera cam; // a reference to our camera

	private Array<Entity> renderQueue; // an array used to allow sorting of images allowing us to draw images on top of
										// each other
	private Comparator<Entity> comparator = new ZComparator(); // a comparator to sort images based on the z position of
																// the
	// transfromComponent

	// component mappers to get components from entities
	private ComponentMapper<SpriteComponent> spriteMapper = SpriteComponent.mapper;
	private ComponentMapper<PositionComponent> positionMapper = PositionComponent.mapper;
	public Rendering2DSystem(Camera camera, SpriteBatch sb, int order) {
		super(Family.all(PositionComponent.class, SpriteComponent.class).get(), new ZComparator(),
				order);
		this.cam = camera;
		// create the array for sorting entities
		renderQueue = new Array<Entity>();

		this.batch = sb; // set our batch to the one supplied in constructor
	}

	public Rendering2DSystem(Camera camera, SpriteBatch sb) {
		this(camera, sb, NztSystemsOrder.RENDER);
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		TagCountLogger.log(LogTagsBase.SYSTEMS, "render");
		renderQueue.sort(comparator);
		batch.setProjectionMatrix(cam.combined);
		batch.enableBlending();
		batch.begin();

		Sprite sprite;
		Vector3 position;
		for (Entity entity : renderQueue) {
			SpriteComponent spriteC = spriteMapper.get(entity);
			PositionComponent p = positionMapper.get(entity);
			if (spriteC == null) {
				continue;
			}
			sprite = spriteC.sprite;
			position = p.position;

			sprite.setPosition(position.x - sprite.getWidth() / 2, position.y - sprite.getHeight() / 2);
			sprite.setRotation(MathUtils.radiansToDegrees * p.angleRadian);
			if (spriteC.visible)
				sprite.draw(batch);
		}
		batch.end();
		renderQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		renderQueue.add(entity);
	}

}
