package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bot2 extends Entity{
    int a=1;
    public Bot2(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

        if(a==1&&checkup()) {
            moveup();
        } else if(a==1) {
            img=Sprite.bot_right1.getFxImage();
            a=2;

        }
        if(a==2&&checkright()) {
            moveright();
        } else if(a==2){
            img=Sprite.bot_down1.getFxImage();
            a=3;
        }
        if(a==3&&checkdown()) {
            movedown();
        } else if(a==3){
            img=Sprite.bot_left1.getFxImage();
            a=4;
        }
        if(a==4&&checkleft()) {
            moveleft();
        } else if(a==4){
            img=Sprite.bot_up1.getFxImage();
            a=1;
        }

    }
    public void moveup(){

        y=y-2;
        if (y % 16 == 0) {
            img = Sprite.bot_up1.getFxImage();
        } else if (y % 16 == 4) {
            img = Sprite.bot_up2.getFxImage();
        } else if (y % 16 == 8) {
            img = Sprite.bot_up3.getFxImage();
        } else if (y % 16 == 12) {
            img = Sprite.bot_up4.getFxImage();
        }
    }
    public void movedown(){

        y=y+2;
        if (y % 16 == 0) {
            img = Sprite.bot_down1.getFxImage();
        } else if (y % 16 == 4) {
            img = Sprite.bot_down2.getFxImage();
        } else if (y % 16 == 8) {
            img = Sprite.bot_down3.getFxImage();
        } else if (y % 16 == 12) {
            img = Sprite.bot_down4.getFxImage();
        }
    }
    public void moveleft(){

        x=x-2;
        if (x % 16 == 0) {
            img = Sprite.bot_left1.getFxImage();
        } else if (x % 16 == 4) {
            img = Sprite.bot_left2.getFxImage();
        } else if (x % 16 == 8) {
            img = Sprite.bot_left3.getFxImage();
        } else if (x % 16 == 12) {
            img = Sprite.bot_left4.getFxImage();
        }
    }
    public void moveright(){
        x=x+2;
        if (x % 16 == 0) {
            img = Sprite.bot_right1.getFxImage();
        } else if (x % 16 == 4) {
            img = Sprite.bot_right2.getFxImage();
        } else if (x % 16 == 8) {
            img = Sprite.bot_right3.getFxImage();
        } else if (x % 16 == 12) {
            img = Sprite.bot_right4.getFxImage();
        }
    }
    public boolean checkup(){
        for (Entity stillObject : BombermanGame.stillObjects) {
            if (stillObject.getY() +64== getY()  && stillObject.getX() == getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.bricks) {
            if (stillObject.getY() +64== getY()  && stillObject.getX() == getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.boms) {
            if (stillObject.getY() +64 == getY() && stillObject.getX() == getX())

                return false;
        }
        for (Entity stillObject : BombermanGame.explodes) {
            if (stillObject.getY() +64 == getY() && stillObject.getX() == getX())

            return false;
        }
        return true;
    }
    public boolean checkdown(){
        for (Entity stillObject : BombermanGame.stillObjects) {
            if (stillObject.getY() -64 == getY() && stillObject.getX() == getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.bricks) {
            if (stillObject.getY() -64 == getY() && stillObject.getX() == getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.boms) {
            if (stillObject.getY() -64 == getY() && stillObject.getX() == getX())

                return false;
        }
        for (Entity stillObject : BombermanGame.explodes) {
            if (stillObject.getY() -64 == getY() && stillObject.getX() == getX())

            return false;
        }
        return true;
    }
    public boolean checkleft(){
        for (Entity stillObject : BombermanGame.stillObjects) {
            if (stillObject.getY() == getY() && stillObject.getX() +64== getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.bricks) {
            if (stillObject.getY() == getY() && stillObject.getX() +64== getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.boms) {
            if (stillObject.getY() == getY() && stillObject.getX() +64== getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.explodes) {
            if (stillObject.getY() == getY() && stillObject.getX() +64== getX())
                return false;
        }
        return true;
    }
    public boolean checkright(){
        for (Entity stillObject : BombermanGame.stillObjects) {
            if (stillObject.getY()  == getY() && stillObject.getX()  - 64== getX() )
                return false;
        }
        for (Entity stillObject : BombermanGame.bricks) {
            if (stillObject.getY()  == getY() && stillObject.getX()  - 64== getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.boms) {
            if (stillObject.getY()  == getY() && stillObject.getX()  - 64== getX())
                return false;
        }
        for (Entity stillObject : BombermanGame.explodes) {
            if (stillObject.getY()  == getY() && stillObject.getX()  - 64== getX())
                return false;
        }
        return true;
    }
}
