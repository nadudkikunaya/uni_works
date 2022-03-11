/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodatester;

/**
 *
 * @author INatZ
 */
public class SodaCan {
    private double h = 0;
    private double d = 0;
    private double surfaceArea = 0;
    private double volume = 0;
    
    /**
     * 
     * @param height
     * @param diameter
     *
     */
    SodaCan(double height,double diameter){
        this.h = height;
        this.d = diameter;
        
        double r = this.d/2;
        double cirArea = Math.PI * r * r;
        double heightSurface = Math.PI * 2 * r * this.h ;
        this.surfaceArea = (cirArea * 2) + heightSurface;
        this.volume = cirArea * this.h;
    }
    
    public float getVolume(){
        return (float)this.volume;
    }
    
    public float getSurfaceArea(){
        return (float)this.surfaceArea;
    }
    
    
}
