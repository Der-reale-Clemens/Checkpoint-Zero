package de.clemens_hartmann.checkpoint.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.clemens_hartmann.checkpoint.Checkpoint;

public class TowerManager {
	private static List<Tower> towers = new LinkedList<Tower>();
	
	//Update all Towers
	public void update(float delta) {
		//TODO
		Iterator<Tower> iter = towers.iterator();
		while(iter.hasNext()) {
			Tower tower = iter.next();
			tower.update(delta);
			
		}
	}
	
	public static void addTower(TowerTypes towerType, int x, int y) {
		towers.add(new TowerCannon(towerType, x, y));
	}
	
	public void draw(final Checkpoint game) {
		game.batch.begin();
		for(Tower tower : towers) {
			tower.draw(game);
		}
		game.batch.end();
	}
	
	public void dispose() {
		for(Tower tower : towers) {
			tower.dispose();
		}
		towers.clear();
	}
}
