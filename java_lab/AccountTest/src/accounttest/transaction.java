/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttest;

/**
 *
 * @author INatZ
 */
public class Transaction {
    private double amount;
    private String timeStr;
    private String type;
    
    public Transaction(double amt, String ts, String mode){
        this.amount = amt;
        this.timeStr = ts;
        this.type = mode;
    }
    
    public String getTimeStr(){
        return this.timeStr;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public String getType(){
        return type;
    }
    public String toString(){
        return this.type + " " + this.timeStr + " " + this.amount;
    }
    
    
}
