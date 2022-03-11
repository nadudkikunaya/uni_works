/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadjlsttester;

/**
 *
 * @author INatZ
 */
public interface List extends Collection{
    public void add(int i, Object e);
    public void removeAt(int i);
    public Object get(int i);
    public void set(int i, Object e);
}
