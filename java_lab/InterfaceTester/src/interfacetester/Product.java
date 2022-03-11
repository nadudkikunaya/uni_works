/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacetester;

/**
 *
 * @author INatZ
 */
public class Product {
    private String name;
    private double price;
    public Product(String n, double p) {
        name = n;
        price = p;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
