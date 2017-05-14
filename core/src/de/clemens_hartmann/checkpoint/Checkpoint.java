package de.clemens_hartmann.checkpoint;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Checkpoint extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	private GameScreen screen;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		//LiBGDX default arial font
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		this.getScreen().dispose();
	}
}
