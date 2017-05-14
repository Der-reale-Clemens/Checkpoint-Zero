package de.clemens_hartmann.checkpoint.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tile {
	private TileTypes tileType;
	private Texture sprite;
	private final int X;
	private final int Y;
	
	public Tile(TileTypes tileType, int x, int y) {
		this.tileType = tileType;
		sprite = new Texture(Gdx.files.internal(tileType.textureName));
		X = x;
		Y = y;
	}
	
	public Texture getTexture() {
		return sprite;
	}
	public TileTypes getTileType() {
		return tileType;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	
	public void dispose() {
		sprite.dispose();
	}
}