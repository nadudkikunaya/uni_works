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
public class Account {
    private String name; // owner's name
    private String phoneNumber; // phone number
    private int callQuota; // minutes of remaining free call
    private double callRate; // calling fee (baht/minute)
    private int internetQuota; // bytes of remaining free internet
    private double internetRate; // internet fee (baht/1000 byte)
    public Account(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        callQuota = 0; callRate = 1.0;
        internetQuota = 0; internetRate = 1.0;
    }
    public String getName() { return name; }
    public String getNumber() { return phoneNumber; }
    public int getCallQuota() { return callQuota; }
    public double getCallRate() { return callRate; }
    public void setCallRate(double cRate) { callRate = cRate; }
    public void setCallQuota(int minute) { callQuota = minute; }
    public int getInternetQuota() { return internetQuota; }
    public double getInternetRate() { return internetRate; }
    public void setInternetRate(double iRate){ internetRate = iRate; }
    public void setInternetQuota(int ibyte) { internetQuota = ibyte; }
    public double call(int minute) { 
        int minuteExceed = minute - callQuota;
        if(minuteExceed > 0)
            return minuteExceed * callRate;
        else 
            callQuota -= minute;
        return 0;
    }
    public double internetConnect(int ibyte) { 
        int minuteExceed = ibyte - internetQuota;
        if(minuteExceed > 0)
            return (minuteExceed * internetRate)/1000;
        else
            internetQuota -= ibyte;
        return 0;
    }   
}
