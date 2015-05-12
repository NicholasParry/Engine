package engine.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import engine.rendering.DisplayObject;
import engine.rendering.UIObject;

/**
 * An expanded implementation of LibGDX's screen class with extra features.
 * Alot of this is currently hard coded for my current project
 * @author nick
 *
 */
public class GameScreen implements Screen{

	private Game game;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private OrthographicCamera uiCamera;
	private Viewport view;
	private Viewport uiView;
	
	
	private ArrayList<DisplayObject> displayObjects; //For drawing background / no UI stuff
	private ArrayList<UIObject> uiObjects; //For drawing top level UI stuff, will be above everything else
	
	/**
	 * An expanded implementation of LibGDX's screen class with extra features.
	 * Alot of this is currently hard coded for my current project
	 * 
	 * @param _game Main game class
	 */
	public GameScreen(Game _game){
		game = _game;
		game.getScreen();
		//game.notify();
		
		//set up renderer
		displayObjects = new ArrayList<DisplayObject>();
		uiObjects = new ArrayList<UIObject>();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		uiCamera = new OrthographicCamera();
		view = new FitViewport(1000, 1000, camera);
		uiView = new ScreenViewport();
		//view.apply();
	}
	
	/**
	 * Gets the current viewport size as a Vector2
	 * @return Vector2 viewport size.
	 */
	public Vector2 getVieportSize(){
		return new Vector2(view.getWorldWidth(),view.getWorldHeight());
	}
	
	/**
	 * Adds an object to be drawn behind the ui
	 * @param _objectToAdd DisplayObject to add
	 */
	public void addDisplayObject(DisplayObject _objectToAdd){
		displayObjects.add(_objectToAdd);
	}
	
	/**
	 * Adds an object to be drawn At UI level
	 * @param _objectToAdd DisplayObject to add
	 */
	public void addUIObject(UIObject _objectToAdd){
		uiObjects.add(_objectToAdd);
	}
	
	/**
	 * Sets the viewport size
	 * @param _width viewport width
	 * @param _height viewport height
	 */
	public void setViewportSize(int _width, int _height){
		//view.setScreenSize(_width, _height);
		view.setWorldSize(_width, _height);
	}
	
	

	@Override
	public void show() {
		//
		
	}

	/**
	 * Called by LibGDX for rendering. 
	 */
	@Override
	public void render(float delta) {
		camera.update();
		
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//bg render
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		view.apply();
		//System.out.println(displayObjects.get(0).getLocation() + "\n" + displayObjects.get(0).getLocation() + "\n\n");
		for(int i = 0; i < displayObjects.size(); i++){
			DisplayObject obj = displayObjects.get(i);
			batch.draw(obj.getTexture(),obj.getLocation().x,obj.getLocation().x, obj.getSize().x, obj.getSize().y);
		}
		//batch.end();
		
		//ui render
		camera.update();
		
		Gdx.gl.glClearColor(0,1,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(uiCamera.combined);
		//batch.begin();
		uiView.apply();
		for(int i = 0; i < uiObjects.size(); i++){
			UIObject obj = uiObjects.get(i);
			batch.draw(obj.getTexture(),obj.getLocation().x,obj.getLocation().x, obj.getSize().x, obj.getSize().y);
		}
		batch.end();
		
	}

	/**
	 * Changes the views size
	 */
	@Override
	public void resize(int _width, int _height) {
		view.update(_width, _height);
		camera.position.set(camera.viewportWidth /2, camera.viewportHeight / 2, 0);
		
		//todo(update actors
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
		// TODO Auto-generated method stub

	}
	
	

	
	

}
