package engine.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Used for drawing an object on the UI layer
 * currently unimplemented
 * 
 * @author nick
 *
 */
public class UIObject extends DisplayObject {

	public UIObject(Texture _tex) {
		super(_tex);
		// TODO Auto-generated constructor stub
	}

	public UIObject(Texture _tex, Vector2 _location) {
		super(_tex, _location);
		// TODO Auto-generated constructor stub
	}

	public UIObject(Texture _tex, Vector2 _location, Vector2 _size) {
		super(_tex, _location, _size);
		// TODO Auto-generated constructor stub
	}

	public UIObject(Texture _tex, Vector2 _location, int _width, int _height) {
		super(_tex, _location, _width, _height);
		// TODO Auto-generated constructor stub
	}
	
	public UIObject(Texture _tex, Vector2 _location, Vector2 _size, Boolean asPercentage) {
		super(_tex, _location, _size);
		// TODO Auto-generated constructor stub
	}

	public UIObject(Texture _tex, Vector2 _location, int _width, int _height, Boolean asPercentage ) {
		super(_tex, _location, _width, _height);
		// TODO Auto-generated constructor stub
	}
}
