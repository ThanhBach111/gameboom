package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Bot> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private List<Bomber> player = new ArrayList<>();
    boolean running, goNorth, goSouth, goEast, goWest;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:    goNorth = true; break;
                case DOWN:  goSouth = true; break;
                case LEFT:  goWest  = true; break;
                case RIGHT: goEast  = true; break;
                case SHIFT: running = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:    goNorth = false; break;
                case DOWN:  goSouth = false; break;
                case LEFT:  goWest  = false; break;
                case RIGHT: goEast  = false; break;
                case SHIFT: running = false; break;
            }
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {


                if (goNorth) player.get(0).moveup();
                if (goSouth) player.get(0).movedown();
                if (goEast) player.get(0).moveright();
                if (goWest)  player.get(0).moveleft();




                render();
                update();

            }
        };
        timer.start();

        createMap();
        createBot(2);

        Bomber bomberman = new Bomber(1, 1, Sprite.player.getFxImage());
        player.add(bomberman);
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
                if(i%2==0&&j%2==0&&i>1&&j>1&&i<WIDTH-1&&j<HEIGHT-1){
                    object = new Wall(i, j, Sprite.cay.getFxImage());
                }
                stillObjects.add(object);
            }
        }

    }

    public void createBot(int a){

        for (int j = 0; j < HEIGHT; j++) {
            if (j % 2 == 1 && j > 1) {

                Bot object = new Bot(a, j, Sprite.bot_right1.getFxImage());
                entities.add(object);

            }
        }
    }


    public void update() {
        entities.forEach(Entity::update);

    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g->g.render(gc));
        player.forEach(g->g.render(gc));
    }
}
