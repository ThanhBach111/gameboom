package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {
        x=64;
        y=64;
        img=Sprite.player.getFxImage();
    }

    public void moveup(){

        if(x%64<=8) {
            y--;
            x = x / 64 * 64;
        }else if(x%64>=56) {
            y--;
            x = (x / 64 +1 )* 64;
        }
        if (y % 16 == 0) {
            img = Sprite.player_up1.getFxImage();
        } else if (y % 16 == 4) {
            img = Sprite.player_up2.getFxImage();
        } else if (y % 16 == 8) {
            img = Sprite.player_up3.getFxImage();
        } else if (y % 16 == 12) {
            img = Sprite.player_up4.getFxImage();
        }
    }
    public void movedown(){

        if(x%64<=8) {
            y++;
            x = x / 64 * 64;
        }else if(x%64>=56) {
            y++;
            x = (x / 64 +1 )* 64;
        }
        if (y % 16 == 0) {
            img = Sprite.player_down1.getFxImage();
        } else if (y % 16 == 4) {
            img = Sprite.player_down2.getFxImage();
        } else if (y % 16 == 8) {
            img = Sprite.player_down3.getFxImage();
        } else if (y % 16 == 12) {
            img = Sprite.player_down4.getFxImage();
        }
    }
    public void moveleft(){

        if(y%64<=8) {
            x--;
            y= y / 64 * 64;
        }else if(x%64>=56) {
            x--;
            y = (y / 64 +1 )* 64;
        }
        if (x % 16 == 0) {
            img = Sprite.player_left1.getFxImage();
        } else if (x % 16 == 4) {
            img = Sprite.player_left2.getFxImage();
        } else if (x % 16 == 8) {
            img = Sprite.player_left3.getFxImage();
        } else if (x % 16 == 12) {
            img = Sprite.player_left4.getFxImage();
        }
    }
    public void moveright(){
        if(y%64<=8) {
            x++;
            y= y / 64 * 64;
        }else if(x%64>=56) {
            x++;
            y = (y / 64 +1 )* 64;
        }
        if (x % 16 == 0) {
            img = Sprite.player_right1.getFxImage();
        } else if (x % 16 == 4) {
            img = Sprite.player_right2.getFxImage();
        } else if (x % 16 == 8) {
            img = Sprite.player_right3.getFxImage();
        } else if (x % 16 == 12) {
            img = Sprite.player_right4.getFxImage();
        }
    }
}
