package de.clemens_hartmann.checkpoint.core;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;

public class Map {
	private static Tile[][] map;
	public static final int HEIGHT = Config.NUM_CELLS_HEIGTH;
	public static final int WIDTH = Config.NUM_CELLS_WIDTH;
	public static final int TEX_SIZE = Config.TEX_SIZE;
	
	public static void createMap(int[][] newMap) {
		map = new Tile[WIDTH][HEIGHT];
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				switch(newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(TileTypes.GrassTile, i*TEX_SIZE, j*TEX_SIZE);
					break;
				case 1:
					map[i][j] = new Tile(TileTypes.RoadTile, i*TEX_SIZE, j*TEX_SIZE );
					break;
				} //end-switch
			} // end-for j
		} // end-for i
	}
	
	public static void draw(final Checkpoint game) {
		game.batch.disableBlending();
		game.batch.begin();
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				game.batch.draw(map[j][i].getTexture(), map[j][i].getX(), map[j][i].getY());
			}
		}
		game.batch.end();
		game.batch.enableBlending();
	}

	public static Tile getTile(int x, int y) {
		return map[x][y];
	}
	
	/**
	 * Dispose of Textures of all Tile elements of the Map
	 */
	public static void dispose() {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				map[i][j].dispose();
			}
		}
	}
}