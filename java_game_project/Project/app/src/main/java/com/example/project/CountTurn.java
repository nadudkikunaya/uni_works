package com.example.project;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class CountTurn {
    public int turn;
    public String text,text2;
    public int state;
    private Paint headerPaint = new Paint();
    private Paint middlePaint = new Paint();
    private Paint middlePaintBox = new Paint();
    public CountTurn(int amt){
        text = "Your turn : ";
        turn = amt;
        state = 0;
        headerPaint.setTextSize(80);
        headerPaint.setColor(Color.WHITE);
        middlePaint.setTextSize(80);
        middlePaint.setColor(Color.WHITE);
        middlePaintBox.setColor(Color.BLACK);
    }

    public void draw(Canvas canvas){
        if(state > 0 || (state == 0 && turn == 0)) {
            canvas.drawText(text + turn, Device.screenWidth/3, (Device.screenHeight/64)*3, headerPaint);
            canvas.drawRect(new Rect(0,0,1080,1920),middlePaintBox);
            canvas.drawText(text2, (Device.screenWidth/3) - (text2.length()*5), (Device.screenHeight/64)*10,middlePaint );
        }
        else if(state == 0 && turn > 0){
            canvas.drawText(text + turn, Device.screenWidth/3, (Device.screenHeight/64)*3, headerPaint);
        }
    }

    public void update(){
        if(state == 0 && turn == 0){
            text2 = "Click to try again";
        }
        if(state == 1) {
            text2 = "You lose";
        }
        if(state == 2){
            text2 = "You win";
        }
    }

    public void setTurn(int n) { turn = n;}
    public void setState(int st) { state = st; }
    public int getState() { return state; }
    public int getTurn() { return turn; }
}
