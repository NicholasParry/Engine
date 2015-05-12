package engine.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import engine.rendering.I_Drawable;

/**
 * Used for any object which will be displayed on screen, make sure it has all functions needed to be rendered.
 * @author Nick
 *
 */
public class DisplayObject implements I_Drawable {
	
	private Texture texture;
	private Vector2 location;
	private Vector2 size;
	
	/**
	 * Constructor for DrawableObjects that only provide a texture, 
	 * Location will be set at 0,0
	 * Size will be set to the size of the texture
	 * 
	 * @param _tex texture to be rendered
	 */
	public DisplayObject(Texture _tex){
		texture = _tex;
		location = new Vector2(0,0);
		size = new Vector2(texture.getWidth(),texture.getHeight());
	}
	
	/**
	 * Constructor for DrawableObject that provides a texture and location
	 * Size will be set to the size of the texture
	 * @param _tex texture to be rendered
	 * @param _location location for the image to be rendered at
	 */
	public DisplayObject(Texture _tex, Vector2 _location){
		texture = _tex;
		location = _location;
		size = new Vector2(texture.getWidth(),texture.getHeight());
	}
	
	/**
	 * Constructor for DisplayObject that provides texture, Vector2 location and Vector2 size
	 * @param _tex texture to be rendered
	 * @param _location location for the image to be rendered 
	 * @param _size Vector2 size for the image to be rendered at in game units
	 */
	public DisplayObject(Texture _tex, Vector2 _location, Vector2 _size){
		texture = _tex;
		location = _location;
		size = _size;
	}
	
	/**
	 * Constructor for display object which provides texture, Vector2 location and Int,Int size
	 * @param _tex texture to be rendered
	 * @param _location vector 2 location to be rendered at
	 * @param _width int width in game units
	 * @param _height int height in game units
	 */
	public DisplayObject(Texture _tex, Vector2 _location, int _width, int _height){
		texture = _tex;
		location = _location;
		size = new Vector2(_width, _height);
	}
	
	/**
	 * Manually set texture
	 * Can be used for crude animation.
	 * @param _tex new texture
	 */
	public void setTexture(Texture _tex){
		texture = _tex;
	}
	
	/**
	 * Manually change location using a Vector2
	 * @param _location new location
	 */
	public void setLocation(Vector2 _location){
		location = _location;
	}
	
	/**
	 * Manually change the location using an int,int values.
	 * @param _x int new x location
	 * @param _int new y location
	 */
	public void setLocation(int _x, int _y){
		size = new Vector2(_x, _y);
	}
	
	/**
	 * Returns size as a vector@
	 * @return Vector2 size
	 */
	public Vector2 getSize(){
		return size;
	}

	/**
	 * Returns the texture of an object
	 * 
	 * @return Texture of the object
	 */
	@Override
	public Texture getTexture() {
		return texture;
	}

	/**
	 * Returns the location of the object as a vector
	 * 
	 * @return Vector2 of the objects location
	 */
	@Override
	public Vector2 getLocation() {
		return location;
	}
	
	
	
	

}
