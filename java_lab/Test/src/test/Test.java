/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;
/*
Scanner sc = new Scanner(System.in);
System.out.println();
*/
/**
 *
 * @author INatZ
 * 0 
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      //String text = sc.nextLine();
      String text = "123 4";
      int mode = 0;
      int start = 0;
      for(int i=0;i<text.length()-1;i++){
          char ch = text.charAt(i);
          if(ch != ' ' && mode == 0){
              start = i;
              mode = 1;
          }
          else if(ch == ' ' && mode == 1){
              mode = 0;
              System.out.println(text.substring(start, i+1));
          }
          System.out.println(start);
          if(start == text.length()-1)
              System.out.println(text.charAt(i));
      }
    }


}

