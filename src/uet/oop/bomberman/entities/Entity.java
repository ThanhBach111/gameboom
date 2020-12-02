package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    MediaPlayer mediaPlayer;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Image getImg() {
        return img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();

    public void musicforBomb() {
        String path = "res/music/explode.wav";

        Media media = new Media(new File(path).toURI().toString());

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setAutoPlay(true);
    }

    public void soundstep() {
        String path = "res/music/footstep.mp3";

        Media media = new Media(new File(path).toURI().toString());

        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setAutoPlay(true);
    }


}
