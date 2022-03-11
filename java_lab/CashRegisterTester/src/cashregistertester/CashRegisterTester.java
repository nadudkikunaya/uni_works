/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregistertester;

/**
 *
 * @author INatZ
 */
public class CashRegisterTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CashRegister machine = new CashRegister();
        machine.recordPurchase(50);
        machine.recordPurchase(10);
        machine.recordTaxablePurchase(20);
        machine.enterPayment(100);
        System.out.println("Your change is " + (float) machine.giveChange());
    }
    
}
