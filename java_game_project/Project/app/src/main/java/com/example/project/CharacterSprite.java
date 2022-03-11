package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class CharacterSprite{
    private Bitmap image;
    private int gridRowIndex,gridColIndex;
    private int maxFrame;
    private Rect rec;
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;
    private long lastTime,timer;
    private int speed = 500 ,index;

    public CharacterSprite(Bitmap bmp , int gRowIndex, int gColIndex, int f ){
        image = bmp; //Bitmap.createScaledBitmap(bmp,f*64,64,false);
        gridRowIndex = gRowIndex;
        gridColIndex = gColIndex;
        rec = new Rect(gColIndex*64,gRowIndex*64,gRowIndex*64+64,gridColIndex*64+64);
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

    public Rect getRect() { return rec; }
    public int getGridRowIndex() { return gridRowIndex; }
    public int getGridColIndex() { return gridColIndex; }
    public int getWidth() { return WIDTH; }
    public int getHeight() {return HEIGHT; }
    public int getIndex() { return index; }
    public int getMaxFrame(){ return maxFrame; }
    public Bitmap getImage() { return image; }


}
