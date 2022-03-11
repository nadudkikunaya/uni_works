/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzatester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class Order {
    public static int cntOrder = 0;
    private int id;
    private Customer c;
    private ArrayList<Pizza> p;
    
    public Order(Customer ctm){
        cntOrder++;
        this.c = ctm;
        id = cntOrder;
        p = new ArrayList<>();
    }
    
    public void addPizza(Pizza pz){
        p.add(pz);
    }
    
    public String getOrderDetail(){
        String detail = "Order id : " + this.id + "\n";
        if(c instanceof GoldCustomer){
            GoldCustomer gctm = (GoldCustomer)c;
            detail += c.getName() + " tel : " + c.getTel() + " discount : " + gctm.getDiscount() + "\n";
        }
        else if(c instanceof Customer){
                detail += c.getName() + " tel : " + c.getTel() + "\n";
        }
        for(Pizza each : p){
            if(each instanceof PizzaSpecial){
                PizzaSpecial spc = (PizzaSpecial)each;
                detail += each.getName() + " price : " + each.getPrice() + " special : " + spc.getSpecial() + "\n";
            }
            else if(each instanceof Pizza){
                detail += each.getName() + " price : " + each.getPrice() + "\n";
            }
        }
        detail += 
                "Total pieces : " + p.size() + "\n" +
                "Total cost : " + this.calculatePayment();
        
        return detail;
    }
    
    public double calculatePayment(){
        double total = 0;
        if(c instanceof GoldCustomer){
            GoldCustomer gctm = (GoldCustomer)c;
            for(Pizza each : p){
                total += (each.getPrice() * (100 - gctm.getDiscount())) / 100;
            }
        }
        else if(c instanceof Customer){
            for(Pizza each : p){
                total += each.getPrice();
            }
        }
        return total;
    }
    /*  
    public String toString(){
        String str = getClass().getName() + 
                ".[id : " + this.id + "]" + "\n" +
                c.toString() + "\n" + "Pizza : ";
        for(Pizza each : p){
            str += "\n" + each.toString();
        }
        return str;
    }
    */
}
