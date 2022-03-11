package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.ArrayList;

public class Grid {
    protected Rect[][] grid;
    protected Entity[][] entities;
    protected ArrayList<Key> keyList;
    private int width,height;
    private int row,col;
    public Grid(){
        width = Entity.WIDTH;
        height = Entity.HEIGHT;
        keyList = new ArrayList<>();
        createGrid();
    }

    private void createGrid(){
        double rowD = Math.ceil(Device.screenHeight/(double)height);
        double colD =  Math.ceil(Device.screenWidth/(double)width);
        //Log.d("Row,Col",String.valueOf(Device.screenWidth) + " " +String.valueOf(Device.screenHeight));
        this.row = (int) rowD;
        this.col = (int) colD;
        //Log.d("Row,Col",String.valueOf(row) + " " +String.valueOf(col));
        grid = new Rect[row][col];
        entities = new Entity[row][col];
        for(int i=0;i<this.getRowSize();i++){
            for(int j=0;j<this.getColSize();j++){
                grid[i][j] = new Rect(j*width, i*height , j*width+width, i*height+height);
                entities[i][j] = null;
                //Log.d("Rect",grid[i][j].toString() + String.valueOf(j));
            }
        }
    }

    public Entity getEntity(int rowIndex, int colIndex) { return entities[rowIndex][colIndex]; }
    public void setEntities(int rowIndex, int colIndex, Entity obj) { entities[rowIndex][colIndex] = obj; }
    public Rect getRec(int rowIndex, int colIndex) { return grid[rowIndex][colIndex]; }
    public int getRowSize() { return row; }
    public int getColSize() { return col; }
}
