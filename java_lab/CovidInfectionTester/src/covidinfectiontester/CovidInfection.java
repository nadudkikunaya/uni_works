/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidinfectiontester;

/**
 *
 * @author INatZ
 */
public class CovidInfection {
    private double r0 = 2.8;
    private long patient = 0;
    
    CovidInfection(long BeginningPatient){
        this.patient = BeginningPatient;
    }

    public void spread(){
        this.patient *= r0;
    }
    
    public double shutdown(){
        this.r0 = this.r0/2;
        return this.r0;
    }
    
    public double openup(){
        this.r0 = 2.8;
        return this.r0;
    }
    
    public long getNumInfected(){
        return this.patient;
    }
    
}
