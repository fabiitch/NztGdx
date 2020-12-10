package com.nzt.gdx.math.shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

//TODO ??? sers a quoi ? mdr
public class RectangleGrid {

	public static Array<Rectangle> createGrid(int nbCaseWidth, int nbCaseHeight) {
		return createGrid(nbCaseWidth, nbCaseHeight, 0, 0, 0, 0, 0, 0);
	}

	public static Array<Rectangle> createGridWithSpace(int nbCaseWidth, int nbCaseHeight, int spacebetween) {
		return createGrid(nbCaseWidth, nbCaseHeight, spacebetween, spacebetween, 0, 0, 0, 0);
	}

	public static Array<Rectangle> createGridWithSpace(int nbCaseWidth, int nbCaseHeight, int spacebetweenX,
			int spacebetweenY) {
		return createGrid(nbCaseWidth, nbCaseHeight, spacebetweenX, spacebetweenY, 0, 0, 0, 0);
	}

	public static Array<Rectangle> createGridWithSpaceAndPadding(int nbCaseWidth, int nbCaseHeight, int spacebetween,
			int paddingOnAll) {
		return createGrid(nbCaseWidth, nbCaseHeight, spacebetween, spacebetween, paddingOnAll, paddingOnAll,
				paddingOnAll, paddingOnAll);
	}

	public static Array<Rectangle> createGrid(int nbCaseWidth, int nbCaseHeight, int spaceBetweenX, int spaceBetweenY,
			int paddingTop, int paddingBottom, int paddingRight, int paddingLeft) {

		final Array<Rectangle> rectArray = new Array<Rectangle>(nbCaseWidth * nbCaseHeight);

		int totalWidth = Gdx.graphics.getWidth() - (spaceBetweenX * (nbCaseWidth - 1)) - paddingRight - paddingLeft;
		int totalHeight = Gdx.graphics.getHeight() - (spaceBetweenY * (nbCaseHeight - 1)) - paddingTop - paddingBottom;

		int sizeW = totalWidth / nbCaseWidth;
		int sizeH = totalHeight / nbCaseHeight;

		int x = paddingRight, y = paddingBottom;

		for (int i = 0; i < nbCaseHeight; i++) {
			x = paddingRight;
			for (int j = 0; j < nbCaseWidth; j++) {
				rectArray.add(new Rectangle(x, y, sizeW, sizeH));
				x += sizeW + spaceBetweenX;
			}
			y += sizeH + spaceBetweenY;
		}
		return rectArray;
	}
	
}
