/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartester;

/**
 *
 * @author INatZ
 */
public class Car {
    private double gas;
    private double eff;
    // Constructors
    public Car(){
        gas = 0;
        eff = 0;
    }
    public Car(double g, double e){
        gas = g;
        eff = e;
    }
    // Methods
    public void drive(double distance){
        double capability = distance/eff;
        if(gas - capability >= 0){
            gas = gas - capability;
        }
        else
            System.out.println("You cannot drive too far, please add gas");
    }
    
    public void setGas(double amount){
        gas = amount;
    }
    
    public double getGas(){
        return gas;
    }
    
    public double getEfficiency(){
        return eff;
    }
    
    public void addGas(double amount){
        gas += amount;
    }
    
}
