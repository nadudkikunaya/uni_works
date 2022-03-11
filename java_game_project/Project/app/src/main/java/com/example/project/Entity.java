package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class Entity {
    public final static int WIDTH = 64, HEIGHT = 64;
    protected int gridRowIndex, gridColIndex;
    private boolean isSolid = true;

    public Entity( int gridRow, int gridCol, boolean isSol){
        isSolid = isSol;
        gridRowIndex = gridRow;
        gridColIndex = gridCol;
    }

    public abstract Bitmap getBitmap();
    public int getWidth() { return WIDTH; }
    public int getHeight() { return HEIGHT; }

    public int getGridRowIndex() { return gridRowIndex ;}
    public int getGridColIndex() { return gridColIndex; }
    public void setGrid(int gRowIndex, int gColIndex) { gridRowIndex = gRowIndex; gridColIndex = gColIndex;}

    public boolean isSolid() { return isSolid; }
    public void setIsSolid(boolean isSol) { isSolid = isSol; }
}
