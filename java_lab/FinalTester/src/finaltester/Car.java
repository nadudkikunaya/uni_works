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
public class Car extends Vehicle {
    private int door;
    public Car (String lp, int d, double p)  {
        super(lp, p);
        door = d;
    }
    public String getName()  {
        return "a car";
    }
    public String toString()  {
        return "Vehicle is " + getName() + ":" + getLicensePlate() + "\nNumber of doors are " + door;
    }
}

