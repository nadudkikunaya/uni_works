/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdatatester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class CountDataTester {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String input = "";
        Scanner sc = new Scanner(System.in);
        String fileName = "countdata.txt";
        Scanner txt;
        File myFile = new File(fileName);
        try (PrintWriter out = new PrintWriter(fileName)) {
            // Write to file <<
            while(true){
                input = sc.nextLine();
                if(input.equals("quit"))
                    break;
                else{
                    out.println(input);
                }
            }
            out.close();
            // Read from file << 
            txt = new Scanner(myFile);
            int cntLine = 0, cntWords = 0, cntChars = 0;
            while(txt.hasNextLine()){
                cntLine++;
                String line = txt.nextLine();
                cntChars += line.toCharArray().length;
               for(char ch : line.toCharArray()){
                   if(ch == ' ' || ch == '\n'){
                       cntWords++;
                   }
               }
            }
            System.out.println("Total characters : " + cntChars);
            System.out.println("Total words : " + (cntWords + cntLine));
            System.out.println("Total lines : " + cntLine);
            
        }
                

    }
    
}
