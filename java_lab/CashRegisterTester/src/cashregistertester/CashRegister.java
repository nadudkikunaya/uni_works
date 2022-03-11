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
public class CashRegister {
    private double purchase;
    private double tax;
    final private double taxRate = 1.07;
    private double payment;
    public CashRegister() {
        purchase = 0; payment = 0; tax = 0;
    }
    public void recordPurchase(double amnt) {
        purchase += amnt;
    }
    public void recordTaxablePurchase(double amnt){
        purchase += amnt;
        tax = (amnt * taxRate) - amnt;
    }
    public double getTotalTax(){
        return tax;
    }
    public void enterPayment(double amnt) {
        payment = amnt;
    }
    public double giveChange() {
        double change = payment - (purchase + tax);
        purchase = 0;
        tax = 0;
        payment = 0;
        return change;
    }
    
}
