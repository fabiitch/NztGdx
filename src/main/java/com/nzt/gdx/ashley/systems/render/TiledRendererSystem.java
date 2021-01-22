package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.nzt.gdx.ashley.NztSystemsOrder;

public class TiledRendererSystem extends EntitySystem {

	public OrthoCachedTiledMapRenderer cachedTiledMapRenderer;
	private OrthographicCamera gameCamera;

	public TiledRendererSystem(TiledMap map, OrthographicCamera gameCamera) {
		super(NztSystemsOrder.TILED_MAP_RENDER);
		this.gameCamera = gameCamera;
		cachedTiledMapRenderer = new OrthoCachedTiledMapRenderer(map);
	}

	public TiledRendererSystem(TiledMap map, OrthographicCamera gameCamera, float PPM) {
		super(NztSystemsOrder.TILED_MAP_RENDER);
		this.gameCamera = gameCamera;
		cachedTiledMapRenderer = new OrthoCachedTiledMapRenderer(map, 1 / PPM);
	}

	public void update(float dt) {
		cachedTiledMapRenderer.setView(gameCamera);
		cachedTiledMapRenderer.render();
	}

	public void dispose() {
		cachedTiledMapRenderer.dispose();
	}
}
