/**
 * 
 */
package firstgame.level;

import java.util.Random;

/**
 * @author Markus
 *
 */
public class RandomLevel extends Level
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	private static final Random random = new Random();

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	/**
	 * @param width
	 * @param height
	 */
	public RandomLevel(int width, int height)
	{
		super(width, height);
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================

	@Override
	protected void generateLevel()
	{
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tileInt[x + y * width] = random.nextInt(4);
			}
		}
	}
	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

}
