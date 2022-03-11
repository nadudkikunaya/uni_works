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
public class Sine extends Taylor{
    
    public Sine(int k, double x){
        super(k,x);
    }
    
    public void printValue(){
        double val = Math.sin(this.getValue());
        System.out.println("Value from Math.sine() is " + val + "." );
        System.out.println("Approximated value is " + this.getApprox() + ".");   
    }
    
    public double getApprox(){
        double total = 0;
        for(int n=0;n<=this.getIteration();n++){
            total += ((Math.pow(-1, n) * Math.pow(this.getValue(), (2*n) + 1 )) / this.factorial((2*n) + 1));
        }
        return total;
    }
    
}
