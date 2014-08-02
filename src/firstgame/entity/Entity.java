/**
 * 
 */
package firstgame.entity;

import java.util.Random;

import firstgame.graphics.Screen;
import firstgame.level.Level;

/**
 * @author Markus
 *
 */
public abstract class Entity
{

	//===========================================
	//==============Instance-Variables===========
	//===========================================
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	//===========================================
	//==============Constructor(s)===============
	//===========================================

	//===========================================
	//==============Methods======================
	//===========================================
	public void update()
	{

	}

	public void render(Screen screen)
	{

	}

	public void remove()
	{
		//Removed from Level
		removed = true;
	}

	//===========================================
	//==============Getter/Setter================
	//===========================================
	public boolean isRemoved()
	{
		return removed;
	}

}
