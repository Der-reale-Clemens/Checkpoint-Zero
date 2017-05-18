package de.clemens_hartmann.checkpoint.core;

public enum Waves {
	Wave1(EnemyTypes.Enemy1, 500, 1, 6000),
	Wave2(EnemyTypes.Enemy1, 500, 5, 6000),
	Wave3(EnemyTypes.Enemy1, 350, 10, 4000);
	
	Wave wave;
	long waveDelay;
	
	Waves(EnemyTypes enemyType, long delay, int amount, long waveDelay) {
		wave = new Wave(enemyType, amount, delay);
		this.waveDelay = waveDelay;
	}
}
