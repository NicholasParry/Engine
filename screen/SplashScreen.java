package engine.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import engine.rendering.DisplayObject;

public class SplashScreen extends GameScreen {
	
	/**
	 * A simple SplashScreen, will display a texture for 5 seconds before moving to the next scene
	 * Currently does not transition
	 * 
	 * @param _game Main game class
	 * @param _texture Texture to display
	 */
	public SplashScreen(Game _game, Texture _texture){
		super(_game);
		System.out.println(_texture);
		addDisplayObject(new DisplayObject(_texture,new Vector2(0,0), getVieportSize()));
	}
	
	/**
	 * A simple SplashScreen, will display an image for a set amount of time before moving to the next scene
	 * Currently does not transition
	 * 
	 * 
	 * @param _game Main game class
	 * @param _texture Texture to display
	 * @param _displayTime Time in milliseconds to display for
	 */
	public SplashScreen(Game _game, Texture _texture, int _displayTime){
		super(_game);
		System.out.println(_texture);
		addDisplayObject(new DisplayObject(_texture,new Vector2(0,0), getVieportSize()));
	}
	
}
