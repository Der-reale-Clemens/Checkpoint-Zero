package de.clemens_hartmann.checkpoint.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;

public abstract class Bullet implements Updateable, Drawable, Disposable{
	private final int TEX_SIZE = Config.BULLET_SIZE;
	
	protected BulletTypes bulletType;
	private Texture sprite;
	protected float x;
	protected float y;
	protected Vector2 direction;
	private Enemy target;
	protected Circle hitbox;
	protected boolean isAlive = true;
	
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
	
	public abstract void update(float delta);
	
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
	
	public boolean isAlive() {
		return isAlive;
	}
	
	@Override
	public void draw(final Checkpoint game) {
		game.batch.draw(sprite, x, y, TEX_SIZE, TEX_SIZE);
	}
	
	@Override
	public void dispose() {
		sprite.dispose();
	}
}
