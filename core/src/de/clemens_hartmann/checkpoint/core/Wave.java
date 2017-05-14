package de.clemens_hartmann.checkpoint.core;

public class Wave {
	//Enemy : Amount
	//Spawntime -> times between spawns
	//Wavetime -> when over next Wave Spawns
	
	//Single EnemyType 
	//Spawntime
	//amount
	
	private EnemyTypes enemyType;
	private long spawnTime;
	private int amount;
	
	/**
	 * 
	 * @param enemyType the enemy type of the Wave
	 * @param amount amount of enemys in the Wave
	 * @param spawnTime delay between enemy spawns in Millis
	 */
	public Wave(EnemyTypes enemyType, int amount, long spawnTime) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.amount = amount;
	}
	
	public EnemyTypes getEnemyType() {
		return enemyType;
	}
	
	public long getSpawnTime() {
		return spawnTime;
	}
	
	public int getAmount() {
		return amount;
	}
}
