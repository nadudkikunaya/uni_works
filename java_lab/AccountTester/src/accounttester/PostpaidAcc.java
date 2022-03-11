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
public class PostpaidAcc extends Account{
    private double monthlyFee;
    private double exceedFee;
    private double balance;
    public PostpaidAcc(String name, String num, double mf, double callRate, double inRate){
        super(name,num);
        super.setCallRate(callRate);
        super.setInternetRate(inRate);
        monthlyFee = mf;
        balance = 0;
    }
    
    public double checkBalance(){
        return monthlyFee + exceedFee;
    }
    
    public double call(int minute) { 
        int minuteExceed = minute - this.getCallQuota();
        if(minuteExceed > 0){
            exceedFee += (minuteExceed * this.getCallRate());
            this.setCallQuota(0);
            return minuteExceed * this.getCallRate();
        }
        else 
            this.setCallQuota(this.getCallQuota()- minute);;
        return 0;
    }
    public double internetConnect(int ibyte) { 
        int minuteExceed = ibyte - this.getInternetQuota();
        if(minuteExceed > 0){
             exceedFee += ((minuteExceed * this.getInternetRate())/1000);
             this.setInternetQuota(0);
            return (minuteExceed * this.getInternetRate()/1000);
        }
        else
            this.setInternetQuota(this.getInternetQuota() - ibyte);
        return 0;
    }  
}
