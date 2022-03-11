package com.example.project;

import android.graphics.Bitmap;

public class Water extends Entity{
    protected Bitmap bmp = Assets.toxicScaled;
    private boolean flow = true;
    public Water(int gRowIndex, int gColIndex){
        super(gRowIndex,gColIndex,false);
    }

    public Bitmap getBitmap() {return bmp;}

    public boolean isFlow() {
        return flow;
    }

    public void setFlow(boolean b) { flow = b;}
    public void update(){

    }

}
