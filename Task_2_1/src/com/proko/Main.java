package com.proko;


import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    GridPane GameGrid = new GridPane();
    GridPane TextGrid = new GridPane();

    //GAME GRID - 40x40
    int GridSizeSquared = 40;

    Label GameOver = new Label("");
    Label Pause = new Label("Нажми любую кнопку, чтобы начать.");

    Label ControlU = new Label("[W/Up]");
    Label ControlD = new Label("[S/Down]");
    Label ControlL = new Label("[A/Left] ");
    Label ControlR = new Label(" [D/Right]");

    Label Close = new Label("Нажми [Escape], чтобы закрыть");


    //ArrayList for the Snake and its body
    //Index 0 of ArrayList is treated as the Head
    ArrayList<Snake> SnakeP = new ArrayList<>(0);
    ArrayList<Snake> SnakePC = new ArrayList<>(0);

    //This will be used to keep the game running
    Timeline Loop;

    //LOOP SPEED
    //1/10 seconds == 10FPS
    double LoopSpeed = 1 / 10.0;

    //movementX and movementY, these indicate the direction of the snake head
    //Initial movement is 0
    int deltaX = 0, deltaY = 0;

    //Snakes Head's Initial Position
    int posX = new Random().nextInt(GridSizeSquared), posY = new Random().nextInt(GridSizeSquared);
    int pcPosX = new Random().nextInt(GridSizeSquared), pcPosY = new Random().nextInt(GridSizeSquared);

    //Snake Food, same size as snake (Snake.java)
    Rectangle Food = new Rectangle(12, 12, Color.YELLOW);
    int FoodPosX = new Random().nextInt(GridSizeSquared);
    int FoodPosY = new Random().nextInt(GridSizeSquared);

    //True = Game is Running
    //False = Game is Paused
    boolean start = false;
    boolean dead = false;

    public void start(Stage PrimaryStage) {

        //Fills Grid with Gray Squares
        FillGrid();

        //Constructing Snake's Heads
        SnakeP.add(new Snake(posX, posY));
        SnakePC.add(new Snake(pcPosX, pcPosY));

        TextGrid.setVgap(1.5);
        TextGrid.setHgap(2);

        //Setting Grid Positions
        GameGrid.setAlignment(Pos.CENTER);
        TextGrid.setAlignment(Pos.CENTER);

        //Initial positions
        GameGrid.add(Food, FoodPosX, FoodPosY);
        GameGrid.add(SnakeP.get(0).body, posX, posY);
        GameGrid.add(SnakePC.get(0).body, pcPosX, pcPosY);

        //Adding Text to Grid
        TextGrid.add(GameOver, 1, 1, 3, 2);
        TextGrid.add(Pause, 1, 3, 3, 1);
        TextGrid.add(ControlU, 2, 4, 1, 1);
        TextGrid.add(ControlL, 1, 5, 1, 1);
        TextGrid.add(ControlD, 2, 5, 1, 1);
        TextGrid.add(ControlR, 3, 5, 1, 1);

        TextGrid.add(Close, 1, 6, 3, 1);

        //Allows to use both grids in the same screen
        FlowPane Screen = new FlowPane(Orientation.VERTICAL, GameGrid, TextGrid);

        //Creating Game Scene with a black background
        Scene Game = new Scene(Screen);

        //Detects a Key Being Pressed
        Game.setOnKeyPressed(this::KeyPressedProcess);

        //Generates Window
        PrimaryStage.setTitle("ProkoSnake");
        PrimaryStage.setScene(Game);
        PrimaryStage.show();

        //Initializing Loop as timeline.
        Loop = new Timeline(new KeyFrame(Duration.seconds(LoopSpeed),
                event -> {

                    //Moves Snake
                    MoveUserSnake();
                    MovePCSnake();
                }));
        // Loop will run endlessly
        Loop.setCycleCount(Timeline.INDEFINITE);
    }

    public void MoveUserSnake() {
        //WALL CRASH
        if (deltaX == -1 && (posX == 0)) {
            Die();
            deltaX = 0;
        } else if (deltaY == -1 && (posY == 0)) {
            Die();
            deltaY = 0;
        } else if (deltaX == 1 && (posX == GridSizeSquared - 1)) {
            Die();
            deltaX = 0;
        } else if (deltaY == 1 && (posY == GridSizeSquared - 1)) {
            Die();
            deltaY = 0;
        }
        //No wall crash happens
        else {

            //Updates head position
            GameGrid.getChildren().remove(SnakeP.get(0).body);

            posX += deltaX;
            posY += deltaY;
            GameGrid.add(SnakeP.get(0).body, posX, posY);
            SnakeP.get(0).setPos(posX, posY);

            //Update for rest of body
            if (SnakeP.size() > 1) {
                for (int x = 1; x < SnakeP.size(); x++) {
                    GameGrid.getChildren().remove(SnakeP.get(x).body);
                    GameGrid.add(SnakeP.get(x).body, SnakeP.get(x - 1).getOldXpos(), SnakeP.get(x - 1).getOldYpos());
                    SnakeP.get(x).setPos(SnakeP.get(x - 1).getOldXpos(), SnakeP.get(x - 1).getOldYpos());
                }

            }

            //FOOD WAS FOUND
            if (posX == FoodPosX && posY == FoodPosY) {
                //Grows Snake duh
                Grow(SnakeP);
            }

            //BODY CRASH
            for (int x = 1; x < SnakeP.size(); x++) {
                if (posX == SnakeP.get(x).getXpos() && posY == SnakeP.get(x).getYpos()) {
                    Die();
                }
            }


        }


    }


    public void MovePCSnake() {

            //Updates head position
            GameGrid.getChildren().remove(SnakePC.get(0).body);

            //Food Distance
            int xRout = FoodPosX - pcPosX;
            int yRout = FoodPosY - pcPosY;

            if (xRout > 0) {
                pcPosX += 1;
            } else if (xRout < 0) {
                pcPosX -= 1;
            } else if (yRout > 0) {
                pcPosY += 1;
            } else if (yRout < 0) {
                pcPosY -= 1;
            }

            GameGrid.add(SnakePC.get(0).body, pcPosX, pcPosY);
            SnakePC.get(0).setPos(pcPosX, pcPosY);

            //Update for rest of body
            if (SnakePC.size() > 1) {
                for (int x = 1; x < SnakePC.size(); x++) {
                    GameGrid.getChildren().remove(SnakePC.get(x).body);
                    GameGrid.add(SnakePC.get(x).body, SnakePC.get(x - 1).getOldXpos(), SnakePC.get(x - 1).getOldYpos());
                    SnakePC.get(x).setPos(SnakePC.get(x - 1).getOldXpos(), SnakePC.get(x - 1).getOldYpos());
                }

            }

            //FOOD WAS FOUND
            if (pcPosX == FoodPosX && pcPosY == FoodPosY) {
                //Grows Snake duh
                Grow(SnakePC);
            }

            //BODY CRASH
            for (int x = 1; x < SnakePC.size(); x++) {
                if (pcPosX == SnakePC.get(x).getXpos() && pcPosY == SnakePC.get(x).getYpos()) {
                    Die();
                }
            }
    }

    //Detects Key Presses
    public void KeyPressedProcess(KeyEvent event) {
        //If you GameOver and Restart
        if (!start && dead && event.getCode() == KeyCode.ENTER) {
            Pause.setText("Нажмите [Enter], чтобы прервать");
            GameOver.setText("");
            Loop.play();
            start = true;
            dead = false;
        }
        //If Paused and Resumed
        else if (!start && !dead) {
            Pause.setText("Нажмите [Enter], чтобы прервать");
            Loop.play();
            start = true;
        }

        //If Enter is pressed, game will pause
        if (event.getCode() == KeyCode.ENTER) {
            Pause.setText("Нажмите любую кнопку, чтобы продолжить");
            Loop.stop();
            start = false;
        }

        //Changes direction to UP when up/W is pressed
        if (deltaY == 0 && (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP)) {
            deltaX = 0;
            deltaY = -1;
        }
        //Changes direction to DOWN when down/S is pressed
        else if (deltaY == 0 && (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN)) {
            deltaX = 0;
            deltaY = 1;
        }
        //Changes direction to Left when left/A is pressed
        else if (deltaX == 0 && (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT)) {
            deltaX = -1;
            deltaY = 0;
        }
        //Changes direction to Right when right/D is pressed
        else if (deltaX == 0 && (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT)) {
            deltaX = 1;
            deltaY = 0;
        }

        //Closes program when escape is pressed
        if (event.getCode() == KeyCode.ESCAPE)
            System.exit(0);
    }

    //Fills Grid with rectangles
    public void FillGrid() {
        for (int x = 0; x < GridSizeSquared; x++) {
            GameGrid.addColumn(x, new Rectangle(12, 12, Color.GRAY));

            for (int y = 1; y < GridSizeSquared; y++)
                GameGrid.addRow(y, new Rectangle(12, 12, Color.GRAY));
        }
    }

    //Changes randomly Food's position
    public void PlaceFood() {
        Random rPos = new Random();

        int newPosX = rPos.nextInt(GridSizeSquared);
        int newPosY = rPos.nextInt(GridSizeSquared);

        FoodPosX = newPosX;
        FoodPosY = newPosY;

        GameGrid.getChildren().remove(Food);
        GameGrid.add(Food, newPosX, newPosY);
    }

    //Grows Snake's Body
    public void Grow(ArrayList<Snake> Snake) {
        //Adds new Tail where last Tail's position was
        Snake.add(new Snake(Snake.get(Snake.size() - 1).getOldXpos(),
                Snake.get(Snake.size() - 1).getOldYpos()));

        GameGrid.add(Snake.get(Snake.size() - 1).body,
                Snake.get(Snake.size() - 1).getOldXpos(),
                Snake.get(Snake.size() - 1).getOldYpos());

        PlaceFood();

    }

    //Game Over
    public void Die() {

        int size = SnakeP.size();

        //First Removes all but the head from the grid
        for (int x = size - 1; x > 0; x--)
            GameGrid.getChildren().remove(SnakeP.get(x).body);

        //Removes all but the head from the arrayList
        if (size > 1) {
            SnakeP.subList(1, size).clear();
        }

        //Pauses Game
        start = false;
        dead = true;
        Loop.stop();

        GameOver.setText("Игра окончена");
        Pause.setText("Нажмите Enter, чтобы перезапустить игру.");

        //Generates new Position for the snake
        posX = new Random().nextInt(GridSizeSquared);
        posY = new Random().nextInt(GridSizeSquared);

        //Places Snake in new Position
        GameGrid.getChildren().remove(SnakeP.get(0).body);
        GameGrid.add(SnakeP.get(0).body, posX, posY);
        SnakeP.get(0).setPos(posX, posY);

    }

}
