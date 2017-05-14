package de.clemens_hartmann.checkpoint;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

import de.clemens_hartmann.checkpoint.core.BulletManager;
import de.clemens_hartmann.checkpoint.core.Enemy;
import de.clemens_hartmann.checkpoint.core.EnemyManager;
import de.clemens_hartmann.checkpoint.core.Map;
import de.clemens_hartmann.checkpoint.core.Maps;
import de.clemens_hartmann.checkpoint.core.TowerCannon;
import de.clemens_hartmann.checkpoint.core.TowerManager;
import de.clemens_hartmann.checkpoint.core.TowerTypes;
import de.clemens_hartmann.checkpoint.core.WaveManager;
import de.clemens_hartmann.checkpoint.ui.Cursor;

public class GameScreen implements Screen {
	final Checkpoint game;
	final int WIDTH = Config.WIDTH;
	final int HEIGHT = Config.HEIGHT;
	final int TEX_SIZE = Config.TEX_SIZE;
	
	private OrthographicCamera camera;
	private Cursor cursor;
	
	private WaveManager waveManager;
	private BulletManager bulletManager;
	private EnemyManager enemyManager;
	private TowerManager towerManager;
	
	//private TowerCannon tower;
	
	public GameScreen(final Checkpoint game) {
		this.game = game;
		game.setScreen(this);
		
		//create the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(true, WIDTH, HEIGHT);
		
		//load DebugMap
		Map.createMap(Maps.MAP1);
		//create Cursor
		cursor = new Cursor(0,0);
		
		//create Managers
		waveManager = new WaveManager();
		bulletManager = new BulletManager();
		enemyManager = new EnemyManager();
		towerManager = new TowerManager();
		
		
		TowerManager.addTower(TowerTypes.TowerCannon, 4,6);
	}

	@Override
	public void render(float delta) {
		//Setup of OpenGL
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//update camera
		camera.update();
		//set batch coordinates based on camera Matrix
		game.batch.setProjectionMatrix(camera.combined);
		
		//first render map
		Map.draw(game);
		//draw Enemys
		enemyManager.draw(game);
		//draw Towers
		towerManager.draw(game);
		//draw Bullets;
		bulletManager.draw(game);
		//draw Cursor
		cursor.draw(game);
		
		
		update(delta);
		controls();
	}
	
	public void update(float delta) {
		waveManager.update(delta * 1000);
		enemyManager.update(delta * 1000);
		bulletManager.update(delta * 1000);
		towerManager.update(delta * 1000);
	}
	
	public void controls() {
		cursor.update();
	}
	
	@Override
	public void show() {
		this.resize(960,640);
	}
	@Override
	public void resize(int width, int height) {
		Vector2 size = Scaling.fit.apply(800, 600, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
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
		Map.dispose();
		cursor.dispose();
		enemyManager.dispose();
		bulletManager.dispose();
		towerManager.dispose();
	}
}
