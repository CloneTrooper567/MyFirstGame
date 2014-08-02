/**
 * 
 */
package firstgame.entity.mod;

import firstgame.entity.Entity;
import firstgame.graphics.Sprite;

/**
 * @author Markus
 *
 */
public abstract class Mob extends Entity
{

	//===========================================
	//==============Instance-Variables===========
	//===========================================
	protected Sprite sprite = null;
	protected int dir = 2; //Direction
	protected boolean moving = false;

	//===========================================
	//==============Constructor(s)===============
	//===========================================

	//===========================================
	//==============Methods======================
	//===========================================
	public void move(int xa, int ya)
	{
		//Directions:
		//			0
		//	3	  Player     1
		//			2
		if (xa > 0)
		{
			dir = 1;
		}
		if (xa < 0)
		{
			dir = 3;
		}
		if (ya > 0)
		{
			dir = 2;
		}
		if (ya < 0)
		{
			dir = 0;
		}
		if (!collision())
		{
			x += xa;
			y += ya;
		}
	}

	@Override
	public void update()
	{

	}

	public void render()
	{

	}

	private boolean collision()
	{
		return false;
	}
	//===========================================
	//==============Getter/Setter================
	//===========================================

}
