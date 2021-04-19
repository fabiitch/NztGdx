package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;

/**
 * Position component, contains V3 position and rotation.
 *
 * @author fabiitch
 */
public class PositionComponent extends PoolableComponent {

    public static ComponentMapper<PositionComponent> mapper = ComponentMapper.getFor(PositionComponent.class);

    public final Vector3 position = new Vector3();
    private final Vector2 positionV2 = new Vector2();

    public float angleRadian = 0.0f;

    public PositionComponent() {
        super();
    }

    @Override
    public void reset() {
        this.position.setZero();
        this.positionV2.setZero();
        this.angleRadian = 0f;
    }

    public void setPosition(Vector2 position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    public void setAngleDeg(float angleDeg){
        this.angleRadian = MathUtils.degRad * angleDeg;
    }

    public Vector2 getPosition() {
        return positionV2.set(position.x, position.y);
    }

    public static void updatePositionFromBody(Entity entity) {
        B2DBodyComponent b2DBodyComponent = B2DBodyComponent.mapper.get(entity);

        Vector2 position = b2DBodyComponent.body.getPosition();

        PositionComponent positionComponent = mapper.get(entity);
        positionComponent.setPosition(position);
    }

    public static void updateAngleFromBody(Entity entity) {
        B2DBodyComponent b2DBodyComponent = B2DBodyComponent.mapper.get(entity);

        float angle = b2DBodyComponent.body.getAngle();
        mapper.get(entity).angleRadian = angle;
    }
}
