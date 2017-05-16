package de.clemens_hartmann.checkpoint.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.clemens_hartmann.checkpoint.Checkpoint;

public class BulletManager {
	private static List<Bullet> bullets = new LinkedList<Bullet>();
	
	public void update(float delta) {
		Iterator<Bullet> iter = bullets.iterator();
		while(iter.hasNext()) {
			Bullet bullet = iter.next();
			bullet.update(delta);
			if(!bullet.isAlive()) {
				bullet.dispose();
				iter.remove();
			}
		}
	}
	
	public static void addBullet(BulletTypes bulletType, Enemy target, float x, float y) {
		bullets.add(new BulletNormal(bulletType, target, x, y));
	}
	
	public void draw(final Checkpoint game) {
		game.batch.begin();
		for(Bullet bullet : bullets) {
			bullet.draw(game);
		}
		game.batch.end();
	}
	
	public void dispose() {
		for(Bullet bullet : bullets) {
			bullet.dispose();
		}
		bullets.clear();
	}
}
