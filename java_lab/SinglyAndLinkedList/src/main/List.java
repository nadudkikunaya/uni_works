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
public interface List extends Collection {
  public void add(int index, Object e);
  public void remove(int index);
  public Object get(int index);
  public void set(int index, Object e);
  public int indexOf(Object e);    
}
