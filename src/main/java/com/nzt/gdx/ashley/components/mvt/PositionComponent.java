package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

/**
 * Position component, contains V3 order and rotation.
 */
public class PositionComponent extends PoolableComponent {

    public static final ComponentMapper<PositionComponent> mapper = ComponentMapper.getFor(PositionComponent.class);

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

    public void setAngleDeg(float angleDeg) {
        this.angleRadian = MathUtils.degRad * angleDeg;
    }

    public Vector2 getPosition() {
        return positionV2.set(position.x, position.y);
    }

}
