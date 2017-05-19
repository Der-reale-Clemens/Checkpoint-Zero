package de.clemens_hartmann.checkpoint.core;

public class TowerArtillery extends Tower {

	public TowerArtillery(TowerTypes towerType, int x, int y) {
		super(towerType, x, y);
	}

	/*@Override
	public void update(float delta) {
		timeSinceLastShot += delta;
		
		if(!hasTarget || findDistance(target)  > towerType.range) {
			target = findTarget();
		} else {
			setAngle(calculateAngle());
			if(timeSinceLastShot > towerType.reloadTime) 
				shoot();
		}
		if(target != null && !target.isAlive()) {
			hasTarget = false;
		}
	}*/

	@Override
	protected void shoot() {
		timeSinceLastShot = 0;
		BulletManager.addBullet(new BulletArtillery(BulletTypes.ArtilleryBullet, target, getX(), getY()));
	}

}
