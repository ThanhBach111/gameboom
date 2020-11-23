package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }

    public void moveup(){
        y--;
    }
    public void movedown(){
        y++;
    }
    public void moveleft(){
        x--;
    }
    public void moveright(){
        x++;
    }
}
