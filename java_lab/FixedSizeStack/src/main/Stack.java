/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author INatZ
 */
public interface Stack {
    public boolean isEmpty();  
    public int size();          
    public void push(Object e); 
    public Object pop();       
    public Object peek();        
}
