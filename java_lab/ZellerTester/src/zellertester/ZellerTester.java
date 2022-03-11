/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zellertester;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class ZellerTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int year,m,day;
        System.out.print("Enter year, month, day (e.g., 2012 3 31): ");
        year = sc.nextInt();
        m = sc.nextInt();
        day = sc.nextInt();
        Zeller zl = new Zeller(day,m,year);
        System.out.println("Day of the week is " + zl.getDayOfWeek().getString());
    }
    
}
