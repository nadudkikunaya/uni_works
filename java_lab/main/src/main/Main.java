/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INatZ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap2D hm = new HashMap2D(10);
        File f = new File("input.txt");
        try {
            //input from file
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String student_no = sc.next();
                String course = sc.next();
                String grade = sc.next();
                hm.put(student_no, course, grade);
            }
            
            //remove grade from student
            for(int i = 0 ; i < 5 ; i++){
                sc = new Scanner(System.in);
                String student_no = sc.next();
                String course = sc.next();
                hm.remove(student_no,course);
            }
            
            //print student course and grade
            Object[] arr = new Object[5];
            for(int i = 0 ; i < 5 ; i++){
                System.out.print("Enter student " + (i+1) + " number:");
                arr[i] = new Scanner(System.in).next();    
            }
            for(int i = 0 ; i < 5 ; i++){
                System.out.println(arr[i] + ":" + hm.get(arr[i]));
            }
            
            //print grade
            for(int i = 0 ; i < 5 ; i++){
                System.out.print("Enter student " + (i+1) + " number , course number:");
                sc = new Scanner(System.in);  
                System.out.println(hm.get(sc.next(), sc.next()));
            }
                

            
            //System.out.println(hm.toString());
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
}
