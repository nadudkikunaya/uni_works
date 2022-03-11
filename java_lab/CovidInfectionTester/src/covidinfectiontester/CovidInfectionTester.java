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

public class CovidInfectionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CovidInfection model = new CovidInfection(120);
        int i;
        double r = 2.8;
        for(i=0;i<=30;i++){
            if(i==15)
                r = model.shutdown();
            else if(i == 20)
                r = model.openup();
            System.out.println("Day " + i + "(r0=" + r + ") : " + model.getNumInfected());
            model.spread();
        }
    } 
}

