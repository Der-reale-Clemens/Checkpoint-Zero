package de.clemens_hartmann.checkpoint.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.clemens_hartmann.checkpoint.Checkpoint;
import de.clemens_hartmann.checkpoint.Config;

public class DesktopLauncher {
	
	private static final int HEIGTH = Config.HEIGHT;
	private static final int WIDTH = Config.WIDTH;
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Checkpoint: Zero";
		config.height = HEIGTH;
		config.width = WIDTH;
		new LwjglApplication(new Checkpoint(), config);
	}
}
