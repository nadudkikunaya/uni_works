/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontester;

/**
 *
 * @author INatZ
 */
public interface Collection {
    public void add(Object e);
    public void remove(Object e);
    public boolean contains(Object e);    
    public boolean isEmpty();
    public int size();
}
