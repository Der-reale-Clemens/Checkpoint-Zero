package de.clemens_hartmann.checkpoint.core;

public enum EnemyTypes {
	Enemy1(1,10,10,"Enemy1.png");
	
	float speed;
	int health;
	int strength;
	String textureName;
	
	EnemyTypes(int strength, int health, float speed, String textureName) {
		this.speed = speed;
		this.health = health;
		this.strength = strength;
		this.textureName = textureName;
	}
}
