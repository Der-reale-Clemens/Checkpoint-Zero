package de.clemens_hartmann.checkpoint.core;

public class TowerQuickfire extends Tower {

	private boolean active;
	private long timeSinceLastBullet = 0;
	private int bulletsShot = 0;
	private int bulletsInBarrage;
	private long bulletDelay;
	
	public TowerQuickfire(TowerTypes towerType, int x, int y) {
		super(towerType, x, y);
		this.bulletsInBarrage = towerType.bulletsInBarrage;
		this.bulletDelay = towerType.delayBetweenBullets;
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
	}

}
