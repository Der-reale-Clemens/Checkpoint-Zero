package de.clemens_hartmann.checkpoint.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;
import de.clemens_hartmann.checkpoint.Disposable;
import de.clemens_hartmann.checkpoint.Drawable;
import de.clemens_hartmann.checkpoint.Updateable;
import de.clemens_hartmann.checkpoint.core.Player;
import de.clemens_hartmann.checkpoint.core.TowerManager;
import de.clemens_hartmann.checkpoint.core.TowerTypes;

public class Cursor implements  Disposable, Drawable{
	private final String PATH = "cursor.png";
	private final int WIDTH = Config.NUM_CELLS_WIDTH;
	private final int HEIGHT = Config.NUM_CELLS_HEIGTH;
	private final int TEX_SIZE = Config.TEX_SIZE;
	private final int OFFSET = 16;
	
	private int x;
	private int y;
	private Texture sprite;
	
	public Cursor(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = new Texture(Gdx.files.internal(PATH));
	}
	
	public void update() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
			if(x > 0)
				x--;
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
			if(x < WIDTH - 1)
				x++;
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
			if(y > 0)
				y--;
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
			if(y < HEIGHT - 1)
				y++;
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
			Player.addTower(x*TEX_SIZE, y*TEX_SIZE);//TowerManager.addTower(TowerTypes.TowerQuickfire, x, y);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1))
			Player.setSelectedTower(0);
		if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2))
			Player.setSelectedTower(1);
	}
	
	@Override
	public void draw(final Checkpoint game) {
		game.batch.begin();
		game.batch.draw(sprite, x*TEX_SIZE - OFFSET, y*TEX_SIZE - OFFSET);
		game.batch.end();
	}
	
	public Texture getTexture() {
		return sprite;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public void dispose() {
		sprite.dispose();
	}
}
