package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public class TiledOrthoCachedRendererSystem extends EntitySystem {

    public OrthoCachedTiledMapRenderer cachedTiledMapRenderer;
    private OrthographicCamera gameCamera;

    public TiledOrthoCachedRendererSystem(TiledMap map, OrthographicCamera gameCamera, int systemOrder) {
        this(map, gameCamera, 1, systemOrder);
    }

    public TiledOrthoCachedRendererSystem(TiledMap map, OrthographicCamera gameCamera) {
        this(map, gameCamera, NztSystemsOrder.TILED_MAP_RENDER);
    }

    public TiledOrthoCachedRendererSystem(TiledMap map, OrthographicCamera gameCamera, float PPM) {
        this(map, gameCamera, PPM, NztSystemsOrder.TILED_MAP_RENDER);
    }

    public TiledOrthoCachedRendererSystem(TiledMap map, OrthographicCamera gameCamera, float PPM, int systemOrder) {
        super(systemOrder);
        this.gameCamera = gameCamera;
        cachedTiledMapRenderer = new OrthoCachedTiledMapRenderer(map, 1 / PPM);
    }

    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        cachedTiledMapRenderer.setView(gameCamera);
        cachedTiledMapRenderer.render();
        PerformanceFrameUtils.endSystem(this);
    }

    public void dispose() {
        cachedTiledMapRenderer.dispose();
    }

}
