package de.clemens_hartmann.checkpoint.core;

import de.clemens_hartmann.checkpoint.Config;

public class Player {
	private static final int TEX_SIZE = Config.TEX_SIZE;
	
	private static int money;
	private static int selectedTower;
	
	public Player() {

	}
	
	public static void addTower(int x, int y) {
		if(!Map.getTile(x, y).getTileType().buildable || TowerManager.findTower(x*TEX_SIZE, y*TEX_SIZE))
			return;

		switch(selectedTower) {
		case 0:
			TowerManager.addTower(new TowerCannon(TowerTypes.TowerCannon, x, y));
			break;
		case 1: 
			TowerManager.addTower(new TowerQuickfire(TowerTypes.TowerQuickfire, x, y));
			break;
		case 2:
			TowerManager.addTower(new TowerIce(TowerTypes.TowerIce, x, y));
			break;
		case 3:
			TowerManager.addTower(new TowerArtillery(TowerTypes.TowerArtillery, x, y));
			break;
		case 4:
			TowerManager.addTower(new TowerPiercing(TowerTypes.TowerPiercing, x, y));
			break;
		}
	}
	
	public static void removeTower(int x, int y) {
		TowerManager.removeTower(x*TEX_SIZE, y*TEX_SIZE);
	}
	
	public static void setSelectedTower(int pselectedTower) {
		selectedTower = pselectedTower;
	}
}
