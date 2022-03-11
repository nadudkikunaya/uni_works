/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author INatZ
 */
public class Staff {
    private String name;
    private int age;
    private double salary;
    public Staff(String n, int a, double sl){
        name = n;
        age = a;
        salary = sl;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void incrAge(){
        age += 1;
    }
    
    public void raiseSal(int d){
        salary += d;
    }
    
}
