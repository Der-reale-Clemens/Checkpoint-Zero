package de.clemens_hartmann.checkpoint.core;

public enum TowerTypes {
	TowerCannon("cannonBase.png", "cannonGun.png", BulletTypes.Bullet1, 300, 2000),
	TowerQuickfire("cannonBase.png","cannonGun.png", BulletTypes.Bullet1, 300, 2000, 3, 150);
	
	BulletTypes bullet;
	double range;
	long reloadTime;
	int bulletsInBarrage;
	long delayBetweenBullets;
	String textureNameBase;
	String textureNameGun;
	
	//Constructor for TowerTypes
	TowerTypes(String textureNameBase, String textureNameGun, BulletTypes bullet, double range, long reloadTime) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.textureNameBase = textureNameBase;
		this.textureNameGun = textureNameGun;
	}
	
	TowerTypes(String textureNameBase, String textureNameGun, BulletTypes bullet, double range, long reloadTime, int bulletsInBarrage, long delayBetweenBullets) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.bulletsInBarrage = bulletsInBarrage;
		this.delayBetweenBullets = delayBetweenBullets;
		this.textureNameBase = textureNameBase;
		this.textureNameGun = textureNameGun;
	}
}
