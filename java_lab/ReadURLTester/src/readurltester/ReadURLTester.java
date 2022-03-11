/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readurltester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INatZ
 */
public class ReadURLTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String urlAddress = "https://users.cs.duke.edu/~ola/ap/linuxwords";
        String fileName = "wordlist.txt";
        File myFile = new File(fileName);
        Scanner sc_url = null;
        Scanner sc_file = null;
        PrintWriter out = null;
        
        // Write to txt
        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("Can not write to this file <<" +fileName+ ">>");
        }
        
        try {
            URL url = new URL(urlAddress);
            sc_url = new Scanner(url.openStream());
            while(sc_url.hasNext()){
                out.println(sc_url.nextLine());
            }
        } catch(MalformedURLException e){
            System.out.println("Can not access to the website");
        } catch(IOException e){
            System.out.println("Can not read data from the website");
        }
        

        out.close();
        
        // INPUT
        Scanner sc_input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc_input.nextLine();
        int cnt = 0;
        String[] inputWords;
        inputWords = input.split(" ");
        ArrayList<String> inputWordsList = new ArrayList<>(Arrays.asList(inputWords));   
        
        // Check from 
        try {
            sc_file = new Scanner(myFile);
            while(sc_file.hasNextLine()){
                String line = sc_file.nextLine();
                for(int i=0;i<inputWordsList.size();i++){
                    //cnt++;
                    //System.out.println("Compare "+cnt+" : " + line + " == " + inputWordsList.get(i));
                    if(inputWordsList.get(i).equals(line))
                        inputWordsList.remove(i);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File is not exist");
        }
        
        //OUTPUT
        System.out.println("Words not contained:");
        if(inputWordsList.isEmpty()){
            System.out.println("N/A");
        }
        else{
            for(String word : inputWordsList){
                System.out.println(word);
            }
        }
        
        
            
        
            
 
        
    }
    
}
