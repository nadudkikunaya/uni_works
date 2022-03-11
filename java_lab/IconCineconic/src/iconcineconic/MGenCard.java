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
public class MGenCard {
    public static int memberFee = 150; 
    public static int cnt = 0; 
    private int number; 
    private String name; 
    private int point; 
    
    public MGenCard(String name) {
        cnt++;
        this.number = cnt;
        this.name = name;
    }
    
    public void usePoint() {
        if (point >= 20) {
            System.out.println("You got a free Cinema ticket");
            point -= 20;
        }
        else
            System.out.println("You don't have enough points");
        System.out.println(toString());
    }
    
    public void buyTicket(Cinema cnm, int amt){
        int total = amt * cnm.getTicketPrice();
        this.point += total / 50 ;
        System.out.println(cnm.getName() + " Total amount : " + total);
        System.out.println(toString());
    }
    
    @Override
    public String toString(){
        String str = getClass().getName() + "[number : " + this.number + ", name : " + this.name + ", point : " + this.point + "]" ;
        return str;
    }
    
    
    
    
}
