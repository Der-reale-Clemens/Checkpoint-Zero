package de.clemens_hartmann.checkpoint.core;

public enum TowerTypes {
	TowerCannon("turret-base.png", "turret-5-1.png", BulletTypes.BulletNormal, 500, 2000, 100),
	TowerQuickfire("turret-base.png","turret-4-1.png", BulletTypes.BulletNormal, 300, 2000, 3, 150, 150),
	TowerIce("turret-base.png", "turret-1-1.png", BulletTypes.BulletIce, 300, 2000, 150),
	TowerArtillery("turret-base.png", "turret-2-1.png", BulletTypes.BulletArtillery, 500, 1000, 100),
	TowerPiercing("turret-base.png", "turret-6-1.png", BulletTypes.BulletPiercing, 300, 1000, 150);
	
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
