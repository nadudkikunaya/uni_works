package com.example.testgame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import android.view.SurfaceHolder;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Character player;
    private Character goblin;
    private Map map;
    private int cnt = 0;


    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        Device.setContext(context);
        Device.setResources(getResources());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        player = new Character(BitmapFactory.decodeResource(getResources(), R.drawable.player_model),
                200,1350,2,100, "Player");
        goblin = new Character(BitmapFactory.decodeResource(getResources(),R.drawable.globlin_model),
                700,1350,2,100,"Goblin");
        map = new Map();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;

        }
    }

    public void update() {
        player.update();
        goblin.update();
        map.update(player,goblin);


    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        map.drawBG(canvas);
        player.draw(canvas);
        goblin.draw(canvas);
        map.drawWater(canvas);

    }
}
