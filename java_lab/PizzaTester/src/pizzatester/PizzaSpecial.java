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
public class PizzaSpecial extends Pizza {
    private String special;
    public PizzaSpecial(String pz, double p, String spc){
        super(pz,p);
        this.special = spc;
    }
    
    public String getSpecial(){
        return this.special;
    }
    
    public String toString(){
        return super.toString() + "[special : " + this.special + "]";
    }
}
