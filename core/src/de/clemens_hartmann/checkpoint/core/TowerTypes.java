package de.clemens_hartmann.checkpoint.core;

public enum TowerTypes {
	TowerCannon("cannonBase.png", "cannonGun.png", BulletTypes.Bullet1, 500, 2000, 100),
	TowerQuickfire("turret-base.png","turret-4-1.png", BulletTypes.Bullet1, 300, 2000, 3, 150, 150),
	TowerIce("turret-base.png", "turret-1-1.png", BulletTypes.IceBullet, 300, 2000, 150);
	
	BulletTypes bullet;
	double range;
	long reloadTime;
	int bulletsInBarrage;
	long delayBetweenBullets;
	String textureNameBase;
	String textureNameGun;
	
	//Constructor for TowerTypes
	TowerTypes(String textureNameBase, String textureNameGun, BulletTypes bullet, double range, long reloadTime, int cost) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.textureNameBase = textureNameBase;
		this.textureNameGun = textureNameGun;
	}
	
	//Constructor for Quickfire Tower
	TowerTypes(String textureNameBase, String textureNameGun, BulletTypes bullet, double range, long reloadTime, int bulletsInBarrage, long delayBetweenBullets, int cost) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.bulletsInBarrage = bulletsInBarrage;
		this.delayBetweenBullets = delayBetweenBullets;
		this.textureNameBase = textureNameBase;
		this.textureNameGun = textureNameGun;
	}
}
