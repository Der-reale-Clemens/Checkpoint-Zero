package de.clemens_hartmann.checkpoint.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;

public abstract class Tower implements Disposable, Updateable, Drawable{
	private final int TEX_SIZE = Config.TEX_SIZE;
	
	protected TowerTypes towerType;
	private int x;
	private int y;
	private Texture sprite;
	private Texture spriteGun;
	private float angle;
	protected long timeSinceLastShot = 0;
	protected boolean hasTarget = false;
	protected Enemy target;
	
	public Tower(TowerTypes towerType, int x, int y) {
		this.towerType = towerType;
		this.x = x*TEX_SIZE;
		this.y = y*TEX_SIZE;
		this.sprite = new Texture(Gdx.files.internal(towerType.textureNameBase));
		this.spriteGun = new Texture(Gdx.files.internal(towerType.textureNameGun));
	}
	
	public void update(float delta) {
		timeSinceLastShot += delta;
		
		if(!hasTarget || findDistance(target)  > towerType.range) {
			target = findTarget();
		} else {
			setAngle(calculateAngle());
			if(timeSinceLastShot > towerType.reloadTime) 
				shoot();
		}
		if(target != null && !target.isAlive()) {
			hasTarget = false;
		}
	}
	
	protected Enemy findTarget() {
		Enemy closest = null;
		float closestDistance = 100000;
		for(Enemy enemy : EnemyManager.getEnemys()) {
			if(isInRange(enemy) && findDistance(enemy) < closestDistance) {
				closest = enemy;
				closestDistance = findDistance(enemy);
			}
		}
		if(closest == null) 
			hasTarget = false;
		else 
			hasTarget = true;
		return closest;
	}
	
	private boolean isInRange(Enemy enemy) {
		float xDistance = Math.abs(enemy.getX() - x);
		float yDistance = Math.abs(enemy.getY() - y);
		if(xDistance < towerType.range && yDistance < towerType.range)
			return true;
		return false;
	}
	
	protected float findDistance(Enemy enemy) {
		float xDistance = Math.abs(enemy.getX() - x);
		float yDistance = Math.abs(enemy.getY() - y);
		return xDistance + yDistance;
	}
	
	protected float calculateAngle() {
		double tempAngle = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(tempAngle) - 90;
	}
	
	protected abstract void shoot();
	
	protected void setAngle(float angle) {
		this.angle = angle;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	@Override
	public void draw(Checkpoint game) {
		game.batch.draw(sprite, x, y, TEX_SIZE/2, TEX_SIZE/2, TEX_SIZE, TEX_SIZE, 1, 1,
				0, 0, 0, TEX_SIZE, TEX_SIZE, false, true);
		game.batch.draw(spriteGun, x, y, TEX_SIZE/2, TEX_SIZE/2, TEX_SIZE, TEX_SIZE, 1, 1,
				angle, 0, 0, TEX_SIZE, TEX_SIZE, true, false);
	}

	@Override
	public void dispose() {
		sprite.dispose();
		spriteGun.dispose();
	}
}
