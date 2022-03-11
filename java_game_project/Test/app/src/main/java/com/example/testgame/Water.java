package com.example.testgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

public class Water {
    public static final Bitmap BITMAP_WATER = Assets.wt;
    private Rect rec = new Rect();
    private Random rd = new Random();
    private int yVelocity = 15;
    private int xVelocity = 20;
    private boolean isLock = false;
    public Water(int x,int y){
        rec.set(x,y,x+BITMAP_WATER.getWidth(),y+BITMAP_WATER.getHeight());
        if(rd.nextInt(2) == 1){
            xVelocity *= -1;
        }
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(BITMAP_WATER,rec.left,rec.top,null);
    }

    public void update(Character player, Character goblin, Water otherWater){
        if(this.rec.bottom <= player.getRect().bottom){
            flowDown(player.getRect(),goblin.getRect());
            flowIntersec(otherWater);
        }
        if(player.getRect().intersect(this.rec)){
            player.decreaseHealth(1);
        }
        if(goblin.getRect().intersect(this.rec)){
            goblin.decreaseHealth(1);
        }
    }

    private void flowDown(Rect player, Rect goblin){
        if (rec.bottom+yVelocity < player.bottom)
            rec.set(rec.left,rec.top+yVelocity,rec.right,rec.bottom+yVelocity);
    }

    private void flowIntersec(Water other){
        if(this.rec.intersect(other.rec)){
            if( (this.rec.left + xVelocity < Device.screenWidth - Assets.wt.getWidth())
            && (this.rec.left + xVelocity > 0))
                rec.set(rec.left + xVelocity, rec.top , rec.right + xVelocity, rec.bottom);
        }

    }
    public int getX() { return rec.left; }
    public int getY() { return rec.top; }
}
