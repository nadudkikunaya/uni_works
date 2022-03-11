/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentfiletester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class StudentFileTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Registration> registList = new ArrayList<Registration> (); 
// Arraylist stores registration data
        ArrayList<String> cIDList = new ArrayList<String> ();  
// Arraylist stores registered courses. Fix 5 courses for each student
        cIDList.add("2301117");     // courseIDs are sorted
        cIDList.add("2302167");     
        cIDList.add("2303101");
        cIDList.add("2303102");
        cIDList.add("5500204"); 
        registList.add(new Registration("6334404623", cIDList));
        cIDList.clear();
        cIDList.add("2301117");     
        cIDList.add("2301170");     
        cIDList.add("2302167");
        cIDList.add("2304103"); 
        cIDList.add("5500224");     
        registList.add(new Registration("6334411023", cIDList)); 
        cIDList.clear();
        
        String fileName = "student.dat";
        File f = new File(fileName);
        RandomAccessFile r = null;

        try{
             r = new RandomAccessFile(fileName,"rw");
             for(int i=0;i<r.length();i+=48){
                String idStr = "", name = "", subj = "";
                 r.seek(i);
                 for(int j=0;j<10;j++)
                     idStr += r.readChar();
                 for(int j=0;j<10;j++)
                     name += r.readChar();
                 for(int j=0;j<4;j++)
                     subj += r.readChar();
                 System.out.println(idStr + " " + name + " " + subj);
                        
             }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}


