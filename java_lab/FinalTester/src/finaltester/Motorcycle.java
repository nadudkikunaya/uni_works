/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltester;

/**
 *
 * @author INatZ
 */
public class Motorcycle extends Vehicle {
    public Motorcycle (String lp, double p) {
        super(lp, p);
    }
    public String getName() {
        return "a motorcycle";
    }
    public String toString() {
        return "Vehicle is " + getName() + ":" + getLicensePlate();
    }    
}

