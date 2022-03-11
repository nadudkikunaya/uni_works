package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.project.CharacterSprite;

public class Character extends CharacterSprite {
    private Bitmap[] animation;
    private Health health;
    private Rect rec = new Rect();
    public Character(Bitmap bmp , int gRowIndex, int gColIndex, int frame,int healthAmt,String name){
        super(bmp,gRowIndex,gColIndex,frame);
        health = new Health(name,healthAmt,getRect().left,getRect().top-10);
        animation = new Bitmap[frame];
        createAnimation();
    }



    public void createAnimation(){
        Bitmap cropped;
        for(int i=0;i<this.getMaxFrame();i++){
            cropped = Bitmap.createBitmap(this.getImage(), i*(getImage().getWidth()/2), 0 , getImage().getWidth()/getMaxFrame(), getImage().getHeight());
            animation[i] = cropped;
        }
    }


    public void draw(Canvas canvas){
        //Log.d("Index", String.valueOf(getIndex()));
        canvas.drawBitmap(animation[getIndex()], getRect().left, getRect().top, null);
        //Log.d("Pos :", String.valueOf(getRect().left) + " " + String.valueOf(getRect().top));
        health.draw(canvas);
    }

    public void update(Entity obj){
        super.tick();
        if(obj instanceof Water)
            decreaseHealth(5);
    }

    public void decreaseHealth(int amt){
        if(health.getHealth() - amt > 0)
            health.setHealth(health.getHealth()-amt);
        else if(health.getHealth() - 1 >= 0)
            health.setHealth(health.getHealth()-1);
    }

    public int getHealth(){
        return health.getHealth();
    }




}
