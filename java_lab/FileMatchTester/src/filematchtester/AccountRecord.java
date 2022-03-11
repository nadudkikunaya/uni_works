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
public class AccountRecord {
    private int acctNo;
    private String name;
    private double balance;
    private int transCnt = 0; // นับว่า บัญชีนี้ทารายการ transaction ไปกี่ครั้ง
    public AccountRecord (int acctNo, String name, double balance) {
        this.acctNo = acctNo;
        this.name = name;
        this.balance = balance;
    }
    public int getAcctNo() { return acctNo; }
    public String getName() { return name; }
    public double getBalance(){ return balance; }
    public int getTransCnt() { return transCnt; }
    
    public void combine(TransactionRecord t){
        balance += t.getAmtTrans();
        transCnt++;
    }
}
