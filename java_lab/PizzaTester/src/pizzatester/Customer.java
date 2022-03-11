/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzatester;

/**
 *
 * @author INatZ
 */
public class Customer {
    private String name,tel;
    public Customer(String n, String t){
        this.name = n;
        this.tel = t;
    }
    
    public String getName(){
        return name;
    }
    
    public String getTel(){
        return tel;
    }
    
    public String toString(){
        return getClass().getName() + ".[name : " + this.name + ", tel : " + this.tel  + "]";
    }
}
