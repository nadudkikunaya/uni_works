/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularartester;

/**
 *
 * @author INatZ
 */
public class ModularAr {
    private static int modulus = 23;
    private int n;
    public ModularAr(int number){
        n = number;
    }
    
    public ModularAr add(ModularAr other){
        int x = (this.n + other.n) % modulus;
        ModularAr newone = new ModularAr(x);
        return newone;
    }
    
    public ModularAr multiply(ModularAr other){
        int x = (this.n*other.n) % modulus;
        ModularAr newone = new ModularAr(x);
        return newone;
    }
    
    public boolean equals(ModularAr other){
        int x = this.n % modulus;
        int y = other.n % modulus;
        return x == y;
    }
}
