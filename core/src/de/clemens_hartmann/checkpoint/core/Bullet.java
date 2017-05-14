package de.clemens_hartmann.checkpoint.core;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;

public class Bullet implements Updateable, Drawable, Disposable {
	private final int TEX_SIZE = Config.BULLET_SIZE;
	
	private BulletTypes bulletType;
	private Texture sprite;
	private float x;
	private float y;
	private Vector2 direction;
	private Enemy target;
	private Circle hitbox;
	private boolean isAlive = true;
	
	public Bullet(BulletTypes bulletType, Enemy target, float x, float y) {
		this.bulletType = bulletType;
		this.target = target;
		this.x = x + TEX_SIZE/2;
		this.y = y + TEX_SIZE/2;
		direction = new Vector2();
		sprite = new Texture(Gdx.files.internal(bulletType.textureName));
		calculateDirection();
		hitbox = new Circle(this.x,this.y,TEX_SIZE/2);
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
				enemy.damage((int)bulletType.damage);
				isAlive = false;
				return;
			}
		}
		hitbox.setPosition(x, y);
	}
	
	private void calculateDirection() {
		//xDistance / totalDistance
		float xMovement = Math.abs(target.getX() - x) / (Math.abs(target.getX() - x) + Math.abs(target.getY() - y));
		direction.x = xMovement;
		direction.y = 1.0f - xMovement;
		if(target.getX() < x)
			direction.x *= -1;
		if(target.getY() < y)
			direction.y *= -1;
	}

	@Override
	public void draw(Checkpoint game) {
		game.batch.draw(sprite, x, y, TEX_SIZE, TEX_SIZE);
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public Texture getTexture() {
		return sprite;
	}
		
	@Override
	public void dispose() {
		sprite.dispose();
	}
}
