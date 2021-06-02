package com.nzt.gdx.ashley.components.properties;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.base.components.BaseComponent;

public class DebugEntityComponent extends BaseComponent {
    public static final ComponentMapper<DebugEntityComponent> mapper = ComponentMapper.getFor(DebugEntityComponent.class);
    public Array<Object> toDisplay;

    public DebugEntityComponent() {
        super();
    }

    public DebugEntityComponent(Object... toDebugs) {
        this.toDisplay = new Array<>(toDebugs);
    }

}
