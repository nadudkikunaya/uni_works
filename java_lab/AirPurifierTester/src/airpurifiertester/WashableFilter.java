/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airpurifiertester;

/**
 *
 * @author INatZ
 */
public class WashableFilter extends Filter{
    private static final int START_CAPACITY = 800;
    public WashableFilter(){
        currentCapacity = START_CAPACITY;
    }
    
    
    public void wash(){
        currentCapacity = START_CAPACITY;
    }
    
}
