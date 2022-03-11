package com.example.testgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;


import java.util.ArrayList;
import java.util.Random;

public class Map {
    private Random rd = new Random();
    Bitmap bg = BitmapFactory.decodeResource(Device.resources, R.drawable.brick2bg);
    private ArrayList<Water> wtList;
    private long lastTime,timer;
    private int speed = 200;

    public Map(){
        wtList = new ArrayList<>();
        createWtList();
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void drawBG(Canvas canvas){
        canvas.drawBitmap(bg,0,0,null);
    }

    public void update(Character player, Character goblin){
        if(tick())
            updateWater(player,goblin);
    }


    private void createWtList(){
        for(int i=1;i<=10;i++){
            wtList.add(new Water(Device.screenWidth/2,20+(30*i)));
        }
    }

    public void updateWater(Character player, Character goblin){
        for(int i=0;i<wtList.size();i++){
            for(int j=0;j<wtList.size();j++) {
                Water obj1 = wtList.get(i);
                Water obj2 = wtList.get(j);
                obj1.update(player, goblin,obj2);
            }
        }
    }
    public void drawWater(Canvas canvas){
        for(int i=0; i < 10; i++){
            Water obj = wtList.get(i);
            obj.draw(canvas);
        }
    }

    private boolean tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > speed){
            timer = 0;
            return true;
        }
        return false;
    }




}
