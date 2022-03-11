/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitextractortester;

import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class DigitExtractorTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int num = sc.nextInt();
        DigitExtractor digit = new DigitExtractor(num);
        System.out.println(digit.nextDigit());
        System.out.println(digit.nextDigit());
        System.out.println(digit.nextDigit());
        System.out.println(digit.nextDigit());
        System.out.println(digit.nextDigit());
    }
    
}
