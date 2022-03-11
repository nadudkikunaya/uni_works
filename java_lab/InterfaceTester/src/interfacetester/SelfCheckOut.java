/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacetester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class SelfCheckOut implements SimpleQueue{
    private ArrayList<Product> list;
    private double amount = 0;
    public SelfCheckOut(){
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(Object o){
        Product pd = (Product)o;
        list.add(pd);
        System.out.println(pd.getName() + " is added in queue");
    }
    
    @Override
    public void dequeue(){
        //System.out.println("Now playing " + list.get(0).getName());
        amount += list.get(0).getPrice();
        list.remove(0);
    }
    
    public double getAmount(){
        return amount;
    }
    
    
}
