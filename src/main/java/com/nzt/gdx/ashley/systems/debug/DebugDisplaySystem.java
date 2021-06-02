package com.nzt.gdx.ashley.systems.debug;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.base.systems.NzIteratingSystem;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.properties.DebugEntityComponent;

public class DebugDisplaySystem extends NzIteratingSystem {
    public static final ComponentMapper<DebugEntityComponent> debugMapper = DebugEntityComponent.mapper;
    public static final ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;

    private final SpriteBatch spriteBatch;
    private final BitmapFont font;
    private final Camera camera;

    public DebugDisplaySystem(SpriteBatch spriteBatch, Camera camera, int orderSystem) {
        this(spriteBatch, camera, 1, orderSystem);
    }

    public DebugDisplaySystem(SpriteBatch spriteBatch, Camera camera, float scale) {
        this(spriteBatch, camera, scale, NztSystemsOrder.HUD_DEBUG);
    }

    public DebugDisplaySystem(SpriteBatch spriteBatch, Camera camera, float scale, int orderSystem) {
        super(Family.all(DebugEntityComponent.class, PositionComponent.class).get(),
                orderSystem);
        this.spriteBatch = spriteBatch;
        this.font = new BitmapFont();
        font.getData().setScale(scale);
        font.setColor(Color.RED);
        font.setUseIntegerPositions(false);
        this.camera = camera;
    }

    @Override
    public void update(float dt) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        super.update(dt);
        spriteBatch.end();
    }


    private final Vector3 tmp = new Vector3();

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        DebugEntityComponent debug = debugMapper.get(entity);
        PositionComponent positionComponent = posMapper.get(entity);
        if (positionComponent != null) {
            tmp.set(positionComponent.position);
            for (Object o : debug.toDisplay) {
                font.draw(spriteBatch, o.toString(), tmp.x, tmp.y);
                tmp.y += font.getLineHeight();
            }
        }
    }
}
