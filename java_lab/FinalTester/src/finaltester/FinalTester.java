/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltester;

/**
 *
 * @author INatZ
 */
public class FinalTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                ShowRoom sr = new ShowRoom("Sasipa ShowRoom");
        Car c1 = new Car ("MW1234", 5, 90000);
        System.out.println(c1.toString());
        sr.show(c1);
        Motorcycle m1 = new Motorcycle("AB22", 20000);
        System.out.println(m1.toString());
        sr.show(m1);
        Car c2 = new Car ("XX6789", 3, 80000);
        System.out.println(c2.toString());
        sr.show(c2);
        Motorcycle m2 = new Motorcycle("ZZ90", 25000);
        System.out.println(m2.toString());
        sr.show(m2);        
        sr.sell("MW1234");
        sr.sell("ZZ90");
        sr.sell("XX6789");
        System.out.println("-----------\n" + sr.getName());
        System.out.println("Numbers of car is " + sr.getNumCar());
        System.out.println("Numbers of motorcycle is " + sr.getNumMotorcycle());
        System.out.println("Income is " + sr.getIncome());  

    }
    
}
