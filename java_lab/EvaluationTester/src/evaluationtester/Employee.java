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
public class Employee {
    private String name;
    private int salary;
    public Employee(String n, int s){
        name = n;
        salary = s;
    }
    
    public void setSalary(int s){
        salary = s;
    }
    
    @Override
    public String toString(){
        String txt;
        txt = name + "\nsalary = " + salary;
        return txt;
    }
    
}
