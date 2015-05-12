package engine.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Interface for making an object drawable
 * @author nick
 *
 */
public interface I_Drawable {
	
	/**
	 * Returns the texture of an object
	 * 
	 * @return Texture of the object
	 */
	public Texture getTexture();
	
	/**
	 * Returns the location of the object as a vector
	 * 
	 * @return Vector2 of the objects location
	 */
	public Vector2 getLocation();
}
