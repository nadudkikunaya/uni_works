/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzatester;

/**
 *
 * @author INatZ
 */
public class Pizza {
    private String name;
    private double price;
    
    public Pizza(String n, double p){
        this.name = n;
        this.price = p;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String toString(){
        return getClass().getName() + ".[name : " + this.name + ", price : " + this.price + "]";
    }
}
