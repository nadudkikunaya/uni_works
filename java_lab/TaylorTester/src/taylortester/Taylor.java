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
public abstract class Taylor {
    private int k;
    private double x;
    
    public Taylor(int a,double b){
        this.k = a;
        this.x = b;
    }
    
    public int factorial(int n){
        int total = 1;
        for(int i=0;i<n;i++){
            total += (total*i);
           //System.out.println(n + " total : " + total);
        }
        //System.out.println("------");

        return total;
    }
    
    public int getIteration(){
        return k;
    }
    
    public double getValue(){
        return x;
    }
    
    public abstract void printValue();
    public abstract double getApprox();
    
}
