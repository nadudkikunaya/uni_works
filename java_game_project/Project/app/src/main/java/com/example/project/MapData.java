package com.example.project;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class MapData {
    Grid grid;
    Random rd = new Random();
    private long lastTime,timer;
    private int keyCount;
    private int speed = 100;
    public MapData(){
        timer = 0;
        lastTime = System.currentTimeMillis();
        grid = new Grid();
        keyCount = 0;
        createBrick();
        createWater();
        createCharacterPit();
        createPath();
        createKey();
    }

    public void draw(Canvas canvas){
        drawBG(canvas);
        //drawGrid(canvas);
        for(int i=0;i<grid.getRowSize();i++){
            for(int j=0;j<grid.getColSize();j++){
                if(grid.entities[i][j] != null && !(grid.entities[i][j] instanceof Key)) {
                    canvas.drawBitmap(grid.entities[i][j].getBitmap(), grid.grid[i][j].left, grid.grid[i][j].top, null);
                }
            }
        }
    }

    public void drawKey(Canvas canvas){
        for(Key k : grid.keyList){
            canvas.drawBitmap(k.getBitmap(), grid.grid[k.getGridrawKey_Y()][k.getGridDrawKey_X()].left,
                    grid.grid[k.getGridrawKey_Y()][k.getGridDrawKey_X()].top,null);
        }
    }

    private void createWater(){
        for(int i=4;i<=6;i++){
            for(int j=5;j<13;j++){
                grid.entities[i][j] = new Water(i,j);
            }
        }
    }

    private void createBrick(){
        int cnt = 0;
        for(int i=3;i<grid.getRowSize()-3;i++){
            for(int j=3;j<grid.getColSize()-3;j++){
                boolean check_i = i > 7 && i < grid.getRowSize()-4;
                boolean check_j = j > 3 && j < grid.getColSize()-4;
                boolean check2 = (i > 3 && i< 7);

                if(check_i && check_j){
                    int rand = rd.nextInt(2);
                    if(rand == 0){
                        grid.entities[i][j] = null;
                    }
                    else
                        grid.entities[i][j] = new Brick(i,j);
                }
                else if(check2 && check_j){
                    grid.entities[i][j] = null;
                }
                else
                    grid.entities[i][j] = new Brick(i,j);
            }
        }
    }


    private void drawBG(Canvas canvas){
        canvas.drawBitmap(Assets.bgScaled,0,0,null);
    }
    private void drawGrid(Canvas canvas){
        for(int i=0;i<grid.getRowSize();i++){
            for(int j=0;j<grid.getColSize();j++){
                Paint p = new Paint();
                p.setStyle(Paint.Style.FILL);
                p.setColor(Color.MAGENTA);
                canvas.drawRect(grid.getRec(i,j),p);
                p.setStyle(Paint.Style.STROKE);
                p.setColor(Color.BLACK);
                canvas.drawRect(grid.getRec(i,j),p);
            }
        }
    }

    public void update(){
        if(tick())
        updateWater();
        //updateWater2();
    }

    private void updateWater(){
        for(int i=4;i<grid.getRowSize()-4;i++){
            for(int j=4;j<grid.getColSize()-4;j++){
        //Log.d("Position", String.valueOf(i) + " " +String.valueOf(j));
                if((grid.entities[i][j] instanceof Water) ) {
                    Water water = (Water) grid.entities[i][j];
                    if(!water.isFlow()){
                        water.setFlow(true);
                        continue;
                    }
                    if(grid.entities[i+1][j] == null){
                        water.setGrid(i+1,j);
                        grid.entities[i+1][j] = water;
                        grid.entities[i][j] = null;
                        water.setFlow(false);
                    }
                    else if(grid.entities[i+1][j-1] == null && grid.entities[i][j-1] == null && rd.nextInt(2) == 1){
                        water.setGrid(i+1,j-1);
                        grid.entities[i+1][j-1] = water;
                        grid.entities[i][j] = null;
                    }
                    else if(grid.entities[i+1][j-1] == null && grid.entities[i][j-1] == null && rd.nextInt(2) == 0){
                        water.setGrid(i+1,j-1);
                        grid.entities[i+1][j-1] = water;
                        grid.entities[i][j] = null;
                    }
                    else if(grid.entities[i+1][j+1] == null && grid.entities[i][j+1] == null && rd.nextInt(2) == 0){
                        water.setGrid(i+1,j+1);
                        grid.entities[i+1][j+1] = water;
                        grid.entities[i][j] = null;
                    }
                    else if(grid.entities[i+1][j+1] == null && grid.entities[i][j+1] == null && rd.nextInt(2) == 1){
                        water.setGrid(i+1,j+1);
                        grid.entities[i+1][j+1] = water;
                        grid.entities[i][j] = null;
                    }
                    else if(grid.entities[i][j-1] == null && rd.nextInt(2) == 0){
                        water.setGrid(i,j-1);
                        grid.entities[i][j-1] = water;
                        grid.entities[i][j] = null;
                    }
                    else if(grid.entities[i][j+1] == null && rd.nextInt(2) == 1){
                        water.setGrid(i,j-1);
                        grid.entities[i][j+1] = water;
                        grid.entities[i][j] = null;
                    }
                    else {
                        water.setFlow(false);
                        grid.entities[i][j] = water;
                    }
                }
            }
        }
    }

    private void createCharacterPit(){
        grid.entities[grid.getRowSize()-5][4] = null;
        grid.entities[grid.getRowSize()-5][grid.getColSize()-5] = null;

        Rect test = grid.grid[grid.getRowSize()-5][4];
        //Log.d("POSPIT", String.valueOf(test.left) + " " + String.valueOf(test.top));
    }

    private void createPath(){
       int rowIndex = grid.getRowSize()-5;
       int colIndex = 4;

       while(rowIndex > 7){
           //Log.d("INDEX", String.valueOf(rowIndex));
           int rand = rd.nextInt(4);
           if(rand == 0 || rand == 1) {
               rowIndex--;
               grid.entities[rowIndex][colIndex] = null; //new TestBlock(rowIndex,colIndex);
           }
           else if( rand == 2){
               if(colIndex+1 < grid.getColSize()/2+1){
                   colIndex++;
                   grid.entities[rowIndex][colIndex] = null; //new TestBlock(rowIndex,colIndex);
               }
           }
       }

        rowIndex = grid.getRowSize()-5;
        colIndex = grid.getColSize()-5;
        while(rowIndex > 7){
            //Log.d("INDEX", String.valueOf(rowIndex));
            int rand = rd.nextInt(3);
            if(rand == 0 || rand == 1) {
                rowIndex--;
                grid.entities[rowIndex][colIndex] = null; //new TestBlock(rowIndex,colIndex);
            }
            else if( rand == 2){
                if(colIndex-1 > grid.getColSize()/2-1){
                    colIndex--;
                    grid.entities[rowIndex][colIndex] = null; //new TestBlock(rowIndex,colIndex);
                }
            }
        }

    }

    private void createKey(){
        int num = 0;
        int quotaPerRow = 2;
        int distance = 0;
        for(int row = 7; row < grid.getRowSize()-4;row++){
            distance = 0;
            for(int col = 4 ; col < grid.getColSize()-4; col++ ){
                boolean checkLeft = grid.entities[row][col-1] != null && grid.entities[row][col-1].isSolid();
                boolean checkRight = grid.entities[row][col+1] != null && grid.entities[row][col+1].isSolid();
                boolean checkUp = grid.entities[row-1][col] != null && grid.entities[row-1][col].isSolid();
                boolean checkDown = grid.entities[row+1][col] != null && grid.entities[row+1][col].isSolid();
                if(quotaPerRow == 0){
                    quotaPerRow = 2;
                    break;
                }
                //Generate Left Right key
                if(grid.entities[row][col] == null && checkLeft && checkRight && col - distance > 3){
                    if(!checkUp && !checkDown) {
                        Key k = new Key(row, col, rd.nextInt(2)+2 , num++);
                        grid.entities[row][col] = k;
                        grid.keyList.add(k);
                        //Log.d("ROW,COL", String.valueOf(row) + " " + String.valueOf(col));
                        keyCount++;
                        quotaPerRow--;
                        distance = col;
                    }
                }

                //Generate Up key
                if(grid.entities[row][col] == null && checkUp && checkDown && col - distance > 3)
                    if(!checkLeft && !checkRight){
                        Key k = new Key(row,col,0,num++);
                        grid.entities[row][col] = k;
                        grid.keyList.add(k);
                        keyCount++;
                        quotaPerRow--;
                        distance = col;
                    }
            }
        }
    }
    public boolean tick(){
        boolean isTicking = false;
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > speed){
            isTicking = true;
            timer = 0;
        }
        return isTicking;
    }

    public int getKeyCount() {
        return keyCount/2+1;
    }


    public boolean updateKey(int rowIndex, int colIndex) {
        for(int i=0;i<grid.keyList.size();i++){
            Key k = grid.keyList.get(i);
            if(k.getGridRowIndex() == rowIndex && k.getGridColIndex() == colIndex){
                if(k.isOpened()){
                    // if key is opened then close
                    grid.entities[rowIndex][colIndex] = null;

                } else if(!k.isOpened()){
                    // if key is closed then open
                    grid.entities[rowIndex][colIndex] = k;
                }
                grid.keyList.set(i,moveKey(k));
                return true;
            }
        }
        return false;
    }

    public Key moveKey(Key k){
        if(k.isOpened()){
            //move out
            if(k.getKeyType() == 0){
                //if is key type up
                k.setGridDrawKey_Y(k.getGridrawKey_Y()+1);
            } else if( k.getKeyType() == 1){
                // if is key type down
                k.setGridDrawKey_Y(k.getGridrawKey_Y()-1);
            } else if( k.getKeyType() == 2){
                // if is key type left
                k.setGridDrawKey_X(k.getGridDrawKey_X()+1);
            } else if( k.getKeyType() == 3){
                //if is key type right
                k.setGridDrawKey_X(k.getGridDrawKey_X()-1);
            }
        }
        else if(!k.isOpened()){
            if(k.getKeyType() == 0) {
                //if is key type up
                k.setGridDrawKey_Y(k.getGridrawKey_Y() - 1);
            } else if(k.getKeyType() == 1){
                //if is key type down
                k.setGridDrawKey_Y(k.getGridrawKey_Y()+1);
            } else if( k.getKeyType() == 2){
                //if is key type left
                k.setGridDrawKey_X(k.getGridDrawKey_X()-1);
            } else if( k.getKeyType() == 3){
                //if is key type right
                k.setGridDrawKey_X(k.getGridDrawKey_X()+1);
            }
        }
        k.setIsOpened(!k.isOpened());
        return k;
    }
}

