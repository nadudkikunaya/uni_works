/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowreturntester;

/**
 *
 * @author INatZ
 */
public class Item {
    private int id; // item ID
    private String name; // item name
    private double value; // rental price
    private int custID = -1; // customer ID (-1 means available)
// set customer ID when customer rents an item
    public Item (int ID, String n, double v) {
        id = ID;
        name = n;
        value = v;
    }
    public int getID() { return id; }
    public String getName() { return name; }
    public double getValue() { return value; }
    public int getCustID() { return custID; }
    public void setCustID(int cID) { custID = cID; }   
}
