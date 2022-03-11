/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of disks : ");
        int n = inp.nextInt();
        moveDisks(n, 'A', 'B', 'C'); // (จำนวนจาน, เสาต้นทาง, เสาพัก, เสาปลายทาง)
    }
// เขียน method moveDisks()

    private static void moveDisks(int n, char c, char c0, char c1) {
        if(n>=1){
            moveDisks(n-1,c,c1,c0);
            System.out.println("Move "+ (n) +" from "+ c +" to "+ c1 );
            moveDisks(n-1,c0,c,c1);
        }
        
    }
    
}
    
