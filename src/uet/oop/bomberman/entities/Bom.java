package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bom extends Entity{
    int a=300;

    public Bom(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        a = a - 2;
        if (a > 150) {
            if (a % 60 == 0) {
                img = Sprite.bom.getFxImage();
            } else if (a % 60 == 45) {
                img = Sprite.bom1.getFxImage();
            } else if (a % 60 == 30) {
                img = Sprite.bom2.getFxImage();
            } else if(a%60==15){
                img = Sprite.bom1.getFxImage();
            }
        } else if (a == 150) {

            Explode bombom = new Explode(getX() / 64, getY() / 64, Sprite.bombom.getFxImage());
            Explode bomup = new Explode(getX() / 64, getY() / 64 - 1, Sprite.bomup.getFxImage());
            Explode bomdown = new Explode(getX() / 64, getY() / 64 + 1, Sprite.bomdown.getFxImage());
            Explode bomleft = new Explode(getX() / 64 - 1, getY() / 64, Sprite.bomleft.getFxImage());
            Explode bomright = new Explode(getX() / 64 + 1, getY() / 64, Sprite.bomright.getFxImage());
            if(BombermanGame.bombig){
                Explode bomup1 = new Explode(getX() / 64-1, getY() / 64 - 1, Sprite.bomup.getFxImage());
                Explode bomup2 = new Explode(getX() / 64+1, getY() / 64 - 1, Sprite.bomup.getFxImage());
                Explode bomdown1 = new Explode(getX() / 64-1, getY() / 64 + 1, Sprite.bomdown.getFxImage());
                Explode bomdown2 = new Explode(getX() / 64+1, getY() / 64 + 1, Sprite.bomdown.getFxImage());
                BombermanGame.explodes.add(bomup1);
                BombermanGame.explodes.add(bomdown1);
                BombermanGame.explodes.add(bomup2);
                BombermanGame.explodes.add(bomdown2);

            }
            BombermanGame.explodes.add(bombom);
            BombermanGame.explodes.add(bomup);
            BombermanGame.explodes.add(bomdown);
            BombermanGame.explodes.add(bomleft);
            BombermanGame.explodes.add(bomright);

        } else if(a==0){
            if(BombermanGame.boms.size()==1) {
                BombermanGame.explodes.clear();
                BombermanGame.boms.clear();
            } else {
                BombermanGame.boms.remove(0);
                if(BombermanGame.timedown2<3000){
                    for(int i=0;i<9;i++) {

                        BombermanGame.explodes.remove(0);

                    }
                }else {
                    for(int i=0;i<5;i++) {

                        BombermanGame.explodes.remove(0);

                    }
                }
            }
        }
    }
}
