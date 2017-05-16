package de.clemens_hartmann.checkpoint.core;

public class TowerCannon2 extends Tower {

	private boolean active;
	private long timeSinceLastBullet = 0;
	private int bulletsShot = 0;
	private final int bulletsInBarrage = 3;
	private final long bulletDelay = 150;
	
	public TowerCannon2(TowerTypes towerType, int x, int y) {
		super(towerType, x, y);
	}

	@Override
	public void update(float delta) {
		timeSinceLastShot += delta;
		timeSinceLastBullet += delta;
		
		if(!hasTarget || findDistance(target)  > towerType.range) {
			target = findTarget();
		} else {
			setAngle(calculateAngle());
			if(timeSinceLastShot > towerType.reloadTime) 
				shoot();
			if(active && timeSinceLastBullet > bulletDelay && bulletsShot < bulletsInBarrage) {
				BulletManager.addBullet(towerType.bullet, target, getX(), getY());
				timeSinceLastBullet = 0;
				bulletsShot++;
			}
			if(bulletsShot >= bulletsInBarrage) {
				bulletsShot = 0;
				active = false;
			}
		}
		if(target != null && !target.isAlive()) {
			hasTarget = false;
		}
	}

	@Override
	protected void shoot() {
		timeSinceLastShot = 0;
		timeSinceLastBullet = 0;
		active = true;
		//BulletManager.addBullet(towerType.bullet, target, getX(), getY());
	}

}
