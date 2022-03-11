package com.example.project;

import android.graphics.Bitmap;

public class Key extends Entity{
    private Bitmap bmp;
    private int keyType;
    private boolean isOpened = true;
    private int keyID;
    private int xDrawKey, yDrawKey;
    public Key(int rowIndex, int colIndex, int direction, int id){
        super(rowIndex,colIndex,true);
        keyID = id;
        switch (direction){
            case 0: bmp = Assets.keyUp;
                keyType = 0;
                yDrawKey = getGridRowIndex();
                xDrawKey = getGridColIndex();
                break;
            case 1: bmp = Assets.keyDown;
                yDrawKey = getGridRowIndex()-1;
                xDrawKey = getGridColIndex();
                keyType = 1;
                break;
            case 2: bmp = Assets.keyLeft;
                keyType = 2;
                yDrawKey = getGridRowIndex();
                xDrawKey = getGridColIndex();
                break;
            case 3: bmp = Assets.keyRight;
                yDrawKey = getGridRowIndex();
                xDrawKey = getGridColIndex()-1;
                keyType = 3;
                break;
        }
    }

    public int getGridDrawKey_X() { return xDrawKey; }
    public int getGridrawKey_Y() {return yDrawKey; }
    public void setGridDrawKey_X(int xGridDrawKey) { xDrawKey = xGridDrawKey; }
    public void setGridDrawKey_Y(int yGridDrawKey) { yDrawKey = yGridDrawKey; }
    public boolean isOpened() { return isOpened; }
    public void setIsOpened(boolean b) { isOpened = b; }
    public int getKeyType() { return keyType; }
    public int getKeyID() { return keyID; }
    public Bitmap getBitmap() { return bmp; }
}
