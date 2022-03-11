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
public class Truck extends Car {
    private static double M_weight;
    private double weight;
    public Truck(double gas, double eff, double max, double w){
        super(gas,eff);
        M_weight = max;
        if(w > M_weight)
            weight = M_weight;
        else
            weight = w;
    }
    
    public void drive(double distance){
        double capability = distance / this.getEfficiency();
        if(weight >= 1 && weight <= 10){
            capability += (capability * 10) / 100;
        }
        else if(weight >= 11 && weight <= 20){
            capability += (capability * 20) / 100;
        }
        else if(weight > 20){
            capability += (capability * 30) / 100;
        }
        
        
        if(this.getGas() - capability >= 0){
            this.setGas(this.getGas() - capability);
        }
        else
            System.out.println("You cannot drive too far, please add gas");
    }
    
}
