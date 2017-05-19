package de.clemens_hartmann.checkpoint.core;

public class TowerPiercing extends Tower {

	public TowerPiercing(TowerTypes towerType, int x, int y) {
		super(towerType, x, y);
	}

	@Override
	protected void shoot() {
		timeSinceLastShot = 0;
		BulletManager.addBullet(new BulletPiercing(towerType.bullet, target, getX(), getY()));
	}
}
