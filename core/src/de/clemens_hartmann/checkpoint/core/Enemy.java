package de.clemens_hartmann.checkpoint.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;

public class Enemy implements Updateable, Disposable, Drawable {
	private final int TEX_SIZE = Config.TEX_SIZE;
	
	private EnemyTypes enemyType;
	private Texture sprite;
	private Circle hitbox;
	private Vector2 startPos;
	private float x;
	private float y;
	private int health;
	private int direction;
	private boolean isAlive = true;
	
	public Enemy(EnemyTypes enemyType, float x, float y) {
		this.enemyType = enemyType;
		sprite = new Texture(Gdx.files.internal(enemyType.textureName));
		health = enemyType.health;
		startPos = new Vector2(x,y);
		this.x = x;
		this.y = y;
		hitbox = new Circle(this.x,this.y,TEX_SIZE);
	}
	
	@Override
	public void update(float delta) {
		if(health <= 0)
			isAlive = false;
		
		try {
		direction = findDirection();

		switch(direction) {
		case 0:
			x += enemyType.speed * (delta/100);
			break;
		case 1:
			x -= enemyType.speed * (delta/100);
			break;
		case 2:
			y += enemyType.speed * (delta/100);
			break;
		case 3:
			y -= enemyType.speed * (delta/100);
			break;		
		}
		}
		catch(Exception e) {
			isAlive = false;
		}
		hitbox.setPosition(x, y);
	}

	public void damage(int damage) {
		health -= damage;
	}
	
	private int findDirection() {
		if(pathContinues(direction))
			return direction;
		switch(direction) {
		case 0: //RIGTH
			if (pathContinues(2))
				return 2;
			else if (pathContinues(3))
				return 3;
			break;
		case 1: //LEFT
			if (pathContinues(2))
				return 2;
			else if (pathContinues(3))
				return 3;
			break;
		case 2: //DOWN
			if (pathContinues(0))
				return 0;
			else if (pathContinues(1))
				return 1;
			break;
		case 3: //UP
			if (pathContinues(0))
				return 0;
			else if (pathContinues(1))
				return 1;
			break;
		}
		return -1;
	}
	
	private boolean pathContinues(int direction) {
		Tile nextTile = null;
		
		switch(direction) {
		case 0: //RIGTH
			nextTile = Map.getTile((int) (x/Config.TEX_SIZE + 1),(int) (y/Config.TEX_SIZE));
			break;
		case 1: //LEFT
			nextTile = Map.getTile((int) (x/Config.TEX_SIZE - (enemyType.speed * 0.005)),(int) (y/Config.TEX_SIZE));
			break;
		case 2: //DOWN
			nextTile = Map.getTile((int) (x/Config.TEX_SIZE),(int) (y/Config.TEX_SIZE + 1));
			break;
		case 3: //UP
			nextTile = Map.getTile((int) (x/Config.TEX_SIZE),(int) (y/Config.TEX_SIZE - (enemyType.speed * 0.005)));
			break;
		}
		if(!nextTile.getTileType().walkable)
			return false;
		return true;
	}
	
	@Override
	public void draw(Checkpoint game) {
		game.batch.draw(sprite, x, y);
	}
	
	public Texture getTexture() {
		return sprite;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public Circle getHitbox() {
		return hitbox;
	}
	public boolean isAlive() {
		return isAlive;
	}
	
	@Override
	public void dispose() {
		sprite.dispose();
	}

}
