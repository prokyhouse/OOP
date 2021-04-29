package com.proko;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Snake
{
    Color snakeColor = Color.GREENYELLOW;

    public Rectangle body = new Rectangle(12,12, snakeColor); //SNAKE BODY

    private int Xpos;
    private int Ypos;
    private int oldXpos;
    private int oldYpos;

    Snake(int X, int Y)
    {
        oldXpos = Xpos = X;
        oldYpos = Ypos = Y;
    }

    public void setSnakeColor(Color snakeColor){
        body = new Rectangle(12,12, snakeColor);
    }

    public void setPos(int X, int Y)
    {
        oldXpos =Xpos;
        oldYpos =Ypos;

        Xpos =X;
        Ypos =Y;
    }

    public int getOldXpos()
    { return oldXpos; }

    public int getOldYpos()
    {return oldYpos;}

    public int getXpos()
    {return Xpos; }

    public int getYpos()
    {return Ypos; }

}