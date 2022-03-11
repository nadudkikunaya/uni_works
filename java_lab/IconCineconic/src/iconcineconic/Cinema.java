/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iconcineconic;

/**
 *
 * @author INatZ
 */
public class Cinema {
    private String name; 
    private int ticketPrice; 
    
    public Cinema (String name, int ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTicketPrice() {
        return ticketPrice;
    }
}
