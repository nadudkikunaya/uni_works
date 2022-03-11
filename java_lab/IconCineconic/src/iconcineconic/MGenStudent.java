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
public class MGenStudent extends MGenCard {
    private static int discount = 20;
    
    public MGenStudent(String name) {
        super(name);
    }
    
    @Override
    public void buyTicket(Cinema cnm, int amt){
        int total = cnm.getTicketPrice() * amt;
        double dc = (total * 20) / 100 ;
        super.buyTicket(cnm, amt);
        System.out.println("You got " + dc + " discount");
    }
    
    
    
    
}
