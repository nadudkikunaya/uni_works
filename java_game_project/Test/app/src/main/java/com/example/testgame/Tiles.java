package com.example.testgame;

import android.graphics.Bitmap;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class Tiles {
    private int x,y;
    private int width=64,height=64;
    Rectangle rc;
    Bitmap image;
    public Tiles(Bitmap bmp,int px, int py){
        image = bmp;
        rc = new Rectangle();
        x = px;
        y = py;
    }

    public boolean isSolid(){
        return false;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Bitmap getImage(){ return image; }
    public int getX() { return x; }
    public int getY() { return y; }

}
