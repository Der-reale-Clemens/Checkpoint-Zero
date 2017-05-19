package de.clemens_hartmann.checkpoint.core;

import java.util.Iterator;
import java.util.List;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;

public class BulletArtillery extends Bullet {

	public BulletArtillery(BulletTypes bulletType, Enemy target, float x, float y) {
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
				List<Enemy> enemysInRange = EnemyManager.findEnemys(x, y, bulletType.explosionRange);
				Iterator<Enemy> inRange = enemysInRange.iterator();
				while(inRange.hasNext()) {
					Enemy e = inRange.next();
					System.out.println(e.getX());
					e.damage(bulletType.damage);
				}
				isAlive = false;
				return;
			}
		}
		hitbox.setPosition(x, y);
	}
	
	/*@Override
	public void draw(final Checkpoint game) {
		game.batch.draw(texture, x, y, width, height, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
	}*/
}
