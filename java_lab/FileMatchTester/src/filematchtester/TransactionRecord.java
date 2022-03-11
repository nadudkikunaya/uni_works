/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filematchtester;

/**
 *
 * @author INatZ
 */
public class TransactionRecord {
    private int acctNo;
    private double amtOfTrans;
    public TransactionRecord(int no, double amt){
        this.acctNo = no;
        this.amtOfTrans = amt;
    }
    
    public int getAccNo() { return acctNo; }
    public double getAmtTrans() { return amtOfTrans; }
    
}
