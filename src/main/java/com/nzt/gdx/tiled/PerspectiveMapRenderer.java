package com.nzt.gdx.tiled;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

/**
 * TODO voir avec MFLMapRenderer
 */
public class PerspectiveMapRenderer extends OrthoCachedTiledMapRenderer {

    static private final float tolerance = 0.00001f;

    public PerspectiveMapRenderer(TiledMap map) {
        super(map);
    }

    public PerspectiveMapRenderer(TiledMap map, float unitScale) {
        super(map, unitScale);
    }

    public PerspectiveMapRenderer(TiledMap map, float unitScale, int cacheSize) {
        super(map, unitScale, cacheSize);
    }

    //TODO pas bon
    public void setView(PerspectiveCamera camera) {
        spriteCache.setProjectionMatrix(camera.combined);
        float width = camera.viewportWidth + maxTileWidth * 2 * unitScale;
        float height = camera.viewportHeight + maxTileHeight * 2 * unitScale;
        viewBounds.set(camera.position.x - width / 2, camera.position.y - height / 2, width, height);

        if ((canCacheMoreW && viewBounds.x < cacheBounds.x - tolerance) || //
                (canCacheMoreS && viewBounds.y < cacheBounds.y - tolerance) || //
                (canCacheMoreE && viewBounds.x + viewBounds.width > cacheBounds.x + cacheBounds.width + tolerance) || //
                (canCacheMoreN && viewBounds.y + viewBounds.height > cacheBounds.y + cacheBounds.height + tolerance) //
        ) cached = false;
    }
}
