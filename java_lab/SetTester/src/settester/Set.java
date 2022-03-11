/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settester;

/**
 *
 * @author INatZ
 */
public interface Set {
    public void add(Object e);
    public void remove(Object e);
    public boolean contains(Object e);    
    public boolean isEmpty();
    public ArraySet union(Set s);
    public ArraySet intersection(Set s);
    public boolean equals(Set s);
}
