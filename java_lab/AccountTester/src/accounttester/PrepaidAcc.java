/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttester;

/**
 *
 * @author INatZ
 */
public class PrepaidAcc extends Account{
    private double balance;
    public PrepaidAcc(String name, String num, double callRate, double inRate){
        super(name,num);
        super.setCallRate(callRate);
        super.setInternetRate(inRate);
        balance = 0;
        
    }
    public void load(int amt){
        balance += amt;
    }
    
    public double checkBalance(){
        return balance;
    }
    
    public double call(int minute) { 
        int minuteExceed = minute - this.getCallQuota();
        if(minuteExceed > 0){
            balance = balance - (minuteExceed * this.getCallRate());
            return minuteExceed * this.getCallRate();
        }
        else 
            this.setCallQuota(this.getCallQuota()-minute);;
        return 0;
    }
    public double internetConnect(int ibyte) { 
        int minuteExceed = ibyte - this.getInternetQuota();
        if(minuteExceed > 0){
             balance = balance - ((minuteExceed * this.getInternetRate())/1000);
            return (minuteExceed * this.getInternetRate()/1000);
        }
        else
            this.setInternetQuota(this.getInternetQuota() - ibyte);
        return 0;
    }  
}
