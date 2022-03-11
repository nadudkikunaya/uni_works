/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorysize;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class DirectorySize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Prompt the user to enter a directory or a file
        //System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }
    
    public static String getSize(File file){
        String[] fileList = file.list();
        long total = 0;
        if(file.list() == null)
            total += file.length();
        else{
            for(String s : fileList){
                String toTravel = file.getPath()+"\\"+s;
                File f = new File(toTravel);
                //System.out.println(toTravel);
                if(f.isDirectory())
                    total += Long.parseLong(getSize(f));
                else if(f.isFile())
                    total += f.length();
            }
        }
        return String.valueOf(total);
    }
    
}
