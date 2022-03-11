/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularartester;

/**
 *
 * @author INatZ
 */
public class ModularArTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModularAr md = new ModularAr(26);
        ModularAr md2 = new ModularAr(26);
        ModularAr md3 = md.add(md2);
        System.out.println(md3.equals(md2));
        
    }
    
}
