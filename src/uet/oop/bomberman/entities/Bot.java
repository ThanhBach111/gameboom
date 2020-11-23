package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bot extends Entity{
    public int a=1;
    public Bot(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }
    

    @Override
    public void update() {
        if(x<=(BombermanGame.WIDTH-2)*Sprite.SCALED_SIZE ) {
            if(a==1) {
                    x = x + 2;
                    if (x % 32 == 0) {
                        img = Sprite.bot_right1.getFxImage();
                    } else if (x % 32 == 8) {
                        img = Sprite.bot_right2.getFxImage();
                    } else if (x % 32 == 16) {
                        img = Sprite.bot_right3.getFxImage();
                    } else if (x % 32 == 24) {
                        img = Sprite.bot_right4.getFxImage();
                    }
            } else {
                    x=x-2;
                if (x % 32 == 0) {
                    img = Sprite.bot_left1.getFxImage();
                } else if (x % 32 == 8) {
                    img = Sprite.bot_left2.getFxImage();
                } else if (x % 32 == 16) {
                    img = Sprite.bot_left3.getFxImage();
                } else if (x % 32 == 24) {
                    img = Sprite.bot_left4.getFxImage();
                }
            }
            if(x>(BombermanGame.WIDTH-2)*Sprite.SCALED_SIZE-1) {
                a=0;
                img =Sprite.bot.getFxImage();
            } else if(x==64){
                a=1;
                img =Sprite.bot.getFxImage();
            }
        }
    }


}




