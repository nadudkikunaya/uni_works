/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockexam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class MockExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 1;
        while(n>0){
            n = sc.nextInt();
            arr.add(n);
        }
        //arr.remove(arr.size()-1);
        for(int i : arr){
            System.out.println(i);
        }
        
    }
    
}
