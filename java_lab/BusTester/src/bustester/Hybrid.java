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
public class Hybrid extends Bus implements Electric,LiquidFuel{
    private double voltage;
    private double range;
    private int emissionTier;
    public Hybrid(int cap, double cost, double volt, double range, int emiss){
        super(cap,cost);
        if(volt < Electric.LOW_VOLTAGE) this.voltage = Electric.LOW_VOLTAGE;
        else if(volt > Electric.HIGH_VOLTAGE) this.voltage = Electric.HIGH_VOLTAGE;
        this.range = range;
        this.emissionTier = emiss;
    }
    
    @Override
    public double getAccel(){ return 4.0; }
    
    @Override
    public double getRange() { return this.range; }
    
    @Override
    public int getEmissionTier() { return this.emissionTier; }
    
    public double getVoltage() { return this.voltage; }
    
}
