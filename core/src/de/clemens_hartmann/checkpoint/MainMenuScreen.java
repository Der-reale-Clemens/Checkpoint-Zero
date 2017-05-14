package de.clemens_hartmann.checkpoint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class MainMenuScreen implements Screen {
	final Checkpoint game;
	
	//Texture background;
	OrthographicCamera camera;
	
	public MainMenuScreen(final Checkpoint game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		
		//background = new Texture(Gdx.files.internal("TitleScreen.png"));
	}

	@Override
	public void show() {
		//resize(960,640);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		/*game.batch.disableBlending();
		game.batch.begin();
		game.batch.draw(background, 0, 0);
		game.batch.end();
		
		game.batch.enableBlending();*/
		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Checkpoint: Zero!!!", 100, 150);
		game.font.draw(game.batch, "Tap Anywhere to begin", 100, 100);
		game.batch.end();
		
		if(Gdx.input.isTouched()){
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
		/*Vector2 size = Scaling.fit.apply(960, 571, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);*/
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		//background.dispose();
	}
}
