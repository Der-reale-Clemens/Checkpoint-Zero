package de.clemens_hartmann.checkpoint.core;

public enum TileTypes {
	GrassTile(false, true, "TileGrass.png"),
	RoadTile(true, false, "RoadTile.png");
	
	boolean walkable;
	boolean buildable;
	String textureName;
	
	//Constructor for TileTypes
	TileTypes(boolean walkable, boolean buildable, String textureName) {
		this.textureName = textureName;
		this.walkable = walkable;
		this.buildable = buildable;
	}
}
