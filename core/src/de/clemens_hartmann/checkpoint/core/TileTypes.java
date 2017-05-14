package de.clemens_hartmann.checkpoint.core;

public enum TileTypes {
	GrassTile(false, "TileGrass.png"),
	RoadTile(true, "RoadTile.png");
	
	boolean walkable;
	String textureName;
	
	//Constructor for TileTypes
	TileTypes(boolean walkable, String textureName) {
		this.textureName = textureName;
		this.walkable = walkable;
	}
}
