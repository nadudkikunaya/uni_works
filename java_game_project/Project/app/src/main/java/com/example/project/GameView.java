package com.example.project;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    MapData map;
    Grid grid;
    Character player;
    Character goblin;
    CountTurn turn;



    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        Device.setContext(context);
        Device.setResources(getResources());
    }

    public void init(){
        grid = new Grid();
        map = new MapData();
        player = new Character(Assets.playerScaled, grid.getRowSize()-5,4,
                2,100, "Player");
        goblin = new Character(Assets.goblinScaled, grid.getRowSize()-5, grid.getColSize()-5,
                2, 100, "Goblin");
        turn = new CountTurn(map.getKeyCount());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int rowIndex = (int)Math.floor(event.getY()/Assets.GRID_HEIGHT);
        int colIndex = (int)Math.floor(event.getX()/Assets.GRID_WIDTH);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(map.updateKey(rowIndex, colIndex) && turn.getTurn() > 0){
                    turn.setTurn(turn.getTurn()-1);
                    turn.update();
                }
                else if(turn.getTurn() <= 0 || turn.getState() > 0){
                    turn.setTurn(-1);
                    Log.d("STATE","I'm in" + String.valueOf(turn.getTurn()) + " " + String.valueOf(turn.getState()));
                }

                if(turn.getTurn() <= -1) {
                    Log.d("STATE","I'm in2" + String.valueOf(turn.getTurn()) + " " + String.valueOf(turn.getState()));
                    init();
                }
                //Log.d("PRESS :" , + Math.floor(event.getX()/64) + "," + Math.floor(event.getY()/64));
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        init();
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
        if(turn.getTurn() > 0 && turn.getState() == 0) {
            map.update();
            player.update(map.grid.entities[player.getGridRowIndex()][player.getGridColIndex()]);
            goblin.update(map.grid.entities[goblin.getGridRowIndex()][goblin.getGridColIndex()]);
            if (player.getHealth() <= 0) {
                turn.setState(1);
                turn.update();
            } else if (goblin.getHealth() <= 0) {
                turn.setState(2);
                turn.update();
            }
        }

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        //canvas.drawColor(Color.BLUE);
        map.draw(canvas);
        map.drawKey(canvas);
        player.draw(canvas);
        goblin.draw(canvas);
        turn.draw(canvas);


    }
}

