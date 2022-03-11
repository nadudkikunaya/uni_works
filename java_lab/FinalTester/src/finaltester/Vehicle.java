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
public abstract class Vehicle{
    private String licensePlate;  
    private double price;
public Vehicle(String s, double p){
licensePlate = s;
price = p;
}
public String getLicensePlate(){ return licensePlate; }
public double getPrice() {return price; }
public abstract String getName();

} 

