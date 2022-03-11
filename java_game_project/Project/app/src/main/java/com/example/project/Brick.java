package com.example.project;

import android.graphics.Bitmap;

public class Brick extends Entity {
    protected Bitmap bmp = Assets.brickScaled;
    public Brick(int rowIndex, int colIndex){
        super(rowIndex,colIndex,true);
    }

    public Bitmap getBitmap() { return bmp; }
}
