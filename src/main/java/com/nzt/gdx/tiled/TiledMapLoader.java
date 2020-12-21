package com.nzt.gdx.tiled;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;

public abstract class TiledMapLoader extends TmxMapLoader {
    protected TmxMapLoader tmxMapLoader;
    protected TmxMapLoader.Parameters parameters;

    public TiledMapLoader() {
        super();
        parameters = new Parameters();
        parameters.generateMipMaps = true;
        this.tmxMapLoader = new TmxMapLoader();
    }

    public abstract void loadMapObjects();

    public void loadMap(String path) {
        this.loadMap(path, true);
    }

    public void loadMap(String path, boolean loadObjects) {
        map = tmxMapLoader.load("maps/map1.tmx", parameters);
        if (loadObjects)
            loadMapObjects();
    }

    protected Rectangle replacemapRectangle(MapObject mapObject) {
        Rectangle rect = ((RectangleMapObject) mapObject).getRectangle();
        rect.x += +rect.width / 2;
        rect.y += rect.height / 2;
        return rect;
    }

    public TiledMap getMap() {
        return this.map;
    }
}
