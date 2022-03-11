/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class Exam {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) { 
         Scanner inp = new Scanner(System.in); 
         String word = inp.nextLine(); 
         switch (word) { 
            case "start": 
                System.out.println("A"); 
            case "stop": 
                System.out.println("B"); 
            default: 
                System.out.println("C"); 
         } 
      } 
}
