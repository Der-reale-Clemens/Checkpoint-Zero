package de.clemens_hartmann.checkpoint.core;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class WaveManager {
	private List<Wave> waves = new ArrayList<Wave>();
	private List<Long> times = new ArrayList<Long>();
	private int wavePos = 0;
	private long timeSinceLastWave;
	private long timeSinceLastSpawn;
	private int amountSpawned;
	private Vector2 startPos = new Vector2();
	
	public WaveManager() {
		waves.add(Waves.Wave1.wave);
		times.add(Waves.Wave1.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		waves.add(Waves.Wave2.wave);
		times.add(Waves.Wave2.waveDelay);
		startPos.x = 64;
		startPos.y = 0;
	}
	
	/**
	 * Don't touch this code! It's spaghetti but it works
	 * @param delta time since last frame
	 */
	public void update(float delta) {
		if(!isWaveLeft())
			return;
		if(timeSinceLastWave > times.get(wavePos)) {
			wavePos++;
			timeSinceLastWave = 0;
			amountSpawned = 0;
			timeSinceLastSpawn = 0;
		} else {
			timeSinceLastWave += delta;
			if(timeSinceLastSpawn > waves.get(wavePos).getSpawnTime()) {
				if(waves.get(wavePos).getAmount() > amountSpawned) {
					EnemyManager.addEnemy(waves.get(wavePos).getEnemyType(), startPos.x , startPos.y);
					timeSinceLastSpawn = 0;
					amountSpawned++;
				}
			} else {
				timeSinceLastSpawn += delta;
			}
		}
	}
	
	private boolean isWaveLeft() {
		try {
			waves.get(wavePos);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
