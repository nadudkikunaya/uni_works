/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citygridtester;

import java.text.DecimalFormat;

/**
 *
 * @author INatZ
 */
public class CityGridTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CityGrid man = new CityGrid(10);
        DecimalFormat df2 = new DecimalFormat("0.00");
        int maxStep = 0;
        int sumStep = 0;
        int step = 0;
        double avg;
        for(int i=0;i<10000;i++){
            for(int j=0;j<1000;j++){
                man.walk();
                step += 1;
                if(!man.isInCity()){
                    man.reset();
                    break;
                }
            }
            if(step > maxStep)
                maxStep = step;
            sumStep += step;
            step = 0;
            
        }
        avg = (double)sumStep / 10000;
        System.out.println("Average number of steps that a person can take and is still in the city: " + df2.format(avg));
        System.out.println("Maximum number of steps that a person can take and is still in the city: " + maxStep);
    }
    
}
