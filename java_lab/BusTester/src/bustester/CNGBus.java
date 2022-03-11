/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bustester;

/**
 *
 * @author INatZ
 */
public class CNGBus extends Bus implements LiquidFuel{
    private double range;
    private int emissionTier;
    public CNGBus(int cap, double cost, double range, int emiss){
        super(cap, cost);
        this.range = range;
        this.emissionTier = emiss;
    }
    
    @Override
    public double getRange() {return range;}
    
    @Override
    public int getEmissionTier() {return emissionTier;}
    
    @Override
    public double getAccel(){
        return 3.0;
    }
}
