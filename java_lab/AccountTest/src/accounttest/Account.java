/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttest;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class Account {
    private String accNo;
    private String accName;
    private double balance;
    enum type{deposit,withdraw}
    private ArrayList<Transaction> book = new ArrayList();
    public Account(String number, String name, double amt, String ts) {
        this.accNo = number;
        this.accName = name;
        this.balance = 0;
        this.deposit(amt, ts);
    }
    
    public Account(String number, String name){
        this.accNo = number;
        this.accName = name;
        this.balance = 0;
    }
    
    public void deposit(double amt, String ts){
        Transaction trans = new Transaction(amt,ts,type.deposit.toString());
        this.book.add(trans);
        this.balance += amt;
        
        
    }
    
    public void withdraw(double amt, String ts){
        //assert (this.balance - amt) >= 0 : "withdraw > balance" ;
        if((this.balance - amt) >= 0){
            Transaction trans = new Transaction(amt,ts,type.withdraw.toString());
            this.book.add(trans);
            this.balance -= amt;
        }
        else
            System.out.println("There's not enough money to withdraw (WITHDRAW:" + amt + " BALANCE:" + this.balance+")");

        
    }
    
    public void transfer(Account to, double amt, String ts){
        if((this.balance - amt) >= 0){
            this.withdraw(amt, ts);
            to.deposit(amt, ts);
        }
        else
            System.out.println("There's not enough money to transfer (TRANSFER:" + amt + " BALANCE:" + this.balance+")");
        
    }
    
    public void undo(String ts){
        ArrayList<Transaction> toRemove = new ArrayList();
        for(Transaction trans : this.book){
            if(trans.getTimeStr().equals(ts)){
                if(trans.getType().equals("deposit")){
                    this.balance -= trans.getAmount();
                    toRemove.add(trans);
                }
                else{
                    this.balance += trans.getAmount();
                    toRemove.add(trans);
                }
            }
        }
        for(Transaction trans : toRemove){
            book.remove(trans);
        }
        
    }
    
    public String getTransInDay(String ts){
        String transInDay = "";
        for(Transaction trans : this.book){
            if(trans.getTimeStr().equals(ts))
                transInDay += trans.toString() + "\n";
        }
        return transInDay;
    }
    
    public String toString(){
        String en = "\n";
        String myData = accName + en + accNo + en ;
        String transAll = "";
        for(Transaction trans : book){
            transAll += trans.toString() + en;
        }
        return myData + transAll;
    }
}
