/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findrecursive;

/**
 *
 * @author INatZ
 */
public class FindRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sentence s = new Sentence("Prog Tech");
        boolean b = s.find("Te");
        if (b)
            System.out.println("Found"); 
        else 
            System.out.println("Not found");
}
    
}
