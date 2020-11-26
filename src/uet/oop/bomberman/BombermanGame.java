package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    Stage stage;
    Group root;
    Scene scene, scene1,scene2,scene3;

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Explode> explodes = new ArrayList<>();
    private final List<Bot> entities = new ArrayList<>();
    private final List<Entity> stillObjects = new ArrayList<>();
    private final List<Bomber> player = new ArrayList<>();
    private final List<Grass> nen = new ArrayList<>();
    public static List<Bom> boms = new ArrayList<>();
    boolean datbom, goNorth, goSouth, goEast, goWest;




    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        scene1 = createSceneGui();
        scene = createSceneofGame();
        scene2=createSceneWin();
        scene3=createSceneDie();

        stage.setScene(scene1);
        stage.show();
    }

    private Scene createSceneGui() throws FileNotFoundException {
        stage.setTitle("Game Boom");

        //background image
        FileInputStream input = new FileInputStream("res/textures/background_Menu.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        //playimage
        FileInputStream inputStream = new FileInputStream("res/textures/Play.png");
        Image image1 = new Image(inputStream);
        ImageView imageView1 = new ImageView(image1);

        Button startgame = new Button("", imageView1);
        startgame.setMaxSize(100, 50);
        startgame.setLayoutX(400);
        startgame.setLayoutY(250);
        startgame.setWrapText(true);

        startgame.setOnAction(e -> switchScene(scene));

        root = new Group();

        root.getChildren().add(imageView);
        root.getChildren().add(startgame);

        scene1 = new Scene(root, 905 ,670);
        stage.setScene(scene1);
        stage.show();

        return scene1;
    }
    private Scene createSceneWin() throws FileNotFoundException {
        stage.setTitle("Game Boom");

        //background image
        FileInputStream input = new FileInputStream("res/textures/win.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        FileInputStream inputStream = new FileInputStream("res/textures/newgame_button.png");
        Image image1 = new Image(inputStream);
        ImageView imageView1 = new ImageView(image1);

        Button newgame = new Button("", imageView1);
        newgame.setMaxSize(100, 50);
        newgame.setLayoutX(350);
        newgame.setLayoutY(350);
        newgame.setWrapText(true);

        newgame.setOnAction(e -> {
            switchScene(scene1);

        });
        root = new Group();

        root.getChildren().add(imageView);
        root.getChildren().add(newgame);


        scene2 = new Scene(root, 852 ,480);
        stage.setScene(scene2);
        stage.show();
        return scene2;
    }
    private Scene createSceneDie() throws FileNotFoundException {
        stage.setTitle("Game Boom");

        //background image
        FileInputStream input = new FileInputStream("res/textures/game_over.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        FileInputStream inputStream = new FileInputStream("res/textures/newgame_button.png");
        Image image1 = new Image(inputStream);
        ImageView imageView1 = new ImageView(image1);

        Button newgame = new Button("", imageView1);
        newgame.setMaxSize(100, 50);
        newgame.setLayoutX(250);
        newgame.setLayoutY(750);
        newgame.setWrapText(true);

        newgame.setOnAction(e -> {
            stage.setScene(scene1);


        });
        FileInputStream inputStream1 = new FileInputStream("res/textures/return_button.png");
        Image image2 = new Image(inputStream1);
        ImageView imageView2 = new ImageView(image2);

        Button return_button = new Button("", imageView2);
        return_button.setMaxSize(100, 50);
        return_button.setLayoutX(550);
        return_button.setLayoutY(750);
        return_button.setWrapText(true);

        return_button.setOnAction(e ->{
            switchScene(scene);

        });

        root = new Group();

        root.getChildren().add(imageView);
        root.getChildren().add(newgame);
        root.getChildren().add(return_button);

        scene3 = new Scene(root, 900 ,900);
        stage.setScene(scene3);
        stage.show();
        return scene3;
    }
    private Scene createSceneofGame() {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:    goNorth = true; break;
                case DOWN:  goSouth = true; break;
                case LEFT:  goWest  = true; break;
                case RIGHT: goEast  = true; break;
                case SPACE: datbom = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:    goNorth = false; break;
                case DOWN:  goSouth = false; break;
                case LEFT:  goWest  = false; break;
                case RIGHT: goEast  = false; break;
                case SPACE: datbom = false; break;
            }
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {


                if (goNorth&&checkup()) player.get(0).moveup();
                else if (goSouth&&checkdown()) player.get(0).movedown();
                else if (goEast&&checkright()) player.get(0).moveright();
                else if (goWest&&checkleft())  player.get(0).moveleft();
                if(datbom) setDatbom();
                botcheckdie();
                if(checkdie()){
                    goEast=false;
                    goNorth=false;
                    goSouth=false;
                    goWest=false;
                    player.get(0).update();

                    stage.setScene(scene3);
                };
                if(checkwin()) {
                    stage.setScene(scene2);
                    stop();
                }
                render();
                update();

            }
        };
        timer.start();

        createMap();
        createBot();

        Bomber bomberman = new Bomber(1, 1, Sprite.player.getFxImage());
        player.add(bomberman);
        return scene;
    }


    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Grass co = new Grass(i, j, Sprite.grass.getFxImage());
                nen.add(co);
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                    stillObjects.add(object);
                }
                if(i%2==1&&j%2==0&&i>0&&j>1&&i<WIDTH-1&&j<HEIGHT-1){
                    object = new Wall(i, j, Sprite.cay.getFxImage());
                    stillObjects.add(object);
                }

            }
        }
        Grass point = new Grass(WIDTH-2,HEIGHT-2,Sprite.door.getFxImage());
        nen.add(point);

    }
    public boolean checkup(){
        for (Entity stillObject : stillObjects) {
            if (stillObject.getY() / 64 == (player.get(0).getY() - 1) / 64 && stillObject.getX() / 64 == (player.get(0).getX() + 8) / 64)
                return false;
        }
        return true;
    }
    public boolean checkdown(){
        for (Entity stillObject : stillObjects) {
            if (stillObject.getY() / 64 - 1 == player.get(0).getY() / 64 && stillObject.getX() / 64 == (player.get(0).getX() + 8) / 64)
                return false;
        }
        return true;
    }
    public boolean checkleft(){
        for (Entity stillObject : stillObjects) {
            if (stillObject.getY() / 64 == player.get(0).getY() / 64 && stillObject.getX() / 64 == (player.get(0).getX() - 1) / 64)
                return false;
        }
        return true;
    }
    public boolean checkright(){
        for (Entity stillObject : stillObjects) {
            if (stillObject.getY() / 64 == player.get(0).getY() / 64 && stillObject.getX() / 64 - 1 == player.get(0).getX() / 64)
                return false;
        }
        return true;
    }
    public boolean checkdie(){
        for (Bot entity : entities) {
            if ((entity.getX() + 64 >= player.get(0).getX() && entity.getX() - 32 <= player.get(0).getX()) && (entity.getY() - 48 <= player.get(0).getY() && entity.getY() + 48 >= player.get(0).getY())) {
                return true;
            }
        }
        for (Explode explode : explodes) {
            if (explode.getX() == player.get(0).getX()) {
                if (explode.getY() / 64 == (player.get(0).getY() + 48) / 64 || explode.getY() / 64 == (player.get(0).getY()+32) / 64) {
                    return true;
                }
            }
            if (explode.getY() == player.get(0).getY()) {
                if (explode.getX() / 64 == (player.get(0).getX() + 48) / 64 || explode.getX() / 64 == (player.get(0).getX()+32) / 64) {
                    return true;
                }
            }
        }
        return false;
    }
    public void botcheckdie(){
        for(int j=0;j<entities.size();j++){
            for (Explode explode : explodes) {
                if (explode.getX() == entities.get(j).getX()) {
                    if (explode.getY() / 64 == (entities.get(j).getY() + 48) / 64 || explode.getY() / 64 == (entities.get(j).getY() - 16) / 64) {
                        entities.remove(j);
                    }
                }
                if (explode.getY() == entities.get(j).getY()) {
                    if (explode.getX() / 64 == (entities.get(j).getX() + 48) / 64 || explode.getX() / 64 == (entities.get(j).getX() - 16) / 64) {
                        entities.remove(j);
                    }
                }
            }
        }
    }
    public void setDatbom() {
        if(boms.size()==0) {
            Bom bom = new Bom((player.get(0).getX() + 32) / 64, (player.get(0).getY() + 32) / 64, Sprite.bom.getFxImage());
            boms.add(bom);
        }
    }

    public void createBot(){
        entities.clear();
        for (int j = 0; j < HEIGHT; j++) {
            if (j % 2 == 1 && j > 1) {

                Bot object = new Bot(j-1, j, Sprite.bot_right1.getFxImage());
                entities.add(object);

            }
        }
    }
    public boolean checkwin(){
        if(player.get(0).getY()+16>=nen.get(nen.size()-1).getY()&&player.get(0).getX()+16>=nen.get(nen.size()-1).getX()){
            return true;
        }
        return false;
    }

    public void update() {
        entities.forEach(Entity::update);
        for (Bom bom : boms) {
              bom.update();
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        nen.forEach(g->g.render(gc));
        boms.forEach(g->g.render(gc));
        entities.forEach(g->g.render(gc));
        explodes.forEach(g->g.render(gc));
        stillObjects.forEach(g -> g.render(gc));

        player.forEach(g->g.render(gc));
    }
    public void switchScene(Scene scene) {
        stage.setScene(scene);
    }
}
