package uet.oop.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public class SpriteSheet {

	public static SpriteSheet tiles;
	public static SpriteSheet captain;
	private String _path;
	public final int SIZE;
	public int[] _pixels;
	public BufferedImage image;



	public static SpriteSheet player = new SpriteSheet("/textures/player1.png", 128);
	public static SpriteSheet grass = new SpriteSheet("/textures/floor.png", 32);
	public static SpriteSheet wall = new SpriteSheet("/textures/stone.png", 32);
	public static SpriteSheet cay = new SpriteSheet("/textures/cay.png", 32);
	public static SpriteSheet grass_water = new SpriteSheet("/textures/floor_water.png", 32);
	public static SpriteSheet wall_water = new SpriteSheet("/textures/wall_water.png", 32);
	public static SpriteSheet cay_water = new SpriteSheet("/textures/cay_water.png", 32);
	public static SpriteSheet brick_water = new SpriteSheet("/textures/gift_box_water.png",32);
	public static SpriteSheet grass_xmas = new SpriteSheet("/textures/floor_xmas.png", 32);
	public static SpriteSheet wall_xmas = new SpriteSheet("/textures/wall_xmas.png", 32);
	public static SpriteSheet cay_xmas = new SpriteSheet("/textures/cay_xmas.png", 32);
	public static SpriteSheet brick_xmas = new SpriteSheet("/textures/gift_box_xmas.png",32);
	public static SpriteSheet grass_town = new SpriteSheet("/textures/floor_town.png", 32);
	public static SpriteSheet wall_town = new SpriteSheet("/textures/wall_town.png", 32);
	public static SpriteSheet cay_town = new SpriteSheet("/textures/cay_town.png", 32);
	public static SpriteSheet brick_town = new SpriteSheet("/textures/gift_box_town.png",32);
	public static SpriteSheet grass_land = new SpriteSheet("/textures/floor_land.png", 32);
	public static SpriteSheet wall_land = new SpriteSheet("/textures/wall_land.png", 32);
	public static SpriteSheet cay_land = new SpriteSheet("/textures/cay_land.png", 32);
	public static SpriteSheet brick_land = new SpriteSheet("/textures/gift_box_land.png",32);
	public static SpriteSheet bot = new SpriteSheet("/textures/bot.png", 128);
	public static SpriteSheet bom= new SpriteSheet("/textures/bom.png",96);
	public static SpriteSheet bombom= new SpriteSheet("/textures/bombom.png",128);
	public static SpriteSheet bomup= new SpriteSheet("/textures/bomup.png",32);
	public static SpriteSheet bomdown= new SpriteSheet("/textures/bomdown.png",32);
	public static SpriteSheet bomleft= new SpriteSheet("/textures/bomleft.png",32);
	public static SpriteSheet bomright= new SpriteSheet("/textures/bomright.png",32);
	public static SpriteSheet door = new SpriteSheet("/textures/door.png",32);
	public static SpriteSheet brick = new SpriteSheet("/textures/gift_box.png",32);
	public static SpriteSheet doorclose = new SpriteSheet("/textures/doorclosed.png", 32);
	public static SpriteSheet speedup = new SpriteSheet("/textures/speedup.png", 32);
	public static SpriteSheet bomplus = new SpriteSheet("/textures/bomplus.png", 32);
	public static SpriteSheet bombig = new SpriteSheet("/textures/bombig.png", 32);



	public SpriteSheet(String path, int size) {
		_path = path;
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load() {
		try {
			URL a = SpriteSheet.class.getResource(_path);
			image = ImageIO.read(a);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, _pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
