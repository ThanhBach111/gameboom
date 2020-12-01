package uet.oop.bomberman.graphics;

import javafx.scene.image.*;

import javax.swing.*;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {
	
	public static final int DEFAULT_SIZE = 32;
	public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
	public final int SIZE;
	private int _x, _y;
	public int[] _pixels;
	protected int _realWidth;
	protected int _realHeight;
	private SpriteSheet _sheet;


	public static Sprite wall = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.wall, 0,0);
	public static Sprite grass = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.grass, 0,0);
	public static Sprite cay = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.cay, 0,0);
	public static Sprite wall_water = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.wall_water, 0,0);
	public static Sprite grass_water = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.grass_water, 0,0);
	public static Sprite cay_water = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.cay_water, 0,0);
	public static Sprite wall_xmas = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.wall_xmas, 0,0);
	public static Sprite grass_xmas = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.grass_xmas, 0,0);
	public static Sprite cay_xmas = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.cay_xmas, 0,0);
	public static Sprite wall_town = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.wall_town, 0,0);
	public static Sprite grass_town = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.grass_town, 0,0);
	public static Sprite cay_town = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.cay_town, 0,0);
	public static Sprite wall_land = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.wall_land, 0,0);
	public static Sprite grass_land = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.grass_land, 0,0);
	public static Sprite cay_land = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.cay_land, 0,0);


	public static Sprite door= new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.door,0,0);
	public static Sprite doorclose = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.doorclose, 0,0);


	public static Sprite brick = new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.brick,0,0);
	public static Sprite brick_water = new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.brick_water,0,0);
	public static Sprite brick_xmas = new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.brick_xmas,0,0);
	public static Sprite brick_town = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.brick_town, 0,0);
	public static Sprite brick_land = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.brick_land, 0,0);

	public static Sprite bom=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bom,0,0);
	public static Sprite bom1=new Sprite(DEFAULT_SIZE,1,0,SpriteSheet.bom,1,0);
	public static Sprite bom2=new Sprite(DEFAULT_SIZE,2,0,SpriteSheet.bom,2,0);
	public static Sprite bombom=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bombom,0,0);
	public static Sprite bomup=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bomup,0,0);
	public static Sprite bomdown=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bomdown,0,0);
	public static Sprite bomleft=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bomleft,0,0);
	public static Sprite bomright=new Sprite(DEFAULT_SIZE,0,0,SpriteSheet.bomright,0,0);

	public static Sprite bot = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.bot, 0,0);
	public static Sprite bot_right1 = new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.bot, 0,0);
	public static Sprite bot_right2= new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.bot, 0,0);
	public static Sprite bot_right3 = new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.bot, 0,0);
	public static Sprite bot_right4 = new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.bot, 0,0);
	public static Sprite bot_left1 = new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.bot, 0,0);
	public static Sprite bot_left2= new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.bot, 0,0);
	public static Sprite bot_left3 = new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.bot, 0,0);
	public static Sprite bot_left4 = new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.bot, 0,0);
	public static Sprite bot_down1 = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.bot, 0,0);
	public static Sprite bot_down2 = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.bot, 0,0);
	public static Sprite bot_down3 = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.bot, 0,0);
	public static Sprite bot_down4 = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.bot, 0,0);
	public static Sprite bot_up1 = new Sprite(DEFAULT_SIZE, 0, 3, SpriteSheet.bot, 0,0);
	public static Sprite bot_up2 = new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.bot, 0,0);
	public static Sprite bot_up3 = new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.bot, 0,0);
	public static Sprite bot_up4 = new Sprite(DEFAULT_SIZE, 3, 3, SpriteSheet.bot, 0,0);



	public static Sprite player = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.player, 0,0);
	public static Sprite player_down1 = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.player, 0,0);
	public static Sprite player_down2 = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.player, 0,0);
	public static Sprite player_down3 = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.player, 0,0);
	public static Sprite player_down4 = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.player, 0,0);
	public static Sprite player_up1 = new Sprite(DEFAULT_SIZE, 0, 3, SpriteSheet.player, 0,0);
	public static Sprite player_up2 = new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.player, 0,0);
	public static Sprite player_up3 = new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.player, 0,0);
	public static Sprite player_up4 = new Sprite(DEFAULT_SIZE, 3, 3, SpriteSheet.player, 0,0);
	public static Sprite player_left1 = new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.player, 0,0);
	public static Sprite player_left2 = new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.player, 0,0);
	public static Sprite player_left3 = new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.player, 0,0);
	public static Sprite player_left4 = new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.player, 0,0);
	public static Sprite player_right1 = new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.player, 0,0);
	public static Sprite player_right2 = new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.player, 0,0);
	public static Sprite player_right3 = new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.player, 0,0);
	public static Sprite player_right4 = new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.player, 0,0);

	public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		_x = x * SIZE;
		_y = y * SIZE;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < _pixels.length; i++) {
			_pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				_pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
			}
		}
	}
	
	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
		int calc = animate % time;
		int diff = time / 3;
		
		if(calc < diff) {
			return normal;
		}
			
		if(calc < diff * 2) {
			return x1;
		}
			
		return x2;
	}
	
	public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
		int diff = time / 2;
		return (animate % time > diff) ? x1 : x2; 
	}
	
	public int getSize() {
		return SIZE;
	}

	public int getPixel(int i) {
		return _pixels[i];
	}

	public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE,SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if ( _pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                }
                else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input, 2);
    }

	private Image resample(Image input, int scaleFactor) {
		final int W = (int) input.getWidth();
		final int H = (int) input.getHeight();
		final int S = scaleFactor;

		WritableImage output = new WritableImage(
				W * S,
				H * S
		);

		PixelReader reader = input.getPixelReader();
		PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				final int argb = reader.getArgb(x, y);
				for (int dy = 0; dy < S; dy++) {
					for (int dx = 0; dx < S; dx++) {
						writer.setArgb(x * S + dx, y * S + dy, argb);
					}
				}
			}
		}

		return output;
	}
}
