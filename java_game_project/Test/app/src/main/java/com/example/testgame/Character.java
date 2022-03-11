package com.example.testgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Character extends CharacterSprite {
    private Bitmap[] animation;
    private Health health;
    private Rect rec = new Rect();
    public Character(Bitmap bmp , int px, int py, int frame,int h,String name){
        super(bmp,px,py,frame);
        health = new Health(name,h,getX(),getY());
        animation = new Bitmap[frame];
        rec.set(getX(), getY(),getX()+(getImage().getWidth()/2), getY()+getImage().getHeight());
        createAnimation();
    }


    public Bitmap getAnimation(int frame){
        if(frame < 0 || frame > this.getMaxFrame()){
            frame = 0;
        }
        return animation[frame];
    }

    public void createAnimation(){
        Bitmap cropped;
        for(int i=0;i<this.getMaxFrame();i++){
            cropped = Bitmap.createBitmap(this.getImage(), i*(getImage().getWidth()/2), 0 , getImage().getWidth()/getMaxFrame(), getImage().getHeight());
            animation[i] = cropped;
        }
    }


    public void draw(Canvas canvas){
        Paint test = new Paint();
        test.setColor(Color.MAGENTA);
        canvas.drawRect(getX(),getY(),getX()+(getImage().getWidth()/2),getY()+getImage().getHeight(), test);
        canvas.drawBitmap(animation[getIndex()], getX(), getY(), null);
        health.draw(canvas);
    }

    public void update(){
        super.tick();
        //this.setX(getX() + 5);
        //this.setY(getY() + 10);
        if((getX()>Device.screenWidth - getWidth()) || (getX()<0)){
            this.setX(0);
            this.setY(0);
        }
        rec.set(getX(),getY(),getX()+(getImage().getWidth()/2), getY()+getImage().getHeight());
        health.update(getX(),getY());
    }

    public void decreaseHealth(int amt){
        if(health.getHealth() - amt > 0)
            health.setHealth(health.getHealth()-amt);
        else if(health.getHealth() - 1 >= 0)
            health.setHealth(health.getHealth()-1);
    }

    public Rect getRect() { return rec; }



}
