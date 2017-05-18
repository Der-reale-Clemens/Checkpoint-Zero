package de.clemens_hartmann.checkpoint.core;

public class EnemyRed extends Enemy{
	
	public EnemyRed(EnemyTypes enemyType, float x, float y) {
		super(enemyType, x, y);
	}

	@Override
	public void update(float delta) {
		if(health < 0) 
			isAlive = false;
		move(delta);
	}
}
