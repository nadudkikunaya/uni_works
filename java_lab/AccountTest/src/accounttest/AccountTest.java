/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class AccountTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String trans;
        String num = "123456789012345";
        String name = "Natthawat Hayamin";
        double balance = 20000;
        Account ac = new Account(num,name,balance,"2021-03-05");
        Scanner sc = new Scanner(System.in);
        String inp = "NOINPUTYET";
        double amt;
        String ts,accNo,allData;
        while(!"S".equals(inp)){
            inp = sc.next();
            
            switch(inp){
                case "D":
                    amt = sc.nextInt();
                    ts = sc.next();
                    ac.deposit(amt, ts);
                    break;
                case "W":
                    amt = sc.nextInt();
                    ts = sc.next();
                    ac.withdraw(amt, ts);
                    break;
                case "T":
                    accNo = sc.next();
                    amt = sc.nextInt();
                    ts = sc.next();
                    Account ac2 = new Account(accNo,"WHOEVER");
                    ac.transfer(ac2, amt, ts);
                    break;
                case "R":
                    ts = sc.next();
                    ac.undo(ts);
                    break;
                case "Q":
                    ts = sc.next();
                    trans = ac.getTransInDay(ts);
                    System.out.println(trans);
                    break;
                case "P":
                    allData  = ac.toString();
                    System.out.println(allData);
                    break;
                case "S":
                    break;
                default:
                    System.out.println("Input not valid, Please try again!");
            }
            
        }

    }

    
}
