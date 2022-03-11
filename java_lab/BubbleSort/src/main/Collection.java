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
public interface Collection {
  public void add(Object element);
  public void remove(Object element);
  public boolean isEmpty();
  public boolean contains(Object element);
  public int size();  
}
