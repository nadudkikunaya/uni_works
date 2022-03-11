/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citygridtester;

import java.util.Random;

/**
 *
 * @author INatZ
 */
public class CityGrid {
    private int xCoor; 
    private int yCoor; 
    private int gridSize; 
    
    CityGrid(int n){
        gridSize = n;
        xCoor = gridSize/2;
        yCoor = gridSize/2;
    }
    
    public void walk(){
        Random rd = new Random();
        int mode = rd.nextInt(4);
        switch(mode){
            case 0:
                xCoor++;
                break;
            case 1:
                yCoor++;
                break;
            case 2:
                xCoor--;
                break;
            case 3:
                yCoor--;
        }
        
    }
    
    public boolean isInCity(){
        boolean checkX = xCoor>=0 && xCoor<= gridSize;
        boolean checkY = yCoor>=0 && yCoor<= gridSize;
        return checkX && checkY;
    }
    
    public void reset(){
        xCoor = gridSize/2;
        yCoor = gridSize/2;
    }
}
