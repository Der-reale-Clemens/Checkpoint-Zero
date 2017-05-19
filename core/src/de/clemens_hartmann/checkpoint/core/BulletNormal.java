package de.clemens_hartmann.checkpoint.core;

import java.util.Iterator;

import de.clemens_hartmann.checkpoint.Config;

public class BulletNormal extends Bullet {

	public BulletNormal(BulletTypes bulletType, Enemy target, float x, float y) {
		super(bulletType, target, x, y);
	}

	@Override
	public void update(float delta) {
		x += direction.x * bulletType.speed * (delta/100);  
		y += direction.y * bulletType.speed * (delta/100);
		if(x > Config.WIDTH || x < 0 || y > Config.HEIGHT || y < 0)
			isAlive = false;
		Iterator<Enemy> iter = EnemyManager.getEnemys().iterator();
		while(iter.hasNext()) {
			Enemy enemy = iter.next();
			if(hitbox.overlaps(enemy.getHitbox())) {
				enemy.damage(bulletType.damage);
				isAlive = false;
				return;
			}
		}
		hitbox.setPosition(x, y);
	}

}
