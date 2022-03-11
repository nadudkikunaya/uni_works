/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodatester;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class SodaTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inp = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("#.##");
        double h,d;
        System.out.print("Enter height: ");
        h =  Double.parseDouble(inp.nextLine());
        System.out.print("Enter diameter: ");
        d = Double.parseDouble(inp.nextLine());
        SodaCan myCan = new SodaCan(h,d);
        System.out.println("Volume: " + df2.format(myCan.getVolume()) );
        System.out.println("Surface area: " + df2.format(myCan.getSurfaceArea()) );
        
    }
    
}
