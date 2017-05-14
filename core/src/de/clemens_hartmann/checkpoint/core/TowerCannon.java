
package de.clemens_hartmann.checkpoint.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;

public class TowerCannon extends Tower implements Disposable, Drawable, Updateable {
	
	private int x;
	private int y;
	private TowerTypes towerType;
	private Texture sprite;
	private long timeSinceLastShot = 0;
	private Texture spriteGun;
	private boolean hasTarget = false;
	private Enemy target;
	private float angle;
	
	private final int TEX_SIZE = Config.TEX_SIZE;
	private final String PATH = "cannonBase.png";
	private final String PATHCANNON = "cannonGun.png";
	
	public TowerCannon(TowerTypes towerType, int x, int y) {
		this.towerType = towerType;
		this.x = x*TEX_SIZE;
		this.y = y*TEX_SIZE;
		sprite = new Texture(Gdx.files.internal(PATH));
		spriteGun = new Texture(Gdx.files.internal(PATHCANNON));
		this.towerType = TowerTypes.TowerCannon;
	}

	@Override
	public void update(float delta) {
		timeSinceLastShot += delta;
		
		if(!hasTarget || findDistance(target)  > towerType.range) {
			target = findTarget();
		} else {
			angle = calculateAngle();
			if(timeSinceLastShot > towerType.reloadTime) 
				shoot();
		}
		if(target != null && !target.isAlive()) {
			hasTarget = false;
		}
	}
	
	private Enemy findTarget() {
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
	
	private float findDistance(Enemy enemy) {
		float xDistance = Math.abs(enemy.getX() - x);
		float yDistance = Math.abs(enemy.getY() - y);
		return xDistance + yDistance;
	}
	
	private float calculateAngle() {
		double tempAngle = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(tempAngle) - 90;
	}
	
	private void shoot() {
		timeSinceLastShot = 0;
		BulletManager.addBullet(towerType.bullet, target, x, y);
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
