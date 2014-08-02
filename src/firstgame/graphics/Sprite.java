/**
 * 
 */
package firstgame.graphics;

/**
 * @author Markus
 *
 */
public class Sprite
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	public final int SIZE;
	private int x = 0, y = 0;
	public int[] pixels = null;
	private SpriteSheet sheet = null;
	private String name = "Sprite";

	public static Sprite voidSprite = new Sprite(16, 0x049BFF);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower1 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite flower2 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite treeEnd = new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite tree = new Sprite(32, 1, 1, SpriteSheet.tiles, "Tree");

	public static Sprite player_up = new Sprite(32, 1, 4, SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32, 1, 7, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 1, 6, SpriteSheet.tiles);

	public static Sprite move_forward1 = new Sprite(32, 0, 4, SpriteSheet.tiles);
	public static Sprite move_forward2 = new Sprite(32, 2, 4, SpriteSheet.tiles);
	public static Sprite move_left1 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite move_left2 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite move_right1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite move_right2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite move_back1 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite move_back2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	private Sprite(int size, int x, int y, SpriteSheet sheet)
	{
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	private Sprite(int size, int color)
	{
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);

	}

	public Sprite(int size, int x, int y, SpriteSheet sheet, String name)
	{
		this(size, x, y, sheet);
		this.name = name;

	}

	// ===========================================
	// ==============Methods======================
	// ===========================================
	private void setColor(int color)
	{
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = color;
		}
	}

	private void load()
	{
		for (int y = 0; y < SIZE; y++)
		{
			for (int x = 0; x < SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];
			}
		}
	}

	@Override
	public String toString()
	{
		return name;
	}
	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

}
