package de.clemens_hartmann.checkpoint.core;

public enum TowerTypes {
	TowerCannon("Tower", BulletTypes.Bullet1, 300, 2000);
	
	BulletTypes bullet;
	double range;
	double reloadTime;
	String textureName;
	
	//Constructor for TowerTypes
	TowerTypes(String textureName, BulletTypes bullet, double range, double reloadTime) {
		this.bullet = bullet;
		this.range = range;
		this.reloadTime = reloadTime;
		this.textureName = textureName;
	}
}
