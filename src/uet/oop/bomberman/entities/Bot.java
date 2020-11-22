package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bot extends Entity{

    public Bot(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }
    

    @Override
    public void update() {
        if(x<(BombermanGame.WIDTH-2)*Sprite.SCALED_SIZE ) {
            x = x + 1;
            if(x%32==0){
                img = Sprite.bot_right1.getFxImage();
            } else if(x%32==8){
                img = Sprite.bot_right2.getFxImage();
            } else if(x%32==16){
                img = Sprite.bot_right3.getFxImage();
            } else if(x%32==24){
                img = Sprite.bot_right4.getFxImage();
            }
        }


    }



}
