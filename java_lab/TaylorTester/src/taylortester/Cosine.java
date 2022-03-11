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
public class Cosine extends Taylor{
    public Cosine(int k, double x){
        super(k,x);
    }
    
    @Override
    public void printValue(){
        double val = Math.cos(this.getValue());
        System.out.println("Value from Math.cos() is " + val + "." );
        System.out.println("Approximated value is " + this.getApprox() + ".");   
    }
    
    @Override
    public double getApprox(){
        double total = 0;
        for(int n=0;n<=this.getIteration();n++){
            total += ((Math.pow(-1, n) * Math.pow(this.getValue(),2*n)) / this.factorial(2*n));
        }
        return total;
    }
    
}
