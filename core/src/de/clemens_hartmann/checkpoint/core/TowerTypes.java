package de.clemens_hartmann.checkpoint.core;

public enum TowerTypes {
	TowerCannon("cannonBase.png", "cannonGun.png", BulletTypes.Bullet1, 300, 2000);
	
	BulletTypes bullet;
	double range;
	double reloadTime;
	String textureNameBase;
	String textureNameGun;
	
	//Constructor for TowerTypes
	TowerTypes(String textureNameBase, String textureNameGun, BulletTypes bullet, double range, double reloadTime) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.textureNameBase = textureNameBase;
		this.textureNameGun = textureNameGun;
	}
}
