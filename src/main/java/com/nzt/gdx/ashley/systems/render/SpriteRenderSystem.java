package com.nzt.gdx.ashley.systems.render;

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
import com.nzt.gdx.ashley.components.renders.SpriteComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;

import java.util.Comparator;

/**
 * used for rendering with SB
 * //TODO revoir le sort fait surle ststem et la queue
 */
public class SpriteRenderSystem extends SortedIteratingSystem {
    // component mappers to get components from entities
    private final static ComponentMapper<SpriteComponent> spriteMapper = SpriteComponent.mapper;
    private final static ComponentMapper<PositionComponent> positionMapper = PositionComponent.mapper;


    private final SpriteBatch batch; // a reference to our spritebatch
    private final Camera cam; // a reference to our camera

    private final Array<Entity> renderQueue; // an array used to allow sorting of images allowing us to draw images on top of
    // each other
    private final Comparator<Entity> comparator = new ZComparator(); // a comparator to sort images based on the z order of
    // the

    public SpriteRenderSystem(Camera camera, SpriteBatch sb, int systemOrder) {
        super(Family.all(PositionComponent.class, SpriteComponent.class).get(),
                new ZComparator(),
                systemOrder);
        this.cam = camera;
        // create the array for sorting entities
        renderQueue = new Array<Entity>();
        this.batch = sb; // set our batch to the one supplied in constructor

        PerformanceFrame.addSystem(this);
    }


    @Override
    public void update(float deltaTime) {
        PerformanceFrame.startSystem(this);
        super.update(deltaTime);
        renderQueue.sort(comparator);
        batch.setProjectionMatrix(cam.combined);
        batch.enableBlending();
        batch.begin();

        Sprite sprite;
        Vector3 position;
        for (Entity entity : renderQueue) {
            SpriteComponent spriteC = spriteMapper.get(entity);
            PositionComponent p = positionMapper.get(entity);
            if (spriteC == null || !spriteC.visible) {
                continue;
            }
            sprite = spriteC.sprite;
            position = p.position;
            sprite.setPosition(position.x - sprite.getWidth() / 2, position.y - sprite.getHeight() / 2);
            sprite.setRotation(MathUtils.radiansToDegrees * p.angleRadian);//TODO voir si check, ya dirty=true dedans
            sprite.draw(batch);
        }
        batch.end();
        renderQueue.clear();
        PerformanceFrame.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQueue.add(entity);
    }

    public void dispose() {
        this.renderQueue.clear();
    }

}
