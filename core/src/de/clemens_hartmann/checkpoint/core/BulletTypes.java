package de.clemens_hartmann.checkpoint.core;

public enum BulletTypes {
	
	Bullet1("Bullet.png", 50, 5);
	
	double damage;
	double speed;
	double explosionRange;
	String textureName;
	
	//Constructor for Normal Bullets
	BulletTypes(String textureName, double speed, double damage) {
		this.damage = damage;
		this.textureName = textureName;
		this.speed = speed;
	}
	
	//Constructor for Artillery Bullets
	BulletTypes(String textureName, double speed ,double damage, double explosionRange) {
		this.damage = damage;
		this.explosionRange = explosionRange;
		this.textureName = textureName;
		this.speed = speed;
	}
}
