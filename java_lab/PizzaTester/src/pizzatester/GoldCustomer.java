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
public class GoldCustomer extends Customer {
    private double discount;
    public GoldCustomer(String n, String t, double dc){
        super(n,t);
        this.discount = dc;
        
    }
    
    public double getDiscount(){
        return discount;
    }
    
    public String toString(){
        return super.toString() + "[discount : " + this.discount + "]";
    }
    
}
