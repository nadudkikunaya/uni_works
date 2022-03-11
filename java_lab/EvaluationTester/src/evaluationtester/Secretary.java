/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluationtester;

/**
 *
 * @author INatZ
 */
public class Secretary extends Employee implements Evaluation{
    private int typingSpeed;
    private int[] score;

    /**
     *
     * @param n
     * @param s
     * @param sc
     * @param tsp
     */
    public Secretary(String n, int s, int[] sc, int tsp){
        super(n,s);
        score = sc;
        typingSpeed = tsp;
    }
    
    @Override
    public double evaluate(){
        double total = 0;
        for(int sc : score){
            total += sc;
        }
        return total;
    }
    
    @Override
    public char grade(double g){
        if(g >= 90){
            this.setSalary(18000);
            return 'P';
        }
        else{
            return 'F';
        }
    }
}
