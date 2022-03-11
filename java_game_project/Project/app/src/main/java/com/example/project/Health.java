package com.example.project;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Health {
    private String name;
    private int health;
    private int x,y;
    private Paint headerPaint = new Paint();
    private static final int distance = 15;
    public Health(String n, int h, int px, int py){
        name = n;
        health = h;
        x = px - 64;
        y = py - distance;
        headerPaint.setTextSize(50);
        headerPaint.setColor(Color.WHITE);
    }

    public void draw(Canvas canvas){
        canvas.drawText(name + " : " + health ,x,y, headerPaint);
    }

    public void update(int px, int py){
        x = px - distance;
        y = py - distance;
    }

    public int getHealth() { return health; }
    public void setHealth(int h) { this.health = h; }
}

