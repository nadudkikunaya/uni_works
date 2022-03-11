/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeintervaltester;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class TimeIntervalTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String start,end;
        System.out.print("Enter start time: ");
        start = sc.nextLine();
        System.out.print("Enter end time: ");
        end = sc.nextLine();
        TimeInterval tiv = new TimeInterval(start,end);
        System.out.println(tiv.getHours() + " hours " + tiv.getMinutes() + " minutes");
        
    }
    
}
