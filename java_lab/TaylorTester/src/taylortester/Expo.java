/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylortester;

/**
 *
 * @author INatZ
 */
public class Expo extends Taylor{
    public Expo(int k, double x){
        super(k,x);
    }
    
    public void printValue(){
        double val = Math.exp(this.getValue());
        System.out.println("Value from Math.exp() is  " + val + "." );
        System.out.println("Approximated value is " + this.getApprox() + ".");
    }
    
    public double getApprox(){
        double total = 0;
        for(int n=0;n<=this.getIteration();n++){
            total += (Math.pow(this.getValue(), n)  / this.factorial(n));
        }
        return total;
    }
}
