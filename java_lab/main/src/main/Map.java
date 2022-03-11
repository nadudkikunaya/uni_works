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
public interface Map {
    public int size();
    public boolean isEmpty();    
    public boolean containsKey(Object key);
    public Object get(Object key);
    public Object put(Object key, Object value);
    public void remove(Object key);
}
