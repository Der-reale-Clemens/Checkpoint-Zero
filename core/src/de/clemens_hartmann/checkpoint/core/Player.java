package de.clemens_hartmann.checkpoint.core;

import de.clemens_hartmann.checkpoint.Config;

public class Player {
	private static final int TEX_SIZE = Config.TEX_SIZE;
	
	private static int money;
	private static int selectedTower;
	
	public Player() {
		
	}
	
	public static void addTower(int x, int y) {
		/*if(Map.getTile(x/TEX_SIZE, y/TEX_SIZE).getTileType().walkable == true  || TowerManager.findTower(x, y))
			return;*/
		switch(selectedTower) {
		case 0:
			TowerManager.addTower(TowerTypes.TowerCannon, x, y);
			break;
		case 1: 
			TowerManager.addTower(TowerTypes.TowerQuickfire, x, y);
			break;
		}
	}
	
	public static void setSelectedTower(int pselectedTower) {
		selectedTower = pselectedTower;
	}
}
