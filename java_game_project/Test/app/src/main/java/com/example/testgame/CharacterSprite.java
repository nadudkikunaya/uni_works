package com.example.testgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {
    private Bitmap image;
    private int x,y;
    private int maxFrame;
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;
    private long lastTime,timer;
    private int speed = 500 ,index;

    public CharacterSprite(Bitmap bmp , int px, int py, int f ){
        image = bmp;
        x = px;
        y = py;
        maxFrame = f;
        timer = 0;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > speed){
            index++;
            timer = 0;
            if(index >= getMaxFrame())
                index = 0;
        }
    }


    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return WIDTH; }
    public int getHeight() {return HEIGHT; }
    public int getIndex() { return index; }
    public int getMaxFrame(){ return maxFrame; }
    public Bitmap getImage() { return image; }




    public void setX(int px) { x = px; }
    public void setY(int py) { y = py; }


}
