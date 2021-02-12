package com.nzt.gdx.tiled;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
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
        map = tmxMapLoader.load(path, parameters);
        if (loadObjects)
            loadMapObjects();
    }

    protected Rectangle replacemapRectangle(MapObject mapObject) {
        Rectangle rect = ((RectangleMapObject) mapObject).getRectangle();
//        rect.x += +rect.width / 2;
//        rect.y += rect.height / 2;
        return rect;
    }

    public TiledMap getMap() {
        return this.map;
    }

    public Object getProperties(MapObject mapObject, String name) {
        MapProperties properties = mapObject.getProperties();
        return properties.get(name);
    }

    public String getStringProperties(MapObject mapObject, String name) {
        MapProperties properties = mapObject.getProperties();
        Object value = properties.get(name);
        return value != null ? value.toString() : "";
    }

    public int getIntProperties(MapObject mapObject, String name) {
        MapProperties properties = mapObject.getProperties();
        Object value = properties.get(name);
        return value != null ? Integer.parseInt(value.toString()) : 0;
    }

    public float getFloatProperties(MapObject mapObject, String name) {
        MapProperties properties = mapObject.getProperties();
        Object value = properties.get(name);
        return value != null ? Float.parseFloat(value.toString()) : 0;
    }
}
