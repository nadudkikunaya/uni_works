package com.example.project;

import android.graphics.Bitmap;

public class TestBlock extends Entity{
    protected Bitmap bmp = Assets.testBlock;
    public TestBlock(int rowIndex, int colIndex){
        super(rowIndex,colIndex,true);
    }

    public Bitmap getBitmap() { return bmp; }
}
