package com.nzt.gdx.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class DrawableUtils {

    public static TextureRegionDrawable fromTexture(Texture texture) {
        return new TextureRegionDrawable(new TextureRegion(texture));
    }

    public static TextureRegionDrawable fromTextureRegion(TextureRegion textureRegion) {
        return new TextureRegionDrawable(textureRegion);
    }
}
