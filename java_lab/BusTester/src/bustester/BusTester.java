/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bustester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class BusTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Bus> arr = new ArrayList<>();
        Hybrid hyb_bus = new Hybrid(45, 1200000, Electric.HIGH_VOLTAGE, 150, 1);
        arr.add(hyb_bus);
        CNGBus cng_bus = new CNGBus(50, 1000000, 200, 2);
        arr.add(cng_bus);
        
        for(Bus bus : arr){
            System.out.println("ID: " + bus.getID());
            if(bus instanceof CNGBus){
                CNGBus b = (CNGBus)bus;
                System.out.println("Emission Tier: " + b.getEmissionTier() );
                System.out.println("Accel: " + b.getAccel());
            }
            else if(bus instanceof Hybrid){
                Hybrid b = (Hybrid)bus;
                System.out.println("Emission Tier: " + b.getEmissionTier());
                System.out.println("Accel: " + b.getAccel());
            }
        }
        
    }
    
}
