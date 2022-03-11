/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String open = "{[(";
        String close = "}])";
        String ch_err = "character error : ";
        String pr_err = "parentheses error : ";
        boolean invalid = false;
        FixedSizeStack st = new FixedSizeStack(input.length());
        if(close.contains(input.substring(0,1))){
           System.out.println(pr_err+input);
           String str = "";
           int j = 0; 
           while(j < pr_err.length()){ str += " "; j++; }
           System.out.println(str+"^"); 
           invalid = true;
        }
        else
        {
            for(int i = 0 ; i < input.length() ; i++){
                String ch = input.substring(i,i+1);
                if(open.contains(ch))
                    st.push(ch);
                else if(close.contains(ch)){
                    int index = close.indexOf(ch);
                    if(!st.isEmpty() && open.substring(index,index+1).equals(st.peek()) )
                        st.pop();
                    else{
                        System.out.println(pr_err+input);
                        int j = 0; String str = "";
                        while(j < i+pr_err.length()){ str += " "; j++; }
                        System.out.println(str+"^");
                        invalid = true;
                        break;
                    }
                }
                else{
                    System.out.println(ch_err+input);
                    int j = 0; String str = "";
                    while(j < i+ch_err.length()){ str += " "; j++; }
                    System.out.println(str+"^");
                    invalid = true;
                    break;
                }
            }
            if(!st.isEmpty() && !invalid ){
                System.out.println(pr_err+input);
                int j = 1; String str = "";
                while(j < input.length()+pr_err.length()){ str += " "; j++; }
                System.out.println(str+"^"); 
            }
        }
        System.out.println(!invalid);
    }
    
}
