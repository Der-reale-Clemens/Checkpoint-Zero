package de.clemens_hartmann.checkpoint.core;

public enum BulletTypes {
	
	BulletNormal("BulletNormal.png", 50, 5),
	BulletIce("BulletIce.png", 50, 5, 0.5f),
	BulletArtillery("BulletArtillery.png", 50, 15, 100d),
	BulletPiercing("BulletPiercing.png", 70, 1);
	
	// Artillery 
	
	int damage;
	double speed;
	double explosionRange;
	float freezeFactor;
	String textureName;
	
	//Constructor for Normal Bullets
	BulletTypes(String textureName, double speed, int damage) {
		this.damage = damage;
		this.textureName = textureName;
		this.speed = speed;
	}
	
	//Constructor for Ice Bullets
	BulletTypes(String textureName, double speed, int damage, float freezeFactor) {
		this.textureName = textureName;
		this.speed = speed;
		this.damage = damage;
		this.freezeFactor = freezeFactor;
	}
	
	//Constructor for Artillery Bullets
	BulletTypes(String textureName, double speed, int damage, double explosionRange) {
		this.damage = damage;
		this.explosionRange = explosionRange;
		this.textureName = textureName;
		this.speed = speed;
	}
}
