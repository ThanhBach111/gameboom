package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bom extends Entity{
    int a=800;

    public Bom(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        a = a - 2;
        if (a > 100) {
            if (a % 60 == 0) {
                img = Sprite.bom.getFxImage();
            } else if (a % 60 == 45) {
                img = Sprite.bom1.getFxImage();
            } else if (a % 60 == 30) {
                img = Sprite.bom2.getFxImage();
            } else if(a%60==15){
                img = Sprite.bom1.getFxImage();
            }
        } else if (a == 100) {

            Explode bombom = new Explode(getX() / 64, getY() / 64, Sprite.bombom.getFxImage());
            Explode bomup = new Explode(getX() / 64, getY() / 64 - 1, Sprite.bomup.getFxImage());
            Explode bomdown = new Explode(getX() / 64, getY() / 64 + 1, Sprite.bomdown.getFxImage());
            Explode bomleft = new Explode(getX() / 64 - 1, getY() / 64, Sprite.bomleft.getFxImage());
            Explode bomright = new Explode(getX() / 64 + 1, getY() / 64, Sprite.bomright.getFxImage());
            BombermanGame.explodes.add(bombom);
            BombermanGame.explodes.add(bomup);
            BombermanGame.explodes.add(bomdown);
            BombermanGame.explodes.add(bomleft);
            BombermanGame.explodes.add(bomright);
        } else if(a==0){

            BombermanGame.explodes.subList(0, 5).clear();
            BombermanGame.boms.remove(0);
        }
    }
}
