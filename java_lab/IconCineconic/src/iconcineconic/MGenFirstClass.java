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
public class MGenFirstClass extends MGenCard {
    private int freeTicket;
    
    public MGenFirstClass(String name) {
        super(name);
        this.freeTicket = 2;
    }
    
    public void getFreeTicket(){
        if(freeTicket == 2){
            System.out.println("You got 2 Cinema tickets");
            this.freeTicket -= this.freeTicket;
        }
        else
            System.out.println("You alreaday got the free tickets");
        System.out.println(this.toString());
        
    }
    
    @Override
    public String toString(){
        return super.toString() + "[free ticket : " + this.freeTicket + "]";
    }
    
}
