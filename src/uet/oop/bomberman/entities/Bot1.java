package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bot1 extends Bot2{
    public Bot1(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if(a==1&&checkup()) {
            moveup();
        } else if(a==1) {
            if(BombermanGame.player.get(0).getY()>getY()) {
                if (checkdown()) a = 3;
            } else if(BombermanGame.player.get(0).getX()<getX()){
                if(checkleft()) a=4;
            } else if(BombermanGame.player.get(0).getX()>getX()){
                if(checkright()) a=2;
            }
        }
        if(a==2&&checkright()) {
            moveright();
        } else if(a==2){
            if(BombermanGame.player.get(0).getX()<getX()){
                if(checkleft()) a=4;
            }else if(BombermanGame.player.get(0).getY()<getY()){
                if(checkup()) a=1;
            } else if(BombermanGame.player.get(0).getY()>getY()) {
                if (checkdown()) a = 3;
            }
        }
        if(a==3&&checkdown()) {
            movedown();
        } else if(a==3){
            if(BombermanGame.player.get(0).getY()<getY()) {
                if (checkup()) a = 1;
            }else if(BombermanGame.player.get(0).getX()<getX()){
                if(checkleft()) a=4;
            } else if(BombermanGame.player.get(0).getX()>getX()){
                if(checkright()) a=2;
            }
        }

        if(a==4&&checkleft()) {
            moveleft();
        } else if(a==4){
            if(BombermanGame.player.get(0).getX()>getX()){
                if(checkright()) a=2;
            } else if(BombermanGame.player.get(0).getY()<getY()){
                if(checkup()) a=1;
            } else  if(BombermanGame.player.get(0).getY()>getY()) {
                if (checkdown()) a = 3;
            }
        }
    }
}
